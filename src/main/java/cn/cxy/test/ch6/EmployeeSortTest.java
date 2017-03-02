package cn.cxy.test.ch6;

import java.io.*;
import java.util.Arrays;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/2/23 11:46 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class EmployeeSortTest {

    public static void main(String[] args){
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Harry",35000);
        staff[1] = new Employee("HarryPorter",25000);
        staff[2] = new Employee("HarryJack",55000);

        //实现 Comparable<T> 接口，实现自动排序【元素之间必须是可以比较的】
        Arrays.sort(staff);
        for (Employee e : staff){
            System.out.println("name= "+e.getName()+" , salary="+e.getSalary());
        }

    }

}

class Employee implements Comparable<Employee>,Cloneable{

    private String name;
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public Employee() {
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public int compareTo(Employee o) {
        if (salary < o.getSalary()) return -1;
        if (salary > o.getSalary()) return 1;
        return 0;
    }

    /**
     * 深度克隆对象 -- 包含其中引用对象的克隆
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Object deepClone() throws IOException, ClassNotFoundException {
        //将对象写入流中
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutput oos = new ObjectOutputStream(baos);
        oos.writeObject(this);
        //将对象从流中读出
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        return ois.readObject();
    }
}
