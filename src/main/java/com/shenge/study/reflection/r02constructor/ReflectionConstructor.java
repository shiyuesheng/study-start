package com.shenge.study.reflection.r02constructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * @author : Shi Yue Sheng
 * @date : 2021/1/28
 * @time : 8:29 下午
 * @desc : 反射-Constructor
 */
public class ReflectionConstructor {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<ReflectionConstructor.C> clazz = C.class;

        //获取所有 public 构造方法，不包括父类的
        Constructor[] constructors = clazz.getConstructors();
        System.out.println("获取class构造方法：clazz.getConstructors()");
        System.out.println("构造方法数量数量：" + constructors.length);
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println(".... ....");

        //获取所有的构造方法，包括私有修饰的
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        System.out.println("获取构造方法：clazz.getDeclaredConstructors()");
        System.out.println("构造方法数量数量：" + declaredConstructors.length);
        for (Constructor constructor : declaredConstructors) {
            System.out.println(constructor);
        }

        System.out.println(".... ....");

        /**
         * 获取构造方法，根据方法参数类型
         * 注意如果是内部类，所有的构造方法的第一个参数是外部类类型
         */
        Constructor<C> constructorsByParameterTypes = clazz.getDeclaredConstructor(ReflectionConstructor.class);
        System.out.println("获取构造方法：clazz.getConstructor(Class<?>... parameterTypes)");
        System.out.println(constructorsByParameterTypes);

        System.out.println(".... ....");

        //构造器参数类型
        Class[] parameterTypes = constructorsByParameterTypes.getParameterTypes();
        System.out.println("获取构造方法参数类型：java.lang.reflect.Constructor.getParameterTypes");
        Arrays.stream(parameterTypes).forEach(System.out::print);

        //构造器实例化对象, 私有构造器需要先获取访问权限
        constructorsByParameterTypes.setAccessible(true);
        C c = constructorsByParameterTypes.newInstance(new ReflectionConstructor());
        System.out.println("构造器实例化对象：java.lang.reflect.Constructor.newInstance");
        System.out.println(c);
    }

    public class A {
        private Integer a;
        public A() {
        }
        public A(Integer a) {
            this.a = a;
        }
    }

    public class B extends A {
        private Long b;
        public B() {
        }
        public B(Long b) {
            this.b = b;
        }
    }

    public class C extends B {
        private String name;
        private C() {
        }
        public C(String name) {
            this.name = name;
        }
    }

}
