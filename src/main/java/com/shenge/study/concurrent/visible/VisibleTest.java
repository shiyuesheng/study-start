package com.shenge.study.concurrent.visible;

/**
 * @author : Shi Yue Sheng
 * @date : 2020/11/18
 * @time : 2:26 PM
 * @desc : 可见性测试
 */
public class VisibleTest implements Runnable {

    public Integer b = 1;

    @Override
    public void run() {
        System.out.println("test begin!");
        while (true) {
//            System.out.println("a");
             System.out.println(b + " : " + System.currentTimeMillis());
            if (b.equals(2)) {
                break;
            }
        }

        System.out.println("test finish!");
    }

    public static void main(String[] args) {
        VisibleTest test = new VisibleTest();
        //线程A
        new Thread(test).start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程睡眠结束：" + System.currentTimeMillis());
        test.b = 2;
    }


//    这是 System.out.println(b) 的方法实现：
//    public void println(Object x) {
//        String s = String.valueOf(x);
//        synchronized (this) {
//            print(s);
//            newLine();
//        }
//    }
//
//
//    在这一行 String s = String.valueOf(x)，来了个狸猫换太子，String s 是一个新的对象（String是不可变类），s对象里面的value[]复制的是Object x里面的value。
//    可以参考Integer的toString()实现：
//    public static String toString(int i) {
//        if (i == Integer.MIN_VALUE)
//            return "-2147483648";
//        int size = (i < 0) ? stringSize(-i) + 1 : stringSize(i);
//        char[] buf = new char[size];
//        getChars(i, size, buf);
//        return new String(buf, true);
//    }
//
//    所以最终print(s) 打印的是一个全新的对象，Object x对象进入synchronized 临界区后刷新了主内存中的最终数据，对print(s)来说已经没关系了
//
//    思考：
//        至于为什么System.out.println(Object x)如此实现，进行大胆的猜测：
//            1、从逻辑上给出的表现是所见即所得，我当前是什么值，那我往控制台打印的就应该是什么值，而不应该被其他线程影响到（本地缓存刷新了最新值）
//            2、这个地方使用 synchronized修饰，那一定是里面的操作属于临界资源，需要保护，这是目的。Object 被动的做了一次本地内存副本的刷新，我觉得是顺带的。
//
//    总结：
//            1、System.out.println(b) 虽然对当前线程的缓存做了一次本地内存的刷新，但是可以当成一个调剂。
//            2、真的想要实现可见性原则，还是要在业务代码层面 显示的 用volatile之类的机制来保证。
//
//    不知道我理解是否正确，欢迎大家指正。
}