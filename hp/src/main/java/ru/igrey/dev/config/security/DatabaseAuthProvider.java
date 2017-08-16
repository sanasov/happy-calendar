package ru.igrey.dev.config.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import ru.igrey.dev.domain.User;
import ru.igrey.dev.repository.UserRepository;

import java.util.stream.Collectors;

/**
 * Created by Sergey Anasov on 15.08.2017.
 * <p>
 * Провайдер, логинит пользователя из базы
 */
public class DatabaseAuthProvider implements AuthenticationProvider {

    private UserRepository userRepository;

    public DatabaseAuthProvider(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = String.valueOf(authentication.getPrincipal());
        User user = userRepository.findByLogin(login);
        if (user == null) {
            throw new BadCredentialsException("Bad user");
        }
        return new UsernamePasswordAuthenticationToken(
                authentication.getPrincipal(),
                authentication.getCredentials(),
                user.getRoles().stream()
                        .map(role -> new SimpleGrantedAuthority(role))
                        .collect(Collectors.toList())
        );
    }

    public boolean supports(Class<?> authentication) {
        return true;
    }
}
