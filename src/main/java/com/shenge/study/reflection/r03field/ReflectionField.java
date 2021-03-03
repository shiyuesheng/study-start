package com.shenge.study.reflection.r03field;

import java.lang.reflect.Field;

/**
 * @author : Shi Yue Sheng
 * @date : 2021/1/28
 * @time : 8:29 下午
 * @desc : 反射-Field
 */
public class ReflectionField {

    public class A {
        public Integer a;
        public int b;

        @Override
        public String toString() {
            return "A{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }

    public A getA() {
        return new A();
    }

    public static class B {
        public Integer a;
        public int b;
        public static String c;

        @Override
        public String toString() {
            return "B{" +
                    "a=" + a +
                    ", b=" + b +
                    ", c=" + c +
                    '}';
        }
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class<ReflectionField.A> clazz = A.class;
        Field[] fields = clazz.getFields();

        for (Field field : fields) {
            System.out.println("变量名称：" + field.getName());
            System.out.println("变量类型：" + field.getType());
        }

        Field fieldA = clazz.getField("a");
        String fieldAName = fieldA.getName();
        Object fieldAType = fieldA.getType();

        //无法直接在外部 new 非static修饰的内部类，只能在内部类所属的类中实例化
        A a = new ReflectionField().getA();
        fieldA.set(a, 1);
        System.out.println(a);

        Class<ReflectionField.B> clazzB = B.class;
        Field fieldC = clazzB.getField("c");
        //静态Field.set() 第一个参数，无需传入实例，结果会影响所有的类实例
        fieldC.set(null, "1");
        System.out.println(new B());
    }

}
