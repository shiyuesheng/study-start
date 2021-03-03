package com.shenge.study.base.construct;

/**
 * @author : Shi Yue Sheng
 * @date : 2021/1/18
 * @time : 10:13 上午
 * @desc : 父类
 */
public class SuperClass {

    private String name;

    public SuperClass() {
        System.out.println("SuperClass1");
    }

    public SuperClass(String name) {
        System.out.println("SuperClass2");
        this.name = name;
    }

}
