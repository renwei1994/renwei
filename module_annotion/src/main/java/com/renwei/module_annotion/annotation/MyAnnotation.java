package com.renwei.module_annotion.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyAnnotation {
    String name();

    int age();

    int hight() default 120;

    MyAnnotation2 doWork();

    MyAnnotationEbum doWork1();

    String[] doWork2();
}
