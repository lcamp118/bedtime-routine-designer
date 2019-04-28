package com.lynelleherrera.bedtimeroutinedesigner.Configuration;

import com.lynelleherrera.bedtimeroutinedesigner.Models.Data.MyUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MyUserDao myUserDao;

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/resources/**", "/", "/user/*", "/logout/*").permitAll()
                .antMatchers("/routines/*", "/activity/*").hasAuthority("USER")
                .antMatchers("/**").hasAuthority("USER")

                .and()
                .formLogin()
                .loginPage("/user/signin")
                .loginProcessingUrl("/user/signin")
                .failureUrl("/user/signin?error")
//                .usernameParameter("username")
//                .passwordParameter("password")
                .defaultSuccessUrl("/routine/index")
                .permitAll()

                .and()
                .httpBasic()

                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/signin")

                .and()
                .csrf()
                .disable();

    }

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return myUserDao.findByUsername(username);
            }
        });

    }
//
//    @Bean
//    @Override
//    public UserDetailsManager userDetailsService() {
//        InMemoryUserDetailsManager manager = new
//                InMemoryUserDetailsManager();
//        manager.createUser(
//                User.withUsername("user1@example.com")
//                        .password("user1").roles("USER").build());
//        manager.createUser(
//                User.withUsername("admin1@example.com")
//                        .password("admin1").roles("USER", "ADMIN").build());
//        return manager;
//    }
}
