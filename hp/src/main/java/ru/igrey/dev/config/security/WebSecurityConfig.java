package ru.igrey.dev.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(new DatabaseAuthProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()

                .sessionManagement()
                .sessionAuthenticationStrategy((authentication, httpServletRequest, httpServletResponse) ->
                        httpServletRequest.getSession().setMaxInactiveInterval(7200)
                )

                .and()
                .authorizeRequests()
                .antMatchers("/resources/**", "/login", "/logout", "/authorization").permitAll()
                .antMatchers("/**").access("hasRole('ROLE_ADMIN')")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/403")

                .and()
                .formLogin()
                .defaultSuccessUrl("/", false)
                .loginPage("/login").permitAll()
                .loginProcessingUrl("/authenticate")

                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .invalidateHttpSession(true);
    }

}
