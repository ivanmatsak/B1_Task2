package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DatabaseStringRepository {//Класс репозитория, отвечающий за предоставление доступа к данным из бд

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(readOnly = true)
    public List<DatabaseString> getClass1Strings(String table){
        //Передаем запрос получения данных из таблицы и объект RowMapper
        return jdbcTemplate.query("select * from "+table, new DatabaseStringRowMapper(table));
    }

}
