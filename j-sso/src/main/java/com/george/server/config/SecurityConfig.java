package com.george.server.config;

import com.george.server.service.CustomOAuth2UserService;
import com.george.server.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity(debug = true)
@RequiredArgsConstructor
@Configuration(proxyBeanMethods = false)
public class SecurityConfig {
    private final CustomOAuth2UserService customOAuth2UserService;
    private final CustomUserDetailsService userDetailService;

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        SocialConfigurator configurator = new SocialConfigurator()
                .oAuth2UserService(customOAuth2UserService);
        http.apply(configurator);

        http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailService);

        http.authorizeHttpRequests(authorize ->
                authorize.anyRequest().authenticated()
        );
        return http.formLogin(withDefaults()).build();
    }

}
