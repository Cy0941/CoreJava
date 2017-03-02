package cn.cxy.test.ch6;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/2/27 22:44 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class Employee implements Cloneable {

    private String name;
    private Double salary;
    private Date hireDay;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", hireDay=" + hireDay +
                '}';
    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    /**
     * Set the hire day to a given date
     * @param year
     * @param month
     * @param day
     */
    public void setHireDay(int year,int month,int day){
        Date newHireDay = new GregorianCalendar(year,month - 1,day).getTime();
        //TODO hireDay 为 java.util.Date 为非基本数据类型，可以直接调用对应方法修改值
        hireDay.setTime(newHireDay.getTime());
    }

    /**
     * 自定义实现深克隆
     * @return
     * @throws CloneNotSupportedException
     */
    public Employee clone() throws CloneNotSupportedException {
        Employee cloned = (Employee)super.clone();
        //深克隆需要处理每一个非基础类型的字段
        cloned.hireDay = (Date)hireDay.clone();
        return cloned;
    }

    public Employee(String name, Double salary, Date hireDay) {
        this.name = name;
        this.salary = salary;
        this.hireDay = hireDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public void setHireDay(Date hireDay) {
        this.hireDay = hireDay;
    }
}
