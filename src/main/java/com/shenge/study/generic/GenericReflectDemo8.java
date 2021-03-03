package com.shenge.study.generic;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Map;

/**
 * @Author : Shi Yue Sheng
 * @Date : 2020/6/8
 * @Time : 下午1:14
 * @Desc : 范型类
 */
public class GenericReflectDemo8 {

    public Map<? extends DemoA, ? super DemoB> method() {
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = GenericReflectDemo8.class.getDeclaredMethod("method");
        Type returnType = method.getGenericReturnType();
        System.out.println(returnType.getClass());
        if (returnType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) returnType;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println(actualTypeArgument.getClass());
                if (actualTypeArgument instanceof WildcardType) {
                    WildcardType wildcardType = (WildcardType) actualTypeArgument;
                    System.out.println("通配符类型名称:" + wildcardType.getTypeName());
                    Type[] upperBounds = wildcardType.getUpperBounds();
                    for (Type upperBound : upperBounds) {
                        System.out.println("通配符上边界：" + upperBound.getTypeName());
                    }
                    Type[] lowerBounds = wildcardType.getLowerBounds();
                    for (Type lowerBound : lowerBounds) {
                        System.out.println("通配符下边界：" + lowerBound.getTypeName());
                    }
                }
                System.out.println("----------");
            }
        }
    }

}
