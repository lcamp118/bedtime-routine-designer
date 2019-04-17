package com.lynelleherrera.bedtimeroutinedesigner.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user1@example.com").password("user1").roles("USER")
        .and().withUser("admin1@example.com").password("admin1").roles("USER","ADMIN");
    }
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/").hasAnyRole("ANONYMOUS","USER")
                .antMatchers("/user/*").hasAnyRole("ANONYMOUS","USER")
                .antMatchers("/logout/*").hasAnyRole("ANONYMOUS","USER")
                .antMatchers("/routines/*").hasRole("USER")
                .antMatchers("/activity/*").hasRole("USER")
                .antMatchers("/admin/*").hasRole("ADMIN")
                .antMatchers("/allroutines/").hasRole("ADMIN")
                .antMatchers("/**").hasRole("USER")

                .and()
                .formLogin()
                    .loginPage("/user/signin")
                    .loginProcessingUrl("/user/signin")
                    .failureUrl("/user/signin?error")
                    .usernameParameter("username")
                    .passwordParameter("password")

                .and()
                .httpBasic()

                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/signin?logout")

                .and()
                .csrf()
                .disable();

    }

}
