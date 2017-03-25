package cn.cxy.test.ch14_thread.ThreadPool;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * Function: 线程池测试
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/3/25 14:38 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class ThreadPoolTest {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter base directory:");
        String directory = in.nextLine();
        System.out.println("Enter keyword:");
        String keyword = in.nextLine();

        //必要时创建线程；空闲线程保持60秒；其他线程池创建均通过 java.util.concurrent.Executors 静态方法创建
        ExecutorService pool = Executors.newCachedThreadPool();
        //Executors.newFixedThreadPool(100);
        MatcherCounter counter = new MatcherCounter(new File(directory),keyword,pool);
        Future<Integer> result = pool.submit(counter);

        try {
            System.out.println(result.get()+" matching files.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //启动该线程池的关闭序列且不再接受新的任务；当所有任务完成之后，线程池中的线城死亡
        pool.shutdown();
        int largestPoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
        System.out.println("Largest pool size = "+largestPoolSize);
    }

}
