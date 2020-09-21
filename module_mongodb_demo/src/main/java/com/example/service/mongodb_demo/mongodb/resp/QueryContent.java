package com.example.service.mongodb_demo.mongodb.resp;

import lombok.Data;

@Data
public class QueryContent {
    private String name;
    private String age;
    private String source;
    private Integer del_flag;
    private Integer currentPage;
    private Integer pageSize;



    public static int b(int i1, int i2) {
        return i1 + i2;
    }

    public static int a(int i1, int i2) {
        return a(i1, i2);
    }

    public static void main(String[] args) {
        System.out.println(a(2, 5));
    }

}
