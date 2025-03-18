package com.example.Members.Repository;

import com.example.Members.dto.RefreshDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class RefreshRepository {

    private final SqlSessionTemplate sql;

    public Integer insertRefreshToken(RefreshDTO params) {
        return sql.insert("Refresh.insertRefreshToken", params);
    }

    public Integer refreshTokenExistCheck(String refresh) {
        return sql.selectOne("Refresh.refreshTokenExistCheck", refresh);
    }

    public Integer deleteRefreshToken(String refresh) {
        return sql.delete("Refresh.deleteRefreshToken", refresh);
    }

}