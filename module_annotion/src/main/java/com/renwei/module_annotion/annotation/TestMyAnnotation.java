package com.renwei.module_annotion.annotation;

@MyAnnotation(name = "renwei", age = 18, hight = 125, doWork = @MyAnnotation2, doWork1 = MyAnnotationEbum.P1, doWork2 = {"renwei","liuyifei"})
public class TestMyAnnotation {

    public static void main(String[] args) {
        Class<TestMyAnnotation> test = TestMyAnnotation.class;
        MyAnnotation annotation = test.getAnnotation(MyAnnotation.class);
        System.out.println(annotation);

    }
}
