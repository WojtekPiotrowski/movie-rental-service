package pl.sda.MovieRental.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Qualifier("userDetailsServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http
                .authorizeRequests()
                .antMatchers("/address/**", "/review").hasRole("USER")
                .antMatchers("/user/{userId}/orders", "/order/{orderId}").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.PUT, "/order/{orderId}", "/order/{orderId}").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/movie-list", "/copy-movie-list").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/movie-list/{id}", "/copy-movie-list/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/movie-list/{id}", "/copy-movie-list/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/movie-list", "/movie-list/{id}", "/copy-movie-list", "/copy-movie-list/{id}"
                        , "movie-list/genres/{genre}", "movie-list/releaseDate", "/movie-list/{id}/review", "/review/{id}")
                .permitAll()
                .antMatchers("cart/**", "/login", "/logout", "/h2-console/**", "/registration")
                .permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/copy-movie-list")
                .failureUrl("/login?error=true")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout=true")
                .invalidateHttpSession(true)
                .permitAll()
                .and()
                .headers().frameOptions().disable();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider daoAuthenticationProvider() {

        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
        auth.authenticationProvider(daoAuthenticationProvider());
    }
}