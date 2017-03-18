package cn.cxy.test.ch12_generic;

import java.util.*;

/**
 * Function: 优先级队列：典型使用场景为任务调度
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/3/18 15:53 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class PriorityQueueTest {

    public static void main(String[] args){
        PriorityQueue<GregorianCalendar> pq = new PriorityQueue<GregorianCalendar>();
        pq.add(new GregorianCalendar(1906, Calendar.DECEMBER,9));
        pq.add(new GregorianCalendar(1815, Calendar.DECEMBER,10));
        pq.add(new GregorianCalendar(1903, Calendar.DECEMBER,3));
        pq.add(new GregorianCalendar(1910, Calendar.JUNE,22));
        System.out.println("Interating over elements ...");
        for (GregorianCalendar date : pq) {
            System.out.println(date.get(Calendar.YEAR));
        }
        System.out.println("Removing elements ...");
        while (!pq.isEmpty()){
            System.out.println(pq.remove().get(Calendar.YEAR));
        }

        Map<String,String> map = new HashMap<String, String>();
        map.put("key_1","value_1");
        map.put("key_2","value_2");
        map.put("key_3","value_3");
        map.put("key_4","value_4");
        System.err.println(map);
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entrySet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
