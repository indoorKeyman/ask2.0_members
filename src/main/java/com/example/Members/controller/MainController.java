package com.example.Members.controller;



import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@Controller
@RequestMapping("/admin")
public class MainController {

    @GetMapping("/test")
    public ResponseEntity<String> test () {

        return ResponseEntity.ok("success");
    }
}
