package cn.cxy.test;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/2/14 10:10 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class ParamTest {

    public static void main(String[] args){
        System.out.println("Testing tripleValue");
        double percent = 10;
        System.out.println("Before: percent="+percent);
        tripleValue(percent);
        System.out.println("After: percent="+percent);


        System.out.println("\nTesting tripleSalary");
        Employee harry = new Employee("Harry",5000);
        System.out.println("Before: salary="+harry.getSalary());
        tripleSalary(harry);
        System.out.println("After: salary="+harry.getSalary());


        System.out.println("\nTesting swap");
        Employee a = new Employee("Alice",7000);
        Employee b = new Employee("Bob",6000);
        System.out.println("Before: a="+a.getName());
        System.out.println("After: b="+b.getName());
        swap(a,b);
        System.out.println("After: a="+a.getName());
        System.out.println("After: b="+b.getName());

        System.err.println(null instanceof String);
    }

    public static void swap(Employee x,Employee y){
        Employee temp = x;
        x = y;
        y = temp;
        System.err.println("End of method: x="+x.getName());
        System.err.println("End of method: y="+y.getName());
    }
    public static void tripleValue(double x){
        x *= 3;
        System.err.println("End of method: x="+x);
    }

    public static void tripleSalary(Employee x){
        x.raiseSalary(200);
        System.err.println("End of method: salary="+x.getSalary());
    }

}
