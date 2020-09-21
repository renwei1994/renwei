package com.example.service.mongodb_demo.mongodb.repository.impl;

import com.example.service.mongodb_demo.mongodb.po.FirstLog;
import com.example.service.mongodb_demo.mongodb.repository.FirstLogRepository;
import com.example.service.mongodb_demo.mongodb.resp.QueryContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FirstLogRepositoryImpl implements FirstLogRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void save(FirstLog firstLog) {
        mongoTemplate.save(firstLog);
    }

    @Override
    public List<FirstLog> findALL() {
        return mongoTemplate.findAll(FirstLog.class);
    }

    @Override
    public Map<String, Object> getAlarmLogByDeviceCode(QueryContent queryContent) {

        Map<String, Object> resultMap = new HashMap<>();
        int currentPage = queryContent.getCurrentPage();
        int pageSize = queryContent.getPageSize();

        // 设置字段
        // 创建查询及条件
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(queryContent.getName()));
        query.addCriteria(Criteria.where("age").is(queryContent.getAge()));

        // 设置起始数
        query.skip((currentPage - 1) * pageSize)
                // 设置查询条数
                .limit(pageSize);

        // 查询记录总数
        int totalCount = (int) mongoTemplate.count(query, FirstLog.class);
        // 数据总页数
        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;

        // 设置记录总数和总页数
        resultMap.put("totalCount", totalCount);
        resultMap.put("totalPage", totalPage);

        // 按创建时间倒序
//        query.with(new Sort(Sort.Direction.DESC, "createDate"));
        // 查询当前页数据集合
        List<FirstLog> records = mongoTemplate.find(query, FirstLog.class);
        resultMap.put("data", records);
        return resultMap;
    }


}
