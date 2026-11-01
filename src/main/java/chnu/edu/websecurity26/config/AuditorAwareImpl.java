package chnu.edu.websecurity26.config;

/*
  @author   nzon
  @project   web-security26
  @class  AuditorAwareImpl
  @version  1.0.0 
  @since 01/11/2026 - 09.40
*/

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Admin");
    }
}
