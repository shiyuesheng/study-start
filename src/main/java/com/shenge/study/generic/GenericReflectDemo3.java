package com.shenge.study.generic;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;

/**
 * @Author : Shi Yue Sheng
 * @Date : 2020/6/8
 * @Time : 下午1:14
 * @Desc : 范型类
 */
public class GenericReflectDemo3<T> {

    public class A {
        /**
         * 方法参数和返回值都是泛型类型，
         * 泛型返回值的实际类型是泛型变量类型T，T是在Demo4中声明的
         * 泛型方法参数的实际类型是String类型
         *
         * @param list
         * @return
         */
        public List<T> method(List<String> list) {
            return null;
        }
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = GenericReflectDemo3.A.class.getDeclaredMethod("method", List.class);

        System.out.println("---------------------- 方法参数");
        Type parameterType = method.getGenericParameterTypes()[0];
        System.out.println(parameterType.getClass());
        if (parameterType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) parameterType;
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

        System.out.println("---------------------- 方法返回");
        Type returnType = method.getGenericReturnType();
        System.out.println(returnType.getClass());
        if (returnType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) returnType;
            System.out.println("原始类型：" + parameterizedType.getRawType());
            System.out.println("所属类型：" + parameterizedType.getOwnerType());
            Type actualTypeArgument = parameterizedType.getActualTypeArguments()[0];
            System.out.println(actualTypeArgument.getClass());
            if (actualTypeArgument instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) actualTypeArgument;
                System.out.println("范型变量名称：" + typeVariable.getName());
                System.out.println("范型变量声明源自：" + typeVariable.getGenericDeclaration());
                Type[] bounds = typeVariable.getBounds();
                System.out.println("范型变量边界清单：");
                for (Type bound : bounds) {
                    System.out.println(bound.getTypeName());
                }
            }
        }

    }

}
