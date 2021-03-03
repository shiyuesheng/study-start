package com.shenge.study.generic;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * @Author : Shi Yue Sheng
 * @Date : 2020/6/8
 * @Time : 下午1:14
 * @Desc : 范型类
 */
public class GenericReflectDemo2 {

    public <T1, T2 extends Integer, T3 extends DemoA & DemoB> T3 method(T1 t1, T2 t2, T3 t3, String s) {
        return t3;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = GenericReflectDemo2.class.getDeclaredMethod("method", Object.class, Integer.class, DemoA.class, String.class);

        System.out.println("---------------------- 方法范型变量声明");

        TypeVariable<Method>[] typeVariables = method.getTypeParameters();
        for (TypeVariable<Method> typeVariable : typeVariables) {
            System.out.println("范型变量名称：" + typeVariable.getName());
            System.out.println("范型变量声明源自：" + typeVariable.getGenericDeclaration());
            Type[] bounds = typeVariable.getBounds();
            System.out.println("范型变量边界清单：");
            for (Type bound : bounds) {
                System.out.println(bound.getTypeName());
            }
            System.out.println("------");
        }

        System.out.println("---------------------- 方法范型变量参数");

        Type[] parameterTypes = method.getGenericParameterTypes();
        for (Type parameterType : parameterTypes) {
            System.out.println(parameterType.getClass());
            if (parameterType instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) parameterType;
                System.out.println("范型变量名称：" + typeVariable.getName());
                System.out.println("范型变量声明源自：" + typeVariable.getGenericDeclaration());
                Type[] bounds = typeVariable.getBounds();
                System.out.println("范型变量边界清单：");
                for (Type bound : bounds) {
                    System.out.println(bound.getTypeName());
                }
                System.out.println("------");
            }
            if (parameterType instanceof Class) {
                Class clazz = (Class) parameterType;
                System.out.println(clazz.getName());
                System.out.println(clazz.getSimpleName());
                System.out.println(clazz.getTypeName());
            }
        }

        System.out.println("---------------------- 方法范型变量返回");

        Type returnType = method.getGenericReturnType();
        System.out.println(returnType.getClass());
        if (returnType instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) returnType;
            System.out.println("范型变量名称：" + typeVariable.getName());
            System.out.println("范型变量声明源自：" + typeVariable.getGenericDeclaration());
            Type[] bounds = typeVariable.getBounds();
            System.out.println("范型变量边界清单：");
            for (Type bound : bounds) {
                System.out.println(bound.getTypeName());
            }
            System.out.println("------");
        }

    }

}
