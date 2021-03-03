package com.shenge.study.base;

/**
 * @author : Shi Yue Sheng
 * @date : 2020/12/2
 * @time : 6:30 PM
 * @desc : 值传递
 */
public class ValueTransfer {

    public static void transferInt(int a) {
        a = 10;
    }

    public static void transferInteger(Integer b) {
        b = 10;
    }

    public static void transferObject(Value c) {
        c.setA(10);
    }

    public static class Value {
        int a;

        public Value(int a) {
            this.a = a;
        }

        public void setA(int a) {
            this.a = a;
        }
    }

    public static void main(String[] args) {
        int a = 7;
        transferInt(a);
        System.out.println(a);

        Integer b = 7;
        transferInteger(b);
        System.out.println(b);

        Value c = new Value(7);
        transferObject(c);
        System.out.println(c.a);
    }
}
