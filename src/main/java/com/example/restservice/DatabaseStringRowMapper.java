package com.example.restservice;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseStringRowMapper implements RowMapper<DatabaseString> {
    public DatabaseStringRowMapper(String table){//В конструкторе создаем объект ExcelConnector и вызываем метод,
        // который загружает данные из таблицы sql в бд
        ExcelConnector connector = new ExcelConnector();
        connector.connectAndImport(table);
    }
    public DatabaseString mapRow(ResultSet rs, int rowNum) throws SQLException {

        DatabaseString string = new DatabaseString();//Одна строка из бд
        //Инициализируем свойство объекта строки
        string.setNumber(rs.getString("Number"));
        string.setIncomingSaldoActive(rs.getBigDecimal("IncomingSaldoActive"));
        string.setIncomingSaldoPassive(rs.getBigDecimal("IncomingSaldoPassive"));
        string.setTurnoverDebet(rs.getBigDecimal("TurnoverDebet"));
        string.setTurnoverCredit(rs.getBigDecimal("TurnoverCredit"));
        string.setOutgoingSaldoActive(rs.getBigDecimal("OutgoingSaldoActive"));
        string.setOutgoingSaldoPassive(rs.getBigDecimal("OutgoingSaldoPassive"));
        return string;
    }

}
