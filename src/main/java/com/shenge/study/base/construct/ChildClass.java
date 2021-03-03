package com.shenge.study.base.construct;

/**
 * @author : Shi Yue Sheng
 * @date : 2021/1/18
 * @time : 10:13 上午
 * @desc : 子类
 */
public class ChildClass extends SuperClass {

    private int age;

    public ChildClass(int age) {
        super("a");
        System.out.println("ChildClass");
    }

    public static void main(String[] args) {
        new ChildClass(1);
        new ChildClass(7);
    }

}
