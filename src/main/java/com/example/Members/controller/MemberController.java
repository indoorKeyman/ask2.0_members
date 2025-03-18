package com.example.Members.controller;

import com.example.Members.dto.MembersDTO;
import com.example.Members.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@Controller
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<MembersDTO>> getAllMembers () {

        log.info("Request getAllMembers received");

        List result = memberService.getAllMembers();

        if (!result.isEmpty()){
            log.info("Response getAllMembers sent: Success");
        }

        return ResponseEntity.ok(result);
    }



    @PostMapping("/sign_up")
    public ResponseEntity<String> signUp (
            @RequestBody MembersDTO request
    ) {

        log.info("Request signUp received");

        Boolean result = memberService.signUp(
                request.getId(),
                request.getPassword(),
                request.getName(),
                request.getEmail(),
                request.getRole(),
                request.getJob_status()
        );

        if (result){
            log.info("Response signUp sent: Success");
        }

        return ResponseEntity.ok(result ? "Successful signUp" : "Failed signUp" );
    }

    @GetMapping("/get_mi")
    public ResponseEntity<MembersDTO> getMember_Index (@RequestParam String username) {

        log.info("Request getMember_Index received");

        MembersDTO result = memberService.getUserInfoByusername(username);

        if (result != null){
            log.info("Response getMember_Index sent: Success");
        }

        return ResponseEntity.ok(result);
    }





}
