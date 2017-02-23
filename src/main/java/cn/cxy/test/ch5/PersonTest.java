package cn.cxy.test.ch5;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/2/16 11:32 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class PersonTest {
    public static void main(String[] args){
        Person2[] people = new Person2[2];
        people[0] = new Employee2("Harry Hacker",50000,1989,10,1);
        people[1] = new Student2("Maria Morris","computer science");
        for (Person2 p : people){
            System.out.println(p.getName()+" : "+p.getDescription());
        }
    }
}


abstract class Person2{
    private String name;
    public Person2(String n){
        name = n;
    }
    public abstract String getDescription();
    public String getName(){
        return name;
    }
}

class Employee2 extends Person2{
    private double salary;
    private Date hireDate;
    public Employee2(String n,double s,int year,int month,int day){
        super(n);
        salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year,month-1,day);
        hireDate = calendar.getTime();
    }

    public double getSalary() {
        return salary;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public String getDescription() {
        return String.format("an employee2 with a salary of $%.2f",salary);
    }
    public void raiseSalary(double byPercent){
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}

class Student2 extends Person2{
    private String major;
    public Student2(String n,String m) {
        super(n);
        major = m;
    }
    public String getDescription() {
        return "a student majoring in "+major;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}