package com.renwei.module_jvm_dome.dome01;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renwei
 * @since 2020/12/10 0010
 */
public class Test {
    public static void main(String[] args) {
        Farther farther = new Farther();
        farther.fun();
        Farther child = new Child();
        child.fun();
    }
}
