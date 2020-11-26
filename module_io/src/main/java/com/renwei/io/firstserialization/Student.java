package com.renwei.io.firstserialization;

import java.io.Serializable;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renwei
 * @since 2020/11/21 0021
 */
class Student implements Serializable {
    private String name = "renwei";
    private int age;
    private final double money = 100;
    private static String b;
    private final static String c = "100456mmm";
    private static Object object = new Object();
    public void fun1() {
        System.out.println("qweuiq");
    }
    public static int fun2(int i1, int i2) {
        i1 = 3;
        int i = i1 + i2;
        Object object = new Object();
        return i;
    }
    public static void main(String[] args) {
        System.out.println(fun2(2, 5));
    }
}