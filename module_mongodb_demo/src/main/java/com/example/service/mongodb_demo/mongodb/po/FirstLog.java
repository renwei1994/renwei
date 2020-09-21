package com.example.service.mongodb_demo.mongodb.po;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collation = "first")//存入的集合
@CompoundIndex(def = "{'age':1,'source':-1}")//索引
public class FirstLog {
    @Id//主键标识
    private String id;
    private String name;
    private String age;
    private String source;
    private Integer del_flag;
}
