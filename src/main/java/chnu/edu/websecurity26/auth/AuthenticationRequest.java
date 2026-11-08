package chnu.edu.websecurity26.auth;

/*
  @author   nzon
  @project   web-security26
  @class  AuthenticationRequest
  @version  1.0.0 
  @since 08/11/2026 - 10.31
*/

import lombok.Data;
import lombok.NonNull;

@Data
public class AuthenticationRequest {
    @NonNull
    private String email;
    @NonNull
    private String password;
}
