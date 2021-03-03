package com.shenge.study.generic;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @Author : Shi Yue Sheng
 * @Date : 2020/6/8
 * @Time : 下午1:14
 * @Desc : 范型类
 */
public class GenericReflectDemo<T1, T2 extends DemoA, T3 extends DemoA & DemoB> extends GenericReflectSuperDemo<String> {

    public String test() {
        return null;
    }

    public T1 test1() {
        return null;
    }

    public List<T1> test2() {
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method[] methods = GenericReflectDemo.class.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("-------------------------这是分割线");

        Method[] declaredMethods = GenericReflectDemo.class.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method);
        }

        System.out.println("-------------------------这是分割线");

        Class superclass = GenericReflectDemo.class.getSuperclass();
        System.out.println(superclass);
        Type genericSuperclass = GenericReflectDemo.class.getGenericSuperclass();
        System.out.println(genericSuperclass);

        System.out.println("-------------------------这是分割线");

        Method testMethod = GenericReflectDemo.class.getDeclaredMethod("test");
        Class testMethodReturnType = testMethod.getReturnType();
        System.out.println(testMethodReturnType);
        Type testMethodGenericReturnType = testMethod.getGenericReturnType();
        System.out.println(testMethodGenericReturnType);

        System.out.println("-------------------------这是分割线");

        Method test1Method = GenericReflectDemo.class.getDeclaredMethod("test1");
        Class test1MethodReturnType = test1Method.getReturnType();
        System.out.println(test1MethodReturnType);
        Type test1MethodGenericReturnType = test1Method.getGenericReturnType();
        System.out.println(test1MethodGenericReturnType);

        System.out.println("-------------------------这是分割线");

        Method test2Method = GenericReflectDemo.class.getDeclaredMethod("test2");
        Class test2MethodReturnType = test2Method.getReturnType();
        System.out.println(test2MethodReturnType);
        Type test2MethodGenericReturnType = test2Method.getGenericReturnType();
        System.out.println(test2MethodGenericReturnType);

    }

}
