package com.shenge.study.base;

/**
 * @author : Shi Yue Sheng
 * @date : 2020/12/3
 * @time : 3:16 PM
 * @desc : 匿名内部类
 * 1.8之前需要显示的修饰 final
 * 1.8开始做了编译优化，可以不用修饰 final，但是在生命周期内不允许修改
 */
public class InnerClass {

    public static void main(String[] args) {
        String str = "haha";
        new Thread() {
            @Override
            public void run() {
                System.out.println(str);
            }
        }.start();
//        str = "ddfd";
        

        String a = "a";
        testParam(a);
        a = "b";
    }

    public static void testParam(String str) {
        new Thread() {
            @Override
            public void run() {
                System.out.println(str);
            }
        }.start();
    }
}
