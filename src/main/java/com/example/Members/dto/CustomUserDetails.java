package com.example.Members.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;


public class CustomUserDetails implements UserDetails {

    private final MembersDTO memberDTO;

    public CustomUserDetails(MembersDTO memberDTO) {

        this.memberDTO = memberDTO;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> collection = new ArrayList<>();

        collection.add(new GrantedAuthority() {

            @Override
            public String getAuthority() {

                return memberDTO.getRole();
            }
        });

        return collection;
    }

    @Override
    public String getPassword() {

        return memberDTO.getPassword();
    }

    @Override
    public String getUsername() {

        return memberDTO.getId();
    }

    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    @Override
    public boolean isAccountNonLocked() {

        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {

        return true;
    }

    @Override
    public boolean isEnabled() {

        return true;
    }
}
