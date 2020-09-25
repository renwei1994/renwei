package com.example.service.mongodb_demo.mongodb.service.impl;

import com.example.service.mongodb_demo.mongodb.po.FirstLog;
import com.example.service.mongodb_demo.mongodb.repository.FirstLogRepository;
import com.example.service.mongodb_demo.mongodb.service.FirstLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FirstLogServiceImpl implements FirstLogService {

    @Autowired
    private FirstLogRepository firstLogRepository;

    @Override
    public void save(FirstLog firstLog) {
        firstLogRepository.save(firstLog);
    }

    @Override
    public List<FirstLog> findALL() {
        return firstLogRepository.findALL();
    }
}
