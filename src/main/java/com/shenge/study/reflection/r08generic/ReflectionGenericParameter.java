package com.shenge.study.reflection.r08generic;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author : Shi Yue Sheng
 * @date : 2021/3/3
 * @time : 11:28 下午
 * @desc : 描述
 */
public class ReflectionGenericParameter {

    public void getStringList(List<String> stringList) {}

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = ReflectionGenericParameter.class.getMethod("getStringList", List.class);

        Type parameterType = method.getGenericParameterTypes()[0];
        System.out.println(parameterType.getClass());

        if (parameterType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) parameterType;
            System.out.println(parameterizedType.getTypeName());
            System.out.println(parameterizedType.getRawType());

            Type actualTypeArgument = parameterizedType.getActualTypeArguments()[0];
            System.out.println(actualTypeArgument.getTypeName());
        }

    }
}
