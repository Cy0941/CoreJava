package cn.cxy.test;

import java.util.Date;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/2/13 18:18 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class Employee {

    private double salary;

    private Date hireDay;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getHireDay() {
//        return hireDay;
        //TODO 避免破坏封装
        return (Date)hireDay.clone();
    }

    public void setHireDay(Date hireDay) {
        this.hireDay = hireDay;
    }
}

class Test{
    public static void main(String[] args){
        Employee harry = new Employee();
        harry.setHireDay(new Date());

        Date d = harry.getHireDay();
        double tenYearsInMilliSeconds = 10*365*24*60*60*1000;
        d.setTime(d.getTime()-(long)tenYearsInMilliSeconds);

        //TODO JavaBean 中不要编写返回引用可变对象的访问器方法

        //TODO 此时 hireDay 属性不仅可以通过 setHireDay() 进行修改，还能通过 harry.getHireDay() 得到的值进行修改 -- 破坏封装

        //TODO 如果需要返回一个可变对象的应用而又不破坏封装，则应该对其克隆（clone()）

    }
}
