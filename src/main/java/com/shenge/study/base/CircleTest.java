package com.shenge.study.base;

/**
 * @author : Shi Yue Sheng
 * @date : 2020/12/3
 * @time : 10:47 AM
 * @desc : 循环字节码测试
 */
public class CircleTest {

    public void forCircle() {
        for (;;) {
            System.out.println(1);
        }
    }

    public void whileCircle() {
        while (true) {
            System.out.println(1);
        }
    }
}
