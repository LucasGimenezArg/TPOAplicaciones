package com.uade.tpo.ecommerce.security;

import com.uade.tpo.ecommerce.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

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
                        .authorizeHttpRequests(req -> req
                                .requestMatchers("/api/usuario/normal").permitAll()
                                .requestMatchers("/api/usuario/login").permitAll()
                                .requestMatchers("/api/usuario/admin").hasAnyAuthority(Usuario.ROL_ADMIN)
                                .requestMatchers("/api/producto/list").hasAnyAuthority(Usuario.ROL_ADMIN, Usuario.ROL_NORMAL)
                                .requestMatchers("/api/producto/destacados").permitAll()
                                .requestMatchers("/api/producto/categorias").permitAll()
                                .requestMatchers("/api/producto/{id}").hasAnyAuthority(Usuario.ROL_ADMIN, Usuario.ROL_NORMAL)
                                .requestMatchers("/api/producto/add").hasAnyAuthority(Usuario.ROL_ADMIN)
                                .requestMatchers("/api/producto/categoria/add").hasAnyAuthority(Usuario.ROL_ADMIN)
                                .requestMatchers("/api/carrito/**").hasAnyAuthority(Usuario.ROL_ADMIN, Usuario.ROL_NORMAL)
                                .requestMatchers("/error").anonymous()
                                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                                .anyRequest().permitAll()
                        )
                        .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
                        .authenticationProvider(authenticationProvider)
                        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                        .cors(cors -> cors.configurationSource(corsConfigurationSource()));

                return http.build();
        }

        @Bean
        public org.springframework.web.cors.CorsConfigurationSource corsConfigurationSource() {
                org.springframework.web.cors.CorsConfiguration configuration = new org.springframework.web.cors.CorsConfiguration();
                configuration.setAllowedOrigins(List.of("http://localhost:3000"));
                configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
                configuration.setAllowedHeaders(List.of("*"));
                configuration.setAllowCredentials(true);

                org.springframework.web.cors.UrlBasedCorsConfigurationSource source = new org.springframework.web.cors.UrlBasedCorsConfigurationSource();
                source.registerCorsConfiguration("/**", configuration);
                return source;
        }
}
