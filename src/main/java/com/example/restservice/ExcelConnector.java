package com.example.restservice;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;
import java.util.Iterator;

public class ExcelConnector {

    public void connectAndImport(String table) {//Метод, который подключается и загружает данные из Excel в бд
        String jdbcURL = "jdbc:mysql://localhost:3306/b1db";
        String username = "root";
        String password = "1234";

        String excelFilePath = "C:/Курс 3/Тестовые задания/B1_2_v2/gs-rest-service/complete/src/main/resources/Книга" +
                table.substring(5, table.length()) + ".xlsx";//В зависимости от названия таблицы, к которой обращаются,
        // открывается нужная книга Excel

        int batchSize = 20;

        Connection connection = null;

        try {
            long start = System.currentTimeMillis();

            FileInputStream inputStream = new FileInputStream(excelFilePath);

            Workbook workbook = new XSSFWorkbook(inputStream);//Объект книги

            Sheet firstSheet = workbook.getSheetAt(0);//Объект первого листа книги
            Iterator<Row> rowIterator = firstSheet.iterator();

            connection = DriverManager.getConnection(jdbcURL, username, password);//Подключаемся к бд
            connection.setAutoCommit(false);
            Statement deleteTableStatement = connection.createStatement();
            String deleteTableData = "TRUNCATE TABLE " + table;//Очищаем таблицу бд
            deleteTableStatement.executeUpdate(deleteTableData);
            String sql = "INSERT INTO " + table + " VALUES (?, ?, ?, ?, ?, ?, ?)";//Sql запрос вставки данных
            PreparedStatement statement = connection.prepareStatement(sql);

            int count = 0;
            for (int i = 0; i < 9; i++) {
                rowIterator.next(); // пропускаем первые строки excel документа
            }


            while (rowIterator.hasNext()) {//Пока в документе есть непустые ряды, выполняем действия
                Row nextRow = rowIterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();//Объект итератор по колонкам

                while (cellIterator.hasNext()) {//Пока есть колонки выполняе действия
                    Cell nextCell = cellIterator.next();

                    int columnIndex = nextCell.getColumnIndex();

                    switch (columnIndex) {//В зависимости от номера колонки(первые семь) считываем значение в нужную
                        // переменную и подставляем в sql запрос
                        case 0:
                            if (nextCell.getCellType() == CellType.STRING) {//В первой колонке встречаются как
                                // текстовые так и цифровые значения
                                String one = nextCell.getStringCellValue();
                                statement.setString(1, one);
                            } else {
                                String oneNumeric = String.valueOf(nextCell.getNumericCellValue());
                                statement.setString(1, oneNumeric);
                            }

                            break;
                        case 1:
                            double two = nextCell.getNumericCellValue();
                            statement.setBigDecimal(2, BigDecimal.valueOf(two));
                            break;
                        case 2:
                            double three = nextCell.getNumericCellValue();
                            statement.setBigDecimal(3, BigDecimal.valueOf(three));
                            break;
                        case 3:
                            double four = nextCell.getNumericCellValue();
                            statement.setBigDecimal(4, BigDecimal.valueOf(four));
                            break;
                        case 4:
                            double five = nextCell.getNumericCellValue();
                            statement.setBigDecimal(5, BigDecimal.valueOf(five));
                            break;
                        case 5:
                            double six = nextCell.getNumericCellValue();
                            statement.setBigDecimal(6, BigDecimal.valueOf(six));
                            break;
                        case 6:
                            double seven = nextCell.getNumericCellValue();
                            statement.setBigDecimal(7, BigDecimal.valueOf(seven));
                            break;
                    }

                }

                statement.addBatch();//В заготовленный sql запрос добавляем переданные ранее данные из колонок

                if (count % batchSize == 0) {
                    statement.executeBatch();//Выполняем запрос
                }

            }
            //Закрываем excel документ и соединение к бд
            workbook.close();

            statement.executeBatch();//Выполняем запрос

            connection.commit();
            connection.close();

            long end = System.currentTimeMillis();
            System.out.printf("Import done in %d ms\n", (end - start));

        } catch (IOException ex1) {
            System.out.println("Error reading file");
            ex1.printStackTrace();
        } catch (SQLException ex2) {
            System.out.println("Database error");
            ex2.printStackTrace();
        }

    }
}
