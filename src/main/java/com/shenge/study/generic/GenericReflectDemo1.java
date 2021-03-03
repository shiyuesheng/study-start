package com.shenge.study.generic;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * @Author : Shi Yue Sheng
 * @Date : 2020/6/8
 * @Time : 下午1:14
 * @Desc : 范型类
 */
public class GenericReflectDemo1<T1, T2 extends Integer, T3 extends DemoA & DemoB> {

    public static void main(String[] args) {
        //获取GenericReflectDemo1类上声明的范型变量列表
        TypeVariable<Class<GenericReflectDemo1>>[] typeVariables = GenericReflectDemo1.class.getTypeParameters();
        for (TypeVariable<Class<GenericReflectDemo1>> typeVariable : typeVariables) {
            System.out.println("范型变量名称：" + typeVariable.getName());
            System.out.println("范型变量声明源自：" + typeVariable.getGenericDeclaration());
            Type[] bounds = typeVariable.getBounds();
            System.out.println("范型变量边界清单：");
            for (Type bound : bounds) {
                System.out.println(bound.getTypeName());
            }
            System.out.println("----------------------");
        }
    }

}
