package cn.cxy.test.IO_File;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Function: 压缩测试
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/4/7 17:46 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class ZipTest {

    public static void main(String[] args) {

        FileOutputStream outputStream = null;
        ZipOutputStream zipOutputStream = null;
        FileInputStream fileInputStream = null;
        try {
            String filePath = "E:" + File.separator + "dict.txt";
            String zipPath = "E:" + File.separator + "dict2.zip";
            outputStream = new FileOutputStream(zipPath);
            zipOutputStream = new ZipOutputStream(outputStream);
            File file = new File(filePath);
            fileInputStream = new FileInputStream(file);

            ZipEntry zipEntry = new ZipEntry(file.getName());
            zipOutputStream.putNextEntry(zipEntry);
            zipOutputStream.setComment("测试注释");
            byte[] tmp = new byte[1024];
            int length;
            while ((length = fileInputStream.read(tmp)) > 0) {
                zipOutputStream.write(tmp, 0, length);
            }
            zipOutputStream.closeEntry();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fileInputStream) {
                    fileInputStream.close();
                }
                if (null != zipOutputStream) {
                    zipOutputStream.close();
                }
                if (null != outputStream) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.exit(0);


        ZipInputStream zipInputStream = null;
        try {
            String zipPath = "E:" + File.separator + "dict.zip";
            zipInputStream = new ZipInputStream(new FileInputStream(zipPath));
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                long compressedSize = zipEntry.getCompressedSize();
                String name = zipEntry.getName();
                long size = zipEntry.getSize();
                long time = zipEntry.getTime();
                String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(time));
                System.out.println(compressedSize + " : " + name + " : " + size + " : " + format);
                //读取文件内部的内容
                Scanner in = new Scanner(zipInputStream);
                while (in.hasNextLine()) {
                    String s = in.nextLine();
                    System.out.println(s);
                }
                //TODO 每一个 zipEntry 末尾都需要进行关闭
                zipInputStream.closeEntry();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != zipInputStream) {
                    zipInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
