package chnu.edu.websecurity26.auth;

/*
  @author   nzon
  @project   web-security26
  @class  AuthenticationResponse
  @version  1.0.0 
  @since 08/11/2026 - 10.31
*/

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationResponse {
    private String token;
}
