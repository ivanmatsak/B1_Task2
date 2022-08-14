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
public class ExcelToDatabaseController {
    @Autowired
    private DatabaseStringService databaseStringService;

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<Resource> downloadFile(@RequestParam(value = "id") Long id) throws SQLException, IOException {
        Path path = Paths.get(FileLoader.getUrl(id));
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
        File file = new File(FileLoader.getUrl(id));
        HttpHeaders headers = new HttpHeaders(); headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+file.getName()+".txt");
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    @GetMapping("/class1")
    public ModelAndView getClass1() {
        ModelAndView modelAndView = new ModelAndView();
        List<DatabaseString> strings = databaseStringService.getClass1Database();
        modelAndView.setViewName("class1Template");
        modelAndView.addObject("strings", strings);
        modelAndView.addObject("id", 1);
        return modelAndView;
    }

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
