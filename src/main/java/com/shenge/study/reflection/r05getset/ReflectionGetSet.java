package com.shenge.study.reflection.r05getset;

import java.lang.reflect.Method;

/**
 * @author : Shi Yue Sheng
 * @date : 2021/3/3
 * @time : 3:28 下午
 * @desc : 描述
 */
public class ReflectionGetSet {

    private String a;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public void getB() {
    }

    public void setB() {
    }

    public static void main(String[] args) {
        Method[] methods = ReflectionGetSet.class.getDeclaredMethods();
        for (Method method : methods) {
            if (ReflectionGetSet.isGetter(method)) System.out.println("Getter:" + method.getName());
            if (ReflectionGetSet.isSetter(method)) System.out.println("Setter:" + method.getName());
        }
    }

    public static boolean isGetter(Method method) {
        if (!method.getName().startsWith("get")) return false;
        if (method.getParameterTypes().length != 0) return false;
        if (method.getReturnType().equals(void.class)) return false;
        return true;
    }

    public static boolean isSetter(Method method) {
        if (!method.getName().startsWith("set")) return false;
        if (method.getParameterTypes().length != 1) return false;
        return true;
    }
}
