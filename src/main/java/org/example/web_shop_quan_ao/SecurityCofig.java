//package org.example.web_shop_quan_ao;
//
//import org.example.web_shop_quan_ao.Seviece.CustomUserDetailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityCofig {
//    @Autowired
//    private CustomUserDetailService customUserDetailService;
//    @Bean
//    BCryptPasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//    @Bean
//    SecurityFilterChain securityFilterChainUser(HttpSecurity http ) throws Exception{
//        http.csrf(csrf->csrf.disable()).authorizeHttpRequests((auth)->auth.
//                        requestMatchers("/static/**", "/fe/**", "/assets/**").permitAll().
//                        requestMatchers("/*").permitAll().
//                        requestMatchers("/home/**").hasAuthority("USER").
//                        anyRequest().authenticated())
//                .formLogin(login->login
//                        .loginPage("/userlogin")
//                        .loginProcessingUrl("/userlogin").
//                        usernameParameter("username")
//                        .passwordParameter("password").
//                        defaultSuccessUrl("/home/user",true))
//                .logout(logout->logout.logoutUrl("/user-logout").logoutSuccessUrl("/userlogin"));
//        return http.build();
//    }
//
//    @Bean
//    WebSecurityCustomizer webSecurityCustomizer(){
//        return (web)->web.ignoring().requestMatchers("/static/**","/fe/**","/assets/**");
//    }
//
//}
