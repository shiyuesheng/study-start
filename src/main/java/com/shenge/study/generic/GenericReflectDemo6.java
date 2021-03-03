package com.shenge.study.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Author : Shi Yue Sheng
 * @Date : 2020/6/8
 * @Time : 下午1:14
 * @Desc : 范型类
 */
public class GenericReflectDemo6<T> {

    public void method(GenericReflectDemo6<T> demo) {
        Type genericSuperclass = demo.getClass().getGenericSuperclass();
        System.out.println(genericSuperclass.getClass());
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            System.out.println("原始类型：" + parameterizedType.getRawType());
            System.out.println("所属类型：" + parameterizedType.getOwnerType());
            Type actualTypeArgument = parameterizedType.getActualTypeArguments()[0];
            System.out.println(actualTypeArgument.getClass());
            if (actualTypeArgument instanceof Class) {
                Class actualTypeArgumentClass = (Class) actualTypeArgument;
                System.out.println(actualTypeArgumentClass.getName());
                System.out.println(actualTypeArgumentClass.getSimpleName());
                System.out.println(actualTypeArgumentClass.getTypeName());
            }
        }
    }

    public static void main(String[] args) {
        GenericReflectDemo6<String> demo4 = new GenericReflectDemo6<String>(){};
        demo4.method(demo4);
    }

}
