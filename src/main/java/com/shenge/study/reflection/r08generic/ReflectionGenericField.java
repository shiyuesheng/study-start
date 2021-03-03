package com.shenge.study.reflection.r08generic;

import java.lang.reflect.Field;
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
public class ReflectionGenericField {

    public List<String> list1;
    public static List<String> list2;
    private List<String> list3;

    public static void main(String[] args) throws NoSuchMethodException {
        Field[] fields = ReflectionGenericField.class.getDeclaredFields();
        for (Field field : fields) {
            Type genericType = field.getGenericType();
            System.out.println(genericType.getClass());
            if (genericType instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) genericType;
                System.out.println(parameterizedType.getTypeName());
                System.out.println(parameterizedType.getRawType());

                Type actualTypeArgument = parameterizedType.getActualTypeArguments()[0];
                System.out.println(actualTypeArgument.getTypeName());
                System.out.println("---------------");
            }
        }

    }
}
