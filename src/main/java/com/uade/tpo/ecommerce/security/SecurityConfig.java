package com.uade.tpo.ecommerce.security;

import com.uade.tpo.ecommerce.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

        private final JwtAuthenticationFilter jwtAuthFilter;
        private final AuthenticationProvider authenticationProvider;

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                .csrf(AbstractHttpConfigurer::disable)
                                .authorizeHttpRequests(req -> req.requestMatchers("/api/usuario/normal").permitAll()
                                                .requestMatchers("/api/usuario/login").permitAll()
                                                .requestMatchers("/api/usuario/admin").hasAnyAuthority(Usuario.ROL_ADMIN)
                                                .requestMatchers("/api/producto/list").hasAnyAuthority(Usuario.ROL_ADMIN, Usuario.ROL_NORMAL)
                                                .requestMatchers("/api/producto/{id}").hasAnyAuthority(Usuario.ROL_ADMIN, Usuario.ROL_NORMAL)
                                                .requestMatchers("/api/producto/add").hasAnyAuthority(Usuario.ROL_ADMIN)
                                                .requestMatchers("/api/producto/categoria/add").hasAnyAuthority(Usuario.ROL_ADMIN)
                                                .requestMatchers("/api/carrito/**").hasAnyAuthority(Usuario.ROL_ADMIN, Usuario.ROL_NORMAL)
                                                .requestMatchers("/error").anonymous()
                                                .anyRequest()
                                                .authenticated())
                                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
                                .authenticationProvider(authenticationProvider)
                                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
                return http.build();
        }

}
