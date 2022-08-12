package cn.javastack.springboot.actuator;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * 微信公众号：Java技术栈
 */
@Configuration
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeRequests()
                .antMatchers("/").permitAll()
                .requestMatchers(EndpointRequest.to("health")).hasRole("ENDPOINT_ADMIN")
                .requestMatchers(EndpointRequest.toAnyEndpoint()).permitAll()
//                .and().csrf(csrf -> csrf.disable())
                .and().csrf(csrf -> csrf.ignoringRequestMatchers(EndpointRequest.toAnyEndpoint()))
                .formLogin(withDefaults())
                .logout().logoutSuccessUrl("/")
                .and().build();
    }

    @Bean
    protected UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("test").password("{noop}test")
                .roles("ENDPOINT_ADMIN", "ADMIN", "TEST").build());
        manager.createUser(User.withUsername("root").password("{noop}root")
                .roles("ADMIN").build());
        return manager;
    }

}
