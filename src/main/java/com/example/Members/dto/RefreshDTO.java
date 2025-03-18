package com.example.Members.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
public class RefreshDTO {

    private int id;

    private String username;

    private String refresh;

    private String expiration;

}