package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DatabaseStringRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(readOnly = true)
    public List<DatabaseString> getClass1Strings(String table){
        return jdbcTemplate.query("select * from "+table, new DatabaseStringRowMapper(table));
    }

}
