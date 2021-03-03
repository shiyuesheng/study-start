package com.shenge.study.generic;

import java.lang.reflect.*;
import java.util.List;
import java.util.Map;

/**
 * @Author : Shi Yue Sheng
 * @Date : 2020/6/8
 * @Time : 下午1:14
 * @Desc : 范型类
 */
public class GenericReflectDemo9<T> {

    public List<String>[] method(T[] array) {
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = GenericReflectDemo9.class.getDeclaredMethod("method", Object[].class);

        System.out.println("-------------------方法参数");
        Type parameterType = method.getGenericParameterTypes()[0];
        System.out.println(parameterType.getClass());
        if (parameterType instanceof GenericArrayType) {
            GenericArrayType genericArrayType = (GenericArrayType) parameterType;
            Type genericComponentType = genericArrayType.getGenericComponentType();
            System.out.println(genericComponentType.getClass());
            if (genericComponentType instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) genericComponentType;
                System.out.println("范型变量名称：" + typeVariable.getName());
                System.out.println("范型变量声明源自：" + typeVariable.getGenericDeclaration());
                Type[] bounds = typeVariable.getBounds();
                System.out.println("范型变量边界清单：");
                for (Type bound : bounds) {
                    System.out.println(bound.getTypeName());
                }
            }
        }




        System.out.println("-------------------方法返回");
        Type returnType = method.getGenericReturnType();
        System.out.println(returnType.getClass());
        if (returnType instanceof GenericArrayType) {
            GenericArrayType genericArrayType = (GenericArrayType) returnType;
            Type genericComponentType = genericArrayType.getGenericComponentType();
            System.out.println(genericComponentType.getClass());
            ParameterizedType parameterizedType = (ParameterizedType) genericComponentType;
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
