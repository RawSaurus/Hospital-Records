package com.example.hospitalrecords.config;

import com.example.hospitalrecords.role.model.Permission;
import com.example.hospitalrecords.role.model.RoleType;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{ //TODO delete request matchers from the filterchain and implement them on class and method level

        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req ->
                        req.requestMatchers("/api/v1/auth/**")
                        .permitAll()

                                .requestMatchers("/doctor/**").hasAnyRole(RoleType.ADMIN.name(), RoleType.DOCTOR.name())
                                .requestMatchers(HttpMethod.GET, "/doctor/**").hasAnyAuthority(Permission.ADMIN_READ.name(),Permission.DOCTOR_READ.name() )
                                .requestMatchers(HttpMethod.POST, "/doctor/**").hasAnyAuthority(Permission.ADMIN_CREATE.name(),Permission.DOCTOR_CREATE.name() )
                                .requestMatchers(HttpMethod.PUT, "/doctor/**").hasAnyAuthority(Permission.ADMIN_UPDATE.name(),Permission.DOCTOR_UPDATE.name() )
                                .requestMatchers(HttpMethod.DELETE, "/doctor/**").hasAnyAuthority(Permission.ADMIN_DELETE.name(),Permission.DOCTOR_DELETE.name() )
                                .requestMatchers("/receptionist/**").hasAnyRole(RoleType.ADMIN.name(), RoleType.RECEPTIONIST.name())
                                .requestMatchers(HttpMethod.GET, "/receptionist/**").hasAnyAuthority(Permission.ADMIN_READ.name(),Permission.RECEPTIONIST_READ.name() )
                                .requestMatchers(HttpMethod.POST, "/receptionist/**").hasAnyAuthority(Permission.ADMIN_CREATE.name(),Permission.RECEPTIONIST_CREATE.name() )
                                .requestMatchers(HttpMethod.PUT, "/receptionist/**").hasAnyAuthority(Permission.ADMIN_UPDATE.name(),Permission.RECEPTIONIST_UPDATE.name() )
                                .requestMatchers(HttpMethod.DELETE, "/receptionist/**").hasAnyAuthority(Permission.ADMIN_DELETE.name(),Permission.RECEPTIONIST_DELETE.name() )
                                .requestMatchers("/admin/**").hasRole(RoleType.ADMIN.name())
                                .requestMatchers(HttpMethod.GET, "/admin/**").hasAuthority(Permission.ADMIN_READ.name())
                                .requestMatchers(HttpMethod.POST, "/admin/**").hasAuthority(Permission.ADMIN_CREATE.name())
                                .requestMatchers(HttpMethod.PUT, "/admin/**").hasAuthority(Permission.ADMIN_UPDATE.name())
                                .requestMatchers(HttpMethod.DELETE, "/admin/**").hasAuthority(Permission.ADMIN_DELETE.name())
                        .anyRequest()
                        .authenticated() )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .logout(logout ->
                        logout.logoutUrl("/api/v1/auth/logout")
                                .addLogoutHandler(logoutHandler)
                                .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
                        )
        ;

        return http.build();
    }

}
