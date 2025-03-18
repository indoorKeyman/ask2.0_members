package com.example.Members.dto;

import lombok.*;
import java.sql.*;

@Setter
@Getter
public class MembersDTO {

    private int member_index;

    private String id;

    private String password;

    private String name;

    private String email;

    private String role;

    private String job_status; // Enum 타입: 'EMPLOYED', 'SEEKING'

    private Timestamp created_date;

    private Timestamp updated_date;

}
