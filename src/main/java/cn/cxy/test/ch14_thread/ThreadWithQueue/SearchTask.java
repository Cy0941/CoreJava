package cn.cxy.test.ch14_thread.ThreadWithQueue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

/**
 * Function: 搜索线程
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/3/25 12:35 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class SearchTask implements Runnable {

    private BlockingQueue<File> queue;
    private String keyword;

    public void run() {
        try {
            boolean done = false;
            while (!done){
                File file = queue.take();//返回队列头元素
                if (file == FileEnumerationTask.DUMMY){
                    //TODO
                    queue.put(file);//添加一个元素
                    done = true;
                }else {
                    search(file);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void search(File file) throws FileNotFoundException {
        Scanner in = new Scanner(new FileInputStream(file));
        int lineNumber = 0;
        while (in.hasNext()){
            String line = in.nextLine();
            if (line.contains(keyword)){
                //TODO
                System.out.printf("%s:%d:%s%n",file.getPath(),lineNumber,line);
            }
        }
        in.close();
    }

    public SearchTask(BlockingQueue<File> queue, String keyword) {
        this.queue = queue;
        this.keyword = keyword;
    }
}
