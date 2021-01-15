package pl.sda.MovieRental.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import pl.sda.MovieRental.service.AutoLoginService;
@Slf4j
@Service
public class AutoLoginServiceImpl implements AutoLoginService {

    private final UserDetailsService userDetailsService;

    public AutoLoginServiceImpl(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void autoLogin(String username, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken
                (userDetails, password, userDetails.getAuthorities());
        if (token.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(token);
         log.info("Logged user " + username);
        }
    }
}