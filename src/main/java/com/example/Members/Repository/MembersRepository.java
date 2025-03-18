package com.example.Members.Repository;


import com.example.Members.dto.MembersDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class MembersRepository {

    private final SqlSessionTemplate sql;

    public List<MembersDTO> getAllMembers() {
        return sql.selectList("Members.getAllMembers");
    }

    public MembersDTO getById(String username) {
        return sql.selectOne("Members.getById" , username);
    }

    public Integer getMemberIndexById(String username) {
        return sql.selectOne("Members.getMemberIndexById" , username);
    }

    public Integer singUp(Map<String, Object> params) {
        return sql.insert("Members.signUp", params);
    }
}
