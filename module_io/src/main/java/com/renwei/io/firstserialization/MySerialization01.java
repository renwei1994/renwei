package com.renwei.io.firstserialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renwei
 * @since 2020/11/21 0021
 */
public class MySerialization01 {

    public static void main(String[] args) {
        Student student = new Student();
        try{
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("F:\\Student.txt"));
            objectOutputStream.writeObject(student);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
