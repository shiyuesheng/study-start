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
public class ReflectionGenericReturn {

    public List<String> getStringList() {
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = ReflectionGenericReturn.class.getMethod("getStringList");
        System.out.println(method.getReturnType());

        Type returnType = method.getGenericReturnType();
        System.out.println(returnType.getClass());

        if (returnType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) returnType;
            System.out.println(parameterizedType.getTypeName());
            System.out.println(parameterizedType.getRawType());

            Type actualTypeArgument = parameterizedType.getActualTypeArguments()[0];
            System.out.println(actualTypeArgument.getTypeName());
        }

    }
}
