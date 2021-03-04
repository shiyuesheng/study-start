package com.shenge.study.reflection.r10dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author : Shi Yue Sheng
 * @date : 2021/3/4
 * @time : 10:09 上午
 * @desc : 描述
 */
public class ReflectionDynamicProxy {

    public static void main(String[] args) {
        MyInterface proxy = (MyInterface) Proxy.newProxyInstance(
                ReflectionDynamicProxy.class.getClassLoader(),
                new Class[]{MyInterface.class}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("sayHello");
                        return "sayHello";
                    }
                });
        proxy.say();
    }

}
