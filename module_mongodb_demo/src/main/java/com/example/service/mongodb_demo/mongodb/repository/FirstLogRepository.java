package com.example.service.mongodb_demo.mongodb.repository;

import com.example.service.mongodb_demo.mongodb.po.FirstLog;
import com.example.service.mongodb_demo.mongodb.resp.QueryContent;

import java.util.List;
import java.util.Map;

public interface FirstLogRepository {
    void save(FirstLog firstLog);

    List<FirstLog> findALL();

    Map<String, Object> getAlarmLogByDeviceCode(QueryContent queryContent);
}
