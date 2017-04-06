package cn.cxy.test.IO_File;

import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/4/6 18:41 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class RandomAccessTest {

    public static void main(String[] args){
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Carl", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry", 50000, 1986, 11, 25);
        staff[2] = new Employee("Tony", 40000, 1988, 10, 12);

        String path = "E:" + File.separator + "employee.dat";

        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream(path));
            for (Employee e : staff) {
                writeData(out,e);
            }

            RandomAccessFile in = new RandomAccessFile(path,"r");

            int n = (int) (in.length() / Employee.RECORD_SIZE);
            Employee[] newStaff = new Employee[n];
            for (int i = n-1;i>=0;i--){
                newStaff[i] = new Employee();
                in.seek(i * Employee.RECORD_SIZE);
                newStaff[i] = readData(in);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static Employee readData(RandomAccessFile in) throws IOException {
        String name = DataIO.readFixedString(Employee.NAME_SIZE, in);
        double salary = in.readDouble();
        int y = in.readInt();
        int m = in.readInt();
        int d = in.readInt();
        return new Employee(name,salary,y,m,d);
    }

    private static void writeData(DataOutputStream out, Employee e) throws IOException {
        DataIO.writeFixedString(e.getName(),Employee.NAME_SIZE,out);
        out.writeDouble(e.getSalary());
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(e.getHireDay());
        out.writeInt(calendar.get(Calendar.YEAR));
        out.writeInt(calendar.get(Calendar.MONTH)+1);
        out.writeInt(calendar.get(Calendar.DAY_OF_MONTH));
    }

}
