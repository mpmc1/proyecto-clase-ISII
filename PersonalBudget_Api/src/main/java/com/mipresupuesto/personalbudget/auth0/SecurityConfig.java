package com.mipresupuesto.personalbudget.auth0;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.oidc.authentication.OidcIdTokenDecoderFactory;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoderFactory;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig {

    private final LogoutHandler logoutHandler;

    public SecurityConfig(LogoutHandler logoutHandler) {
        this.logoutHandler = logoutHandler;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	return http.authorizeRequests()
                // allow all users to access the home pages and the static images directory
                .mvcMatchers("/", "/images/**").permitAll()
                // all other requests must be authenticated
                .anyRequest().authenticated()
                .and().oauth2Login()
                .and().logout()
                //handle logout requests at /logout path
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                // customize logout handler to log out of Auth0
                .addLogoutHandler(logoutHandler).and().build();
    }

// If using HS256, create a Bean to specify the HS256 should be used. By default, RS256 will be used.
    @Bean
    public JwtDecoderFactory<ClientRegistration> idTokenDecoderFactory() {
        OidcIdTokenDecoderFactory idTokenDecoderFactory = new OidcIdTokenDecoderFactory();
        idTokenDecoderFactory.setJwsAlgorithmResolver(clientRegistration -> MacAlgorithm.HS256);
        return idTokenDecoderFactory;
    }
}
