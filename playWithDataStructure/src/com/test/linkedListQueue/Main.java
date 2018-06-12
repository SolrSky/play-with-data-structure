package com.test.linkedListQueue;

import java.util.Random;

import com.test.loopQueue.LoopQueue;
import com.test.queue.ArrayQueue;
import com.test.queue.Queue;

public class Main {

    // 测试使用q运行opCount个enqueueu和dequeue操作所需要的时间，单位：秒
    private static double testQueue(Queue<Integer> q, int opCount){

        long startTime = System.nanoTime();

        Random random = new Random();
        for(int i = 0 ; i < opCount ; i ++){
        	System.out.println(q.getClass().getSimpleName().toString() + "入队中....");
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        	
        for(int i = 0 ; i < opCount ; i ++){
        	System.out.println(q.getClass().getSimpleName().toString() + "出队中....");
            q.dequeue();
        }
        	
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int opCount = 1000000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, time: " + time1 + " s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue, time: " + time2 + " s");

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double time3 = testQueue(linkedListQueue, opCount);
        System.out.println("LinkedListQueue, time: " + time3 + " s");
    }
}
