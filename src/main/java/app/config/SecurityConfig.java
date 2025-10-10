package app.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
@Log4j2
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        log.info("Password encoded for 'academy': {}", passwordEncoder().encode("academy"));

        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/animes/admin/**").hasRole("ADMIN")
                        .requestMatchers("/animes/**").hasRole("USER")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> {})
                .httpBasic(basic -> {});

        return http.build();
    }


    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(PasswordEncoder passwordEncoder) {
        UserDetails william = User.withUsername("william2")
                .password(passwordEncoder.encode("academy"))
                .roles("USER", "ADMIN")
                .build();

        UserDetails devdojo = User.withUsername("devdojo2")
                .password(passwordEncoder.encode("academy"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(william, devdojo);
    }


}