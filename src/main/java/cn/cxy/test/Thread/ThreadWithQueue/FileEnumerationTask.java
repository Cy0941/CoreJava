package cn.cxy.test.Thread.ThreadWithQueue;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * Function: 文件夹遍历线程
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/3/25 12:26 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class FileEnumerationTask implements Runnable {

    public static File DUMMY = new File("");

    private BlockingQueue<File> queue;
    private File startingDirectory;

    public void run() {
        try {
            enumerate(startingDirectory);
            //TODO 放置一个虚拟对象到队列作为结束标记
            queue.put(DUMMY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void enumerate(File directory) throws InterruptedException {
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()){
                //递归
                enumerate(file);
            }else {
                queue.put(file);
            }
        }
    }

    public FileEnumerationTask(BlockingQueue<File> queue, File startingDirectory) {
        this.queue = queue;
        this.startingDirectory = startingDirectory;
    }
}
