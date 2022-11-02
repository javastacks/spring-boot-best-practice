package cn.javastack.springboot.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests((authorize) -> {
                    authorize.requestMatchers("/**").permitAll()
                            .requestMatchers("/test/**").hasRole("TEST");
                })
                .logout().logoutSuccessUrl("/")
                .and().formLogin(withDefaults())
                .build();
    }

    @Bean
    protected UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("test").password("{noop}test")
                .roles("ADMIN", "TEST").build());
        manager.createUser(User.withUsername("root").password("{noop}root")
                .roles("ADMIN").build());
        return manager;
    }

}