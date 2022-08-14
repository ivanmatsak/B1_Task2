package com.example.restservice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;

public class FileLoader {
    public static String getUrl(Long id) throws SQLException, IOException {
        String jdbcURL = "jdbc:mysql://localhost:3306/b1db";
        String username = "root";
        String password = "1234";

        Connection connection = DriverManager.getConnection(jdbcURL, username, password);
        Statement statement = connection.createStatement();
        String sql = "select * from class"+id;
        ResultSet resultSet = statement.executeQuery(sql);
        File file = new File("Class"+id);
        file.createNewFile();
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsolutePath(),false))){
            while (resultSet.next()){
                String number = resultSet.getString(1);
                BigDecimal incomingSaldoActive = resultSet.getBigDecimal(2);
                BigDecimal incomingSaldoPassive = resultSet.getBigDecimal(3);
                BigDecimal turnoverDebet = resultSet.getBigDecimal(4);
                BigDecimal turnoverCredit = resultSet.getBigDecimal(5);
                BigDecimal outgoingSaldoActive = resultSet.getBigDecimal(6);
                BigDecimal outgoingSaldoPassive = resultSet.getBigDecimal(7);
                bw.write(number+"||"+incomingSaldoActive+"||"+incomingSaldoPassive+"||"+turnoverDebet+
                        "||"+turnoverCredit+"||"+outgoingSaldoActive+"||"+outgoingSaldoPassive+"||\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return file.getAbsolutePath();
    }
}
