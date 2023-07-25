//package com.example.demo.config.security;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//
//@Configuration
//@EnableWebSecurity
//public class ProjectSecurityConfig {
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails user1 = User.withUsername("user1")
//                .password(passwordEncoder().encode("user1pass"))
//                .roles("USER")
//                .build();
//        UserDetails admin = User.withUsername("admin")
//                .password(passwordEncoder().encode("adminPass"))
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user1,  admin);
//    }
//
//    @Bean
//    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .csrf(x -> x.disable())
//
//                .authorizeHttpRequests(
//                        requests ->
//                                requests.requestMatchers("/cards","/swagger-ui/index.html").authenticated()
//                                        .requestMatchers("/users","/users/signup","/users/signin","/message/send","/message","/channel","/channel/create","/message/channelsend","/swagger-ui/index.html","/swagger-ui").permitAll()
//
//                )
//                .formLogin(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults());
//        return httpSecurity.build();
//    }
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();}
//}
