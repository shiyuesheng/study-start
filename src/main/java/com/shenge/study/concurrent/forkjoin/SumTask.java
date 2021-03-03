package com.shenge.study.concurrent.forkjoin;

import org.apache.commons.lang3.RandomUtils;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author : Shi Yue Sheng
 * @date : 2020/12/23
 * @time : 5:02 PM
 * @desc : 描述
 */
public class SumTask extends RecursiveTask<Long> {

    static final int THRESHOLD = 100;
    long[] array;
    int start;
    int end;

    SumTask(long[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        System.out.println(Thread.currentThread().getName() + "-----" + String.format("compute %d~%d", start, end) + " - start");
        if (end - start <= THRESHOLD) {
            // 如果任务足够小,直接计算:
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread().getName() + "-----" + String.format("compute %d~%d", start, end) + " - end");
            return sum;
        } else {
            // 任务太大,一分为二:
            int middle = (end + start) / 2;
            SumTask subtask1 = new SumTask(this.array, start, middle);
            SumTask subtask2 = new SumTask(this.array, middle, end);
//            invokeAll(subtask1, subtask2);
            subtask1.fork();
            subtask2.fork();
            Long subresult1 = subtask1.join();
            Long subresult2 = subtask2.join();
            Long result = subresult1 + subresult2;
            System.out.println(Thread.currentThread().getName() + "-----" + String.format("compute %d~%d", start, middle) + "  " + String.format("compute %d~%d", middle, end) + " - end");
            return result;
        }
    }

    public static void main(String[] args) throws Exception {
        // 创建随机数组成的数组:
        long[] array = new long[400];
        fillRandom(array);
        // fork/join task:
        ForkJoinPool fjp = new ForkJoinPool(6); // 最大并发数4
        ForkJoinTask<Long> task = new SumTask(array, 0, array.length);
        long startTime = System.currentTimeMillis();
        Long result = fjp.invoke(task);
        long endTime = System.currentTimeMillis();
        System.out.println("Fork/join sum: " + result + " in " + (endTime - startTime) + " ms.");
    }

    public static void fillRandom(long[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = RandomUtils.nextInt(0, 10);
        }
    }

}