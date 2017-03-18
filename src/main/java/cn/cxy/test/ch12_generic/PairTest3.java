package cn.cxy.test.ch12_generic;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Function: 泛型测试
 * Reason: TODO 看不太懂 实例化 T 与通配符及泛型中关键字 extends & super .</br>
 * Date: 2017/3/18 13:32 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class PairTest3 {

    public static void main(String[] args){
        Manager ceo = new Manager("Gus Greedy",800000,2003,12,15);
        Manager cfo = new Manager("Sid Sneaky",600000,2003,12,15);
        Pair<Manager> buddies = new Pair<Manager>(ceo,cfo);
        printBuddies(buddies);

        ceo.setBonus(100000);
        cfo.setBonus(80000);
        Manager[] managers = {ceo,cfo};
        Pair<Employee> result = new Pair<Employee>();
        minMaxBonus(managers,result);
        System.out.println("first: "+result.getFirst().getName()+" ,second: "+result.getSecond().getName());

        maxMinBonus(managers,result);
        System.out.println("first: "+result.getFirst().getName()+" ,second: "+result.getSecond().getName());
    }

    //TODO ? super Manger
    public static void maxMinBonus(Manager[] a, Pair<? super Manager> result){
        minMaxBonus(a,result);
        PairAlg.swapHelper(result);
    }

    //TODO ? super Manger
    public static void minMaxBonus(Manager[] a, Pair<? super Manager> result){
        if (a == null || a.length == 0) return;
        Manager min = a[0];
        Manager max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (min.getBonus() > a[i].getBonus()) min = a[i];
            if (min.getBonus() < a[i].getBonus()) max = a[i];
        }
        result.setFirst(min);
        result.setSecond(max);
    }

    //TODO ? extends Employee
    public static void printBuddies(Pair<? extends Employee> p){
        Employee first = p.getFirst();
        Employee second = p.getSecond();
        System.out.println(first.getName()+" and "+second.getName()+" are buddies");
    }

}

class PairAlg{
    public static boolean hasNulls(Pair<?> p){
        return p.getFirst() == null || p.getSecond() == null;
    }

    public static void swap(Pair<?> p){
        swapHelper(p);
    }

    public static <T> void swapHelper(Pair<T> p) {
        T t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }
}

class Employee{
    private String name;
    private double salary;
    private Date hireDay;

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public Employee(String name, double salary, int year,int month,int day) {
        this.name = name;
        this.salary = salary;
        GregorianCalendar calendar = new GregorianCalendar(year,month - 1,day);
        this.hireDay = calendar.getTime();
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Date getHireDay() {
        return hireDay;
    }
}

class Manager extends Employee{
    private double bonus;

    @Override
    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        bonus = 0;
    }
}
