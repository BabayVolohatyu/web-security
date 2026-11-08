package chnu.edu.websecurity26;

/*
  @author   nzon
  @project   web-security26
  @class  AccessTests
  @version  1.0.0 
  @since 01/11/2026 - 16.15
*/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("test")
public class AccessTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    void beforeEach() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(springSecurity())
                .build();
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
    void adminCanReadAdminHello() throws Exception {
        assertOk("/api/v1/items/hello/admin", "Hello Admin!");
    }

    @Test
    @WithMockUser(username = "user", password = "user", roles = {"USER"})
    void userCannotReadAdminHello() throws Exception {
        assertDenied("/api/v1/items/hello/admin", 403, "Forbidden");
    }

    @Test
    @WithMockUser(username = "superadmin", password = "superadmin", roles = {"SUPERADMIN"})
    void superadminCannotReadAdminHello() throws Exception {
        assertDenied("/api/v1/items/hello/admin", 403, "Forbidden");
    }

    @Test
    @WithMockUser(username = "user", password = "user", roles = {"USER"})
    void userCanReadUserHello() throws Exception {
        assertOk("/api/v1/items/hello/user", "Hello!, user");
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
    void adminCannotReadUserHello() throws Exception {
        assertDenied("/api/v1/items/hello/user", 403, "Forbidden");
    }

    @Test
    @WithMockUser(username = "superadmin", password = "superadmin", roles = {"SUPERADMIN"})
    void superadminCannotReadUserHello() throws Exception {
        assertDenied("/api/v1/items/hello/user", 403, "Forbidden");
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
    void adminCanReadStaffHello() throws Exception {
        assertOk("/api/v1/items/hello/man", "Hello, man!");
    }

    @Test
    @WithMockUser(username = "superadmin", password = "superadmin", roles = {"SUPERADMIN"})
    void superadminCanReadStaffHello() throws Exception {
        assertOk("/api/v1/items/hello/man", "Hello, man!");
    }

    @Test
    @WithMockUser(username = "user", password = "user", roles = {"USER"})
    void userCannotReadStaffHello() throws Exception {
        assertDenied("/api/v1/items/hello/man", 403, "Forbidden");
    }

    @Test
    @WithAnonymousUser
    void anonymousCannotReadAdminHello() throws Exception {
        assertDenied("/api/v1/items/hello/admin", 403, "Forbidden");
    }

    private void assertOk(String path, String body) throws Exception {
        var response = mockMvc.perform(get(path)).andReturn().getResponse();
        assertEquals(200, response.getStatus());
        assertEquals(body, response.getContentAsString());
    }

    private void assertDenied(String path, int status, String message) throws Exception {
        var response = mockMvc.perform(get(path)).andReturn().getResponse();
        assertEquals(status, response.getStatus());
        assertNotNull(response.getErrorMessage());
        assertEquals(message, response.getErrorMessage());
    }
}
