package com.shenge.study.reflection.r07annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author : Shi Yue Sheng
 * @date : 2021/3/3
 * @time : 5:02 下午
 * @desc : 描述
 */
@MyAnnotation("Shenge Class")
public class ReflectionAnnotation {

    @MyAnnotation("Shenge Field")
    public String name;

    @MyAnnotation("Shenge Method")
    public void method() {
    }

    @MyAnnotation("Shenge Method")
    public void method1(@MyAnnotation("Shenge Parameter") String name) {
    }

    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {

        System.out.println("----------------------类注解");
        Annotation[] classAnnotations = ReflectionAnnotation.class.getAnnotations();
        for (Annotation annotation : classAnnotations) {
            if (annotation instanceof MyAnnotation) {
                MyAnnotation myAnnotation = (MyAnnotation) annotation;
                System.out.println(myAnnotation.value());
            }
        }

        Annotation classAnnotation = ReflectionAnnotation.class.getAnnotation(MyAnnotation.class);
        if (classAnnotation instanceof MyAnnotation) {
            MyAnnotation myAnnotation = (MyAnnotation) classAnnotation;
            System.out.println(myAnnotation.value());
        }


        System.out.println("---------------------方法注解");
        Method method = ReflectionAnnotation.class.getMethod("method");
        Annotation[] methodAnnotations = method.getAnnotations();
        for (Annotation annotation : methodAnnotations) {
            if (annotation instanceof MyAnnotation) {
                MyAnnotation myAnnotation = (MyAnnotation) annotation;
                System.out.println(myAnnotation.value());
            }
        }

        Annotation methodAnnotation = method.getAnnotation(MyAnnotation.class);
        if (methodAnnotation instanceof MyAnnotation) {
            MyAnnotation myAnnotation = (MyAnnotation) methodAnnotation;
            System.out.println(myAnnotation.value());
        }

        System.out.println("----------------------方法参数注解");
        Method method1 = ReflectionAnnotation.class.getMethod("method1", String.class);
        Annotation[][] annotations = method1.getParameterAnnotations();
        Class[] parameterTypes = method1.getParameterTypes();
        Parameter[] parameters = method1.getParameters();
        for (int i = 0; i < parameterTypes.length; i++) {
            Class parameterType = parameterTypes[i];
            System.out.println("参数类型:" + parameterType.getName());
            Annotation[] annotationSubs = annotations[i];
            for (Annotation annotation : annotationSubs) {
                if (annotation instanceof MyAnnotation) {
                    MyAnnotation myAnnotation = (MyAnnotation) annotation;
                    System.out.println(myAnnotation.value());
                }
            }

            Parameter parameter = parameters[i];
            MyAnnotation parameterAnnotation = parameter.getAnnotation(MyAnnotation.class);
            if (parameterAnnotation instanceof MyAnnotation) {
                MyAnnotation myAnnotation = (MyAnnotation) parameterAnnotation;
                System.out.println(myAnnotation.value());
            }
        }

        System.out.println("----------------------变量注解");
        Field field = ReflectionAnnotation.class.getField("name");
        Annotation[] fieldAnnotations = field.getAnnotations();
        for (Annotation annotation : fieldAnnotations) {
            if (annotation instanceof MyAnnotation) {
                MyAnnotation myAnnotation = (MyAnnotation) annotation;
                System.out.println(myAnnotation.value());
            }
        }

        Annotation fieldAnnotation = field.getAnnotation(MyAnnotation.class);
        if (methodAnnotation instanceof MyAnnotation) {
            MyAnnotation myAnnotation = (MyAnnotation) fieldAnnotation;
            System.out.println(myAnnotation.value());
        }
    }

}
