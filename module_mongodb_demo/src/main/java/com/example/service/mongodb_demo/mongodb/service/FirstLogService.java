package com.example.service.mongodb_demo.mongodb.service;

import com.example.service.mongodb_demo.mongodb.po.FirstLog;

import java.util.List;


public interface FirstLogService {


    void save(FirstLog firstLog);

    List<FirstLog> findALL();

}
