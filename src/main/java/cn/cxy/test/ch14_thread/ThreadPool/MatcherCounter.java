package cn.cxy.test.ch14_thread.ThreadPool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/3/25 14:42 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class MatcherCounter implements Callable<Integer> {

    private File directory;
    private String keyword;
    private ExecutorService pool;
    private int count;

    public Integer call() throws Exception {
        count = 0;
        File[] files = directory.listFiles();
        ArrayList<Future<Integer>> results = new ArrayList<Future<Integer>>();
        for (File file : files) {
            if (file.isDirectory()) {
                MatcherCounter counter = new MatcherCounter(file, keyword, pool);
                Future<Integer> result = pool.submit(counter);
                results.add(result);
            } else {
                if (search(file)) {
                    count++;
                }
            }
        }
        for (Future<Integer> result : results) {
            count += result.get();
        }
        return count;
    }

    public boolean search(File file) {
        try {
            Scanner in = new Scanner(new FileInputStream(file));
            boolean found = false;
            while (!found && in.hasNext()) {
                String line = in.nextLine();
                if (line.contains(keyword)) {
                    found = true;
                }
            }
            in.close();
            return found;
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    public MatcherCounter(File directory, String keyword, ExecutorService pool) {
        this.directory = directory;
        this.keyword = keyword;
        this.pool = pool;
    }
}
