package com.shenge.study.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Author : Shi Yue Sheng
 * @Date : 2020/6/8
 * @Time : 下午1:14
 * @Desc : 范型类
 */
class Demo<T> {
}

public class GenericReflectDemo5 extends Demo<String> {

    public static void main(String[] args) {
        Type genericSuperclass = GenericReflectDemo5.class.getGenericSuperclass();
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

}
