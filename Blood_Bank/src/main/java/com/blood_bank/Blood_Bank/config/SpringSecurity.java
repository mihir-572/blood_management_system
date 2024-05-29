package com.blood_bank.Blood_Bank.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests((authorize) ->
                        authorize.requestMatchers("/register/**").permitAll()
                                .requestMatchers("").permitAll()
                                .requestMatchers("/index").permitAll()
                                .requestMatchers("/contactus").permitAll()
                                .requestMatchers("/aboutus").permitAll()
                                .requestMatchers("/addbank/**").permitAll()
                                .requestMatchers("/addbloodinbank").permitAll()
                                .requestMatchers("/addevent").permitAll()
                                .requestMatchers("/allBankInfo/**").permitAll()
                                .requestMatchers("/allDonors").permitAll()
                                .requestMatchers("/allDonorAppointments").permitAll()
                                .requestMatchers("/allevents").permitAll()
                                .requestMatchers("/allRecipients").permitAll()
                                .requestMatchers("/allRecipientAppointments").permitAll()
                                .requestMatchers("/bankadded").permitAll()
                                .requestMatchers("/BloodRecordInserted").permitAll()
                                .requestMatchers("/ContactUsSubmitted").permitAll()
                                .requestMatchers("/donor/**").permitAll()
                                .requestMatchers("/donorAppointment").permitAll()
                                .requestMatchers("/donorAppointmentSubmitted").permitAll()
                                .requestMatchers("/donorRegistered").permitAll()
                                .requestMatchers("/eventadded").permitAll()
                                .requestMatchers("/recipient/**").permitAll()
                                .requestMatchers("/recipientAppointment").permitAll()
                                .requestMatchers("/recipientAppointmentSubmitted").permitAll()
                                .requestMatchers("/recipientRegistered").permitAll()
                                .requestMatchers("/register").permitAll()
                                .requestMatchers("/bankbloodinfo/**").permitAll()
                                .requestMatchers("/event/newevent").permitAll()
                                .requestMatchers("/edit/**").permitAll()
                                .requestMatchers("/home").hasRole("ADMIN")
                                .requestMatchers("/resources/**").permitAll()
                                .requestMatchers("/static/**").permitAll()
                                .requestMatchers("/**").permitAll()

                ).formLogin(
                        form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/home")
//                                .permitAll()
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                );
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
}
