package com.example.Members.service;


import com.example.Members.Repository.MembersRepository;
import com.example.Members.dto.MembersDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MembersRepository membersRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<MembersDTO> getAllMembers(){
        return membersRepository.getAllMembers();
    }

    public Boolean signUp(
            String id,
            String password,
            String name,
            String email,
            String role,
            String job_status

    ){
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("password",  bCryptPasswordEncoder.encode(password));
        params.put("name", name);
        params.put("email", email);
        params.put("role", role);
        params.put("job_status", job_status);

        return membersRepository.singUp(params) > 0 ? true : false;
    }

    public MembersDTO getUserInfoByusername(String username){


        return membersRepository.getById(username);
    }

}
