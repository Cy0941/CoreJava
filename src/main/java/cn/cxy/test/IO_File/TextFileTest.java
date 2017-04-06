package cn.cxy.test.IO_File;

import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Function: TODO
 * Reason: 以二进制格式写出数据 - DataOutputStream
 *         以文本格式写出数据 - PrintWriter
 * Date: 2017/4/6 15:30 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class TextFileTest {

    public static void main(String[] args) throws UnsupportedEncodingException {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Carl", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry", 50000, 1986, 11, 25);
        staff[2] = new Employee("Tony", 40000, 1988, 10, 12);

        String path = "E:" + File.separator + "employee.dat";
        try {
            PrintWriter out = new PrintWriter(path, "utf-8");
            //save all employee records to the file employee.dat
            writeData(staff, out);

            //retrieve all records into a new array
            Scanner in = new Scanner(new FileInputStream(path), "utf-8");
            Employee[] newStaff = readData(in);
            //print the newly read employee records
            for (Employee e : newStaff) {
                System.out.println(e);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Employee[] readData(Scanner in) {
        //retrieve the array size
        //fixme 读入数组的长度？？？
        int n = in.nextInt();
        String s = in.nextLine();//consume newline
        System.out.println(s+"-----------");

        Employee[] employees = new Employee[n];
        for (int i = 0; i < employees.length; i++) {
            employees[i] = readEmployee(in);
        }
        return employees;
    }

    private static Employee readEmployee(Scanner in) {
        String line = in.nextLine();
        //TODO 转义 | 与 \ 都是正则中的特殊符号，需要转义
        String[] tokens = line.split("\\|");
        String name = tokens[0];
        double salary = Double.parseDouble(tokens[1]);
        int year = Integer.parseInt(tokens[2]);
        int month = Integer.parseInt(tokens[3]);
        int day = Integer.parseInt(tokens[4]);
        return new Employee(name, salary, year, month, day);
    }

    private static void writeData(Employee[] employees, PrintWriter out) {
        //write number of employees
        out.println(employees.length);
        for (int i = 0; i < employees.length; i++) {
            writeEmployee(out, employees[i]);
        }
        out.flush();
        out.close();
    }

    private static void writeEmployee(PrintWriter out, Employee e) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(e.getHireDay());
        out.println(e.getName() + "|" + e.getSalary() + "|" + calendar.get(Calendar.YEAR) + "|" + ((calendar.get(Calendar.MONTH)) + 1) + "|" + calendar.get(Calendar.DAY_OF_MONTH));
    }

}
