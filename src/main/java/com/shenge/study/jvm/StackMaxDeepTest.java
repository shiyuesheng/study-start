package com.shenge.study.jvm;

/**
 * @author : Shi Yue Sheng
 * @date : 2020/11/15
 * @time : 8:35 PM
 * @desc : 栈最大深度测试
 */
public class StackMaxDeepTest {

    public int stackMaxDeep = 0;

    public void loadIncr(long a, long b, long c, long d, long e) {
        stackMaxDeep++;
        a++;
        b++;
        c++;
        d++;
        e++;
        loadIncr(a, b, c, d, e);
    }

    public static void main(String[] args) {
        StackMaxDeepTest test = new StackMaxDeepTest();
        try {
            test.loadIncr(1, 2, 3, 4, 5);
        } catch (Error e) {
            System.out.println(test.stackMaxDeep);
            throw e;
        }
    }

}


//    public void justIncr() {
//        stackMaxDeep++;
//        justIncr();
//    }
