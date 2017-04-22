/**
 * Function: TODO
 * Reason: java.util.concurrent.Callable<V> 与 java.util.concurrent.Runnable
 *         Callable 接口有返回值；只有一个方法 call()
 * Date: 2017/3/25 14:43 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
package cn.cxy.test.Thread.ThreadPool;

/**
 * java.util.concurrent.Executors 执行器；构建线程池的几种方法【静态】
 *      newCachedThreadPool() 必要时创建新线程；空闲线程保持60秒
 *      newFixedThreadPool()  该池包含固定数量的线程；空闲线程会一直被保留
 *      newSingleThreadPool() 只有一个线程的“池”，该线程顺序执行每一个提交的任务
 *      newScheduledThreadPool() 用于预定执行而构建的固定线程池，替代 java.util.Timer
 *      newSingleThreadPoolScheduledExecutors() 用于预定执行而构建的单线程“池”
 * */
