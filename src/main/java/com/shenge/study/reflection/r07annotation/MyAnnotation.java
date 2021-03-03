package com.shenge.study.reflection.r07annotation;

import java.lang.annotation.*;

/**
 * @author : Shi Yue Sheng
 * @date : 2021/3/3
 * @time : 6:02 下午
 * @desc : 描述
 */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {
    String value() default "hello";
}
