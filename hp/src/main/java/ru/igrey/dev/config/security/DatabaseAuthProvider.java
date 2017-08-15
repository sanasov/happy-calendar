package ru.igrey.dev.config.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * Created by Sergey Anasov on 15.08.2017.
 * <p>
 * Провайдер, логинит пользователя из базы
 */
public class DatabaseAuthProvider implements AuthenticationProvider {

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = String.valueOf(authentication.getPrincipal());
        if (login.equals("igrey")) {
            throw new BadCredentialsException("Bad user");
        }
        return new UsernamePasswordAuthenticationToken(
                authentication.getPrincipal(),
                authentication.getCredentials(), authentication
                .getAuthorities()
        );
    }

    public boolean supports(Class<?> authentication) {
        return true;
    }
}
