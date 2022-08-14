package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseStringServiceImpl implements DatabaseStringService{//Реализация интерфейса сервиса

    @Autowired
    private DatabaseStringRepository databaseStringRepository;//Объект репозитория

    //Методы для получения таблицы( импортированной в бд из Excel)
    @Override
    public List<DatabaseString> getClass1Database() {
        return databaseStringRepository.getClass1Strings("class1");
    }

    @Override
    public List<DatabaseString> getClass2Database() {
        return databaseStringRepository.getClass1Strings("class2");
    }

    @Override
    public List<DatabaseString> getClass3Database() {
        return databaseStringRepository.getClass1Strings("class3");
    }

    @Override
    public List<DatabaseString> getClass4Database() {
        return databaseStringRepository.getClass1Strings("class4");
    }

    @Override
    public List<DatabaseString> getClass5Database() {
        return databaseStringRepository.getClass1Strings("class5");
    }

    @Override
    public List<DatabaseString> getClass6Database() {
        return databaseStringRepository.getClass1Strings("class6");
    }

    @Override
    public List<DatabaseString> getClass7Database() {
        return databaseStringRepository.getClass1Strings("class7");
    }

    @Override
    public List<DatabaseString> getClass8Database() {
        return databaseStringRepository.getClass1Strings("class8");
    }

    @Override
    public List<DatabaseString> getClass9Database() {
        return databaseStringRepository.getClass1Strings("class9");
    }
}
