/**
 * Function: TODO
 * Reason: 对于多线程的问题，可以使用一个或多个队列解决
 *         java.util.concurrent.LinkedBlockingQueue 容量无上边界；为一个双端版本
 *         java.util.concurrent.ArrayBlockingQueue  构造时需要指定容量；并可以通过设置公平参数决定是否为等待时间最长的线程优先执行（会导致性能下降）
 *         阻塞队列方法（优先考虑使用：相较于其他方法不会抛出异常导致程序终止）：
 *                  offer - 添加一个并返回 true；队列已满返回 false
 *                  poll - 移除并返回队列的头元素；队列为空则返回 null
 *                  peek - 返回队列的头元素；队列为空返回 null
 *                  ...
 * Date: 2017/3/25 12:15 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
package cn.cxy.test.Thread.ThreadWithQueue;