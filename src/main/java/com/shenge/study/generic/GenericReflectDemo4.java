package com.shenge.study.generic;

import java.util.List;

/**
 * @Author : Shi Yue Sheng
 * @Date : 2020/6/8
 * @Time : 下午1:14
 * @Desc : 范型类
 */
public class GenericReflectDemo4<T> {

    public void method(GenericReflectDemo4<T> demo) {
        //在这个方法内部如果我们想获取这个参数具体的详细类型信息，是获取不到的
        //只能获取到demo参数所属的类型是GenericReflectDemo4，但是无法获取到demo中的T泛型变量类型对应的具体类型<String>
        System.out.println(demo.getClass());
    }

    public static void main(String[] args) {
        GenericReflectDemo4<String> demo4 = new GenericReflectDemo4<>();
        demo4.method(demo4);
    }

}
