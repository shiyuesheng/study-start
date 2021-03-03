package com.shenge.study.reflection.r06private;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author : Shi Yue Sheng
 * @date : 2021/3/3
 * @time : 4:18 下午
 * @desc : 描述
 */

class A {
    private String a;

    private String method() {
        return a;
    }

    public A() {
        this.a = "hello";
    }

    @Override
    public String toString() {
        return "A{" +
                "a='" + a + '\'' +
                '}';
    }
}

public class ReflectionPrivate {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
//        Field privateField = A.class.getDeclaredField("a");
//        privateField.setAccessible(true);
//
//        A a = new A();
//        String result = (String) privateField.get(a);
//        System.out.println(result);
//
//        privateField.set(a, "hello hello");
//        System.out.println(a);


        Method method = A.class.getDeclaredMethod("method");
//        method.setAccessible(true);
        A a = new A();
        String result = (String) method.invoke(a);
        System.out.println(result);

    }
}
