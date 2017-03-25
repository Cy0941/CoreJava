package cn.cxy.test.ch14_thread.ThreadWithQueue;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/3/25 12:12 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class BlockingQueueTest {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter base directory: ");
        String directory = in.nextLine();
        System.out.print("Enter keyword: ");
        String keyword = in.nextLine();

        final int FILE_QUEUE_SIZE = 10;
        final int SEARCH_THREADS = 100;

        BlockingQueue<File> queue = new ArrayBlockingQueue<File>(FILE_QUEUE_SIZE);
        FileEnumerationTask enumeration = new FileEnumerationTask(queue,new File(directory));
        new Thread(enumeration).start();//开启文件夹遍历线程
        for (int i = 1; i < SEARCH_THREADS; i++) {
            new Thread(new SearchTask(queue,keyword)).start();//开启查找线程
        }
    }

}
