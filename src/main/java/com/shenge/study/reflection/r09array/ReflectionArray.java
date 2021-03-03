package com.shenge.study.reflection.r09array;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author : Shi Yue Sheng
 * @date : 2021/3/3
 * @time : 11:28 下午
 * @desc : 描述
 */
public class ReflectionArray {

    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException {
        //反射创建数组
        int[] intArray = (int[]) Array.newInstance(int.class, 2);
        //反射数组赋值
        Array.set(intArray, 0, 1);
        Array.set(intArray, 1, 2);
        //反射数组取值
        System.out.println(Array.get(intArray, 0));
        System.out.println(Array.get(intArray, 1));

        //不通过反射获取int数组对象
        Class intArrayClass = int[].class;
        //反射获取int数组对象
        Class intArrayClass1 =  Class.forName("[I");
        //反射获取String数组对象
        Class stringArrayClass =  Class.forName("[Ljava.lang.String;");

        //下面两种方式获取原生类型class对象 会抛出异常
        //Class intClass =  Class.forName("I");
        //Class stringClass =  Class.forName("int");

        Class stringClass = ReflectionArray.getClass("java.lang.String");
        Class stringArrayClass1 = Array.newInstance(stringClass, 0).getClass();
        System.out.println(stringArrayClass1);
        System.out.println(stringArrayClass1.isArray());

        Class stringArraysComponentType = stringArrayClass1.getComponentType();
        Class intArraysComponentType = intArrayClass.getComponentType();
        System.out.println(stringArraysComponentType);
        System.out.println(intArraysComponentType);
    }

    public static Class getClass(String className) throws ClassNotFoundException {
        if ("int".equals(className)) return int.class;
        if ("long".equals(className)) return long.class;
        return Class.forName(className);
    }
}
