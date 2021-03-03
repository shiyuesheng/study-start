package com.shenge.study.reflection.r01class;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author : Shi Yue Sheng
 * @date : 2021/1/28
 * @time : 7:36 下午
 * @desc : 反射-Class
 */
public class ReflectionClassDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        getClass01();
//        getClass02();
    }

    public static void getClass01() {
        //编译期间知道类的名字，获取类的class对象
        Class clazz = ReflectionClassDemo.class;
        printClassName(clazz);
    }

    public static void getClass02() throws ClassNotFoundException {
        //编译期间不知道类的名字，使用类的全名字符串，获取类的class对象
        String className = "com.shenge.study.reflection.r01class.ReflectionClassDemo";
        Class clazz = Class.forName(className);
        printClassName(clazz);
    }

    public static void printClassName(Class clazz) {
        //类的全限定类名
        String name = clazz.getName();
        //com.shenge.study.reflection.r01class.ReflectionClassDemo
        System.out.println("class Name " + name);

        //类的简称
        String simpleName = clazz.getSimpleName();
        //ReflectionClassDemo
        System.out.println("class SimpleName " + simpleName);

        //类的修饰符 修饰符都被包装成一个int类型的数字，这样每个修饰符都是一个位标识(flag bit)，这个位标识可以设置和清除修饰符的类型。
        int modifiers = clazz.getModifiers();
        // 1
        System.out.println("class Modifiers " + modifiers);

        Modifier.isAbstract(modifiers);
        Modifier.isFinal(modifiers);
        Modifier.isInterface(modifiers);
        Modifier.isNative(modifiers);
        Modifier.isPrivate(modifiers);
        Modifier.isProtected(modifiers);
        Modifier.isPublic(modifiers);
        Modifier.isStatic(modifiers);
        Modifier.isStrict(modifiers);
        Modifier.isSynchronized(modifiers);
        Modifier.isTransient(modifiers);
        Modifier.isVolatile(modifiers);

        //包信息
        Package packageObject = clazz.getPackage();
        //package com.shenge.study.reflection.r01class
        System.out.println("class Package " + packageObject);

        //父类
        Class superClass = clazz.getSuperclass();
        //class java.lang.Object
        System.out.println("class Superclass " + superClass);

        /**
         * 实现的接口
         * getInterfaces()方法仅仅只返回当前类所实现的接口。
         * 当前类的父类如果实现了接口，这些接口是不会在返回的Class集合中的，
         * 尽管实际上当前类其实已经实现了父类接口。
         * 父类是否是抽象类，是否实现了接口，是否子类代替父类实现了接口，结果一直，符合上面的描述
         */
        Class[] interfaces = Son.class.getInterfaces();
        System.out.println("class Interfaces " + interfaces.length);

        //构造器
        Constructor<?>[] constructors = clazz.getConstructors();
        System.out.println("class Constructors " + constructors.length);

        //方法
        Method[] methods = clazz.getMethods();
        System.out.println("class Methods " + methods.length);

        //变量
        Field[] fields = clazz.getFields();
        System.out.println("class Fields " + fields.length);

        //注解
        Annotation[] annotations = clazz.getAnnotations();
        System.out.println("class Annotations " + annotations.length);

    }

    public interface A {
        void A();
    }

    public interface B {
        void B();
    }

    public class Son extends Father implements B {
        @Override
        public void B() {
        }

        @Override
        public void A() {

        }
    }

    //如果是个 abstract 抽象类，作为父类可以不实现接口，但是债务将转移至子类
    public abstract class Father implements A {
//        @Override
//        public void A() {}
    }
}
