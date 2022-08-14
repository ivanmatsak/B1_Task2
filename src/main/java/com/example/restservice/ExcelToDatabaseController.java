package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;

@org.springframework.stereotype.Controller
public class ExcelToDatabaseController {//Класс контроллера, который обрабатывает url запросы
    @Autowired
    private DatabaseStringService databaseStringService;//Объект сервиса для предоставления таблицы бд

    @RequestMapping(value = "/download", method = RequestMethod.GET)//Метод для обработки запросов о скачивании файла
    public ResponseEntity<Resource> downloadFile(@RequestParam(value = "id") Long id) throws SQLException, IOException {
        Path path = Paths.get(FileLoader.getUrl(id));//Метод getUrl класса FileLoader создает файл с нужной таблицей
        // и возвращает его путь
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
        File file = new File(FileLoader.getUrl(id));
        HttpHeaders headers = new HttpHeaders(); headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+file.getName()+".txt");
        return ResponseEntity.ok()//При обращении к /download копируется id страницы на которой была нажата кнопка и
                // начнется загрузка нужного файла
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    @GetMapping("/class1")
    public ModelAndView getClass1() {//Метод выполняет get запрос /class1
        ModelAndView modelAndView = new ModelAndView();
        List<DatabaseString> strings = databaseStringService.getClass1Database();//Получение данных из бд
        modelAndView.setViewName("class1Template");
        modelAndView.addObject("strings", strings);//Передаем в html страничку список строк таблицы
        modelAndView.addObject("id", 1);//И id выбранной таблицы
        return modelAndView;
    }
    //Остальные методы работают аналогично
    @GetMapping("/class2")
    public ModelAndView getClass2() {
        ModelAndView modelAndView = new ModelAndView();
        List<DatabaseString> strings = databaseStringService.getClass2Database();
        modelAndView.setViewName("class1Template");
        modelAndView.addObject("strings", strings);
        modelAndView.addObject("id", 2);
        return modelAndView;
    }

    @GetMapping("/class3")
    public ModelAndView getClass3() {
        ModelAndView modelAndView = new ModelAndView();
        List<DatabaseString> strings = databaseStringService.getClass3Database();
        modelAndView.setViewName("class1Template");
        modelAndView.addObject("strings", strings);
        modelAndView.addObject("id", 3);
        return modelAndView;
    }

    @GetMapping("/class4")
    public ModelAndView getClass4() {
        ModelAndView modelAndView = new ModelAndView();
        List<DatabaseString> strings = databaseStringService.getClass4Database();
        modelAndView.setViewName("class1Template");
        modelAndView.addObject("strings", strings);
        modelAndView.addObject("id", 4);
        return modelAndView;
    }

    @GetMapping("/class5")
    public ModelAndView getClass5() {
        ModelAndView modelAndView = new ModelAndView();
        List<DatabaseString> strings = databaseStringService.getClass5Database();
        modelAndView.setViewName("class1Template");
        modelAndView.addObject("strings", strings);
        modelAndView.addObject("id", 5);
        return modelAndView;
    }

    @GetMapping("/class6")
    public ModelAndView getClass6() {
        ModelAndView modelAndView = new ModelAndView();
        List<DatabaseString> strings = databaseStringService.getClass6Database();
        modelAndView.setViewName("class1Template");
        modelAndView.addObject("strings", strings);
        modelAndView.addObject("id", 6);
        return modelAndView;
    }

    @GetMapping("/class7")
    public ModelAndView getClass7() {
        ModelAndView modelAndView = new ModelAndView();
        List<DatabaseString> strings = databaseStringService.getClass7Database();
        modelAndView.setViewName("class1Template");
        modelAndView.addObject("strings", strings);
        modelAndView.addObject("id", 7);
        return modelAndView;
    }

    @GetMapping("/class8")
    public ModelAndView getClass8() {
        ModelAndView modelAndView = new ModelAndView();
        List<DatabaseString> strings = databaseStringService.getClass8Database();
        modelAndView.setViewName("class1Template");
        modelAndView.addObject("strings", strings);
        modelAndView.addObject("id", 8);
        return modelAndView;
    }

    @GetMapping("/class9")
    public ModelAndView getClass9() {
        ModelAndView modelAndView = new ModelAndView();
        List<DatabaseString> strings = databaseStringService.getClass9Database();
        modelAndView.setViewName("class1Template");
        modelAndView.addObject("strings", strings);
        modelAndView.addObject("id", 9);
        return modelAndView;
    }
}
