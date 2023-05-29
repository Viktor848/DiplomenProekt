package com.example.DiplomenProekt.CustomDetailsService;

import com.example.DiplomenProekt.CustomDetails.CustomAdminDetails;
import com.example.DiplomenProekt.Entity.Admins;
import com.example.DiplomenProekt.Repository.AdminsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private AdminsRepository adminRep;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admins admin = adminRep.findByEmail(username);
        if (admin == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomAdminDetails(admin);
    }
}
