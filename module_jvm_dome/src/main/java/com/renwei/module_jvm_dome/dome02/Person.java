package com.renwei.module_jvm_dome.dome02;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renwei
 * @since 2020/12/10 0010
 */
public class Person {
    private String name = "Jack";
    private int age;
    private final double salary = 100;
    private final static double salary1 = 11;
    private static final double salary2 = 22;
    private static String address;
    private final static String hobby = "Programming";
    private static Object obj = new Object();

    public void say() {
        System.out.println("person say...");
    }

    public static int calc(int op1, int op2) {
        op1 = 3;
        int result = op1 + op2;
        Object obj = new Object();
        return result;
    }

    public static void main(String[] args) {
        calc(1, 2);
    }
}
