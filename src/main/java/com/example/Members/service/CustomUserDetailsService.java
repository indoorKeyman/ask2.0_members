package com.example.Members.service;

import com.example.Members.Repository.MembersRepository;
import com.example.Members.dto.CustomUserDetails;
import com.example.Members.dto.MembersDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final MembersRepository membersRepository;

    public CustomUserDetailsService(MembersRepository membersRepository) {

        this.membersRepository = membersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //DB에서 조회
        MembersDTO userData = membersRepository.getById(username);

        if (userData != null) {

            //UserDetails에 담아서 return하면 AutneticationManager가 검증 함
            return new CustomUserDetails(userData);
        }

        return null;
    }
}
