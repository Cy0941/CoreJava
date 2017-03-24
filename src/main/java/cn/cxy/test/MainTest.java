package cn.cxy.test;

import cn.cxy.test.ch6.Employee;

import java.util.*;

/**
 * Function: 一般测试
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/3/21 14:45 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class MainTest {

    public static void main(String[] args) {
        ArrayList<Integer> aList = (ArrayList<Integer>) initList(new ArrayList<Integer>(), 2000000);
        LinkedList<Integer> lList = (LinkedList<Integer>) initList(new LinkedList<Integer>(), 50000);

        accessList(aList);
        accessList(lList);

        System.out.println("ArrayList");
        accessListByLoop(aList);
        accessListByIterator(aList);

        System.out.println("LinkedList");
        accessListByLoop(lList);
        accessListByIterator(lList);

        List<String> list = Collections.nCopies(100, "DEFAULT");
        System.out.println("list.size():"+list.size());
        //List<String> subList = list.subList(10, 20);
        //TODO
        //list.removeAll(subList);
        //System.out.println("list.size():"+list.size());

        String[] strs = list.toArray(new String[list.size()]);
        System.out.println(Arrays.toString(strs));

        List<Employee> empList = new ArrayList<Employee>();
        for (int i = 0; i < 10; i++) {
            Employee emp = new Employee("Jack_"+i,Double.valueOf(i+"00"),Calendar.getInstance().getTime());
            empList.add(emp);
        }
        Employee[] array = empList.toArray(new Employee[empList.size()]);
        System.err.println("collection to array:"+Arrays.toString(array));

    }

    public static List initList(List list, int n) {
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        return list;
    }

    public static void accessList(List list) {
        long startTime = System.currentTimeMillis();
        if (list instanceof RandomAccess) {
            System.out.println("实现了 for 循环 RandomAccess 接口。。。");
            for (int i = 0; i < list.size(); i++) {
                list.get(i);
            }
        } else {
            System.out.println("未实现 iterator 遍历 RandomAccess 接口。。。");
            for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
                iterator.next();
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("遍历时间：" + (endTime - startTime));
    }

    public static void accessListByLoop(List list) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("for遍历时间：" + (endTime - startTime));
    }

    public static void accessListByIterator(List list) {
        long startTime = System.currentTimeMillis();

        for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
            iterator.next();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Iterator遍历时间：" + (endTime - startTime));
    }

}
