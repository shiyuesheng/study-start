package com.shenge.study.jvm;

/**
 * @author : Shi Yue Sheng
 * @date : 2020/11/15
 * @time : 8:35 PM
 * @desc : 栈最大深度测试, 启动参数-Xss256k, 在我本机最小值不能小于160k, 这是操作系统、JVM共同决定的
 * 结论：栈最大深度受到-Xss大小、方法局部变量于操作数栈深度（栈帧大小）所影响。
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

//    public void justIncr() {
//        stackMaxDeep++;
//        justIncr();
//    }

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
