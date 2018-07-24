package com.template.sbssth.Service;

import com.template.sbssth.Dao.CustomerRepository;
import com.template.sbssth.Model.SecurityCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return
                Optional.ofNullable(customerRepository.findByName(username))
                .filter(m -> m!= null)
                .map(m->new SecurityCustomer(m)).get();
    }

}
