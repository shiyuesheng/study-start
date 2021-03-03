package com.shenge.study.reflection.r04method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author : Shi Yue Sheng
 * @date : 2021/3/3
 * @time : 3:01 下午
 * @desc : 描述
 */
class A {
    public String method(String s) {
        System.out.println(s);
        return null;
    }

    public static String method() {
        System.out.println("hello");
        return null;
    }
}

public class ReflectionMethod {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method[] methods = A.class.getMethods();

        Method method = A.class.getMethod("method", String.class);
//        Method method = A.class.getMethod("method", new Class[]{String.class});
        System.out.println(method);

        Class[] parameterTypes = method.getParameterTypes();
        System.out.println(parameterTypes.length);
        Class returnType = method.getReturnType();
        System.out.println(returnType);

        method.invoke(new A(), "hello");

        Method methodNull = A.class.getMethod("method");
//        Method methodNull = A.class.getMethod("method", null);
        System.out.println(methodNull);

        methodNull.invoke(null);
    }

}
