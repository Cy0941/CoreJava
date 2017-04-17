package cn.cxy.test.IO_File;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.List;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/4/6 18:05 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class MainTest {

    public static void main(String[] args) {
        //确定当前当前平台哪些字符集可用
        //SortedMap<String, Charset> cset = Charset.availableCharsets();
        //for (String name : cset.keySet()){
        //    System.out.println(cset.get(name));
        //}

        //编码
        Charset cs = Charset.forName("UTF-16");
        //此编码的别名
        /*Set<String> aliases = cs.aliases();
        for (String alias : aliases) {
            System.out.println(alias);
        }*/
        String str = "这是测试内容";
        ByteBuffer buf = cs.encode(str);
        byte[] array = buf.array();
        System.out.println(Arrays.toString(array));
        //解码
        ByteBuffer wrap = ByteBuffer.wrap(array);
        CharBuffer decode = cs.decode(wrap);//使用相同charset进行解码
        String s = decode.toString();
        System.err.println(s);

        System.out.println("----------------------------");

        try {
            String path = "F:" + File.separator + "test.txt";
            File file = new File(path);
            //TODO 使用 java.nio.Files 进行文件读写
            Path pat = file.toPath();
            byte[] bytes = Files.readAllBytes(pat);
            //作为字符串读入
            String content = new String(bytes, Charset.forName("utf-8"));
            System.out.println(content);
            System.err.println("--------------");
            //作为行序列读入
            List<String> lines = Files.readAllLines(pat, Charset.forName("utf-8"));
            for (String line : lines) {
                System.out.println(line);
            }
            String tmpContents = "这是新内容";
            //TODO 向目标文件中写入内容；
            Path write = Files.write(pat, tmpContents.getBytes("utf-8"));
            //支持续写等
            Files.write(pat, "这是续写内容".getBytes("utf-8"), StandardOpenOption.APPEND);
            System.out.println(write.toFile().getName());

            System.err.println("-------------------------");
            //获取文件的创建时间、修改时间、文件类型、文件大小等信息
            BasicFileAttributes a = Files.readAttributes(pat, BasicFileAttributes.class);
            System.out.println(a.size());

            String string = "F:" + File.separator;
            File tmp = new File(string);
            //迭代目录中的文件 - 旧的 file 在目录中包含文件较多时，性能非常低
            //TODO 可以使用 glob 模式进行文件过滤
            //此方法不会进行递归循环
            DirectoryStream<Path> paths = Files.newDirectoryStream(tmp.toPath(),"*.7z");
            for (Path p : paths) {
                System.out.println("---"+p.getFileName());
            }

            //TODO 访问某个目录的所有子孙成员
            Path p = Files.walkFileTree(tmp.toPath(), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    System.out.println(dir.getFileName());
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }
            });

            //ZIP 文件系统
            FileSystem fileSystem = FileSystems.newFileSystem(Paths.get("F:" + File.separator + "F.zip"), null);


            //InputStream in = Files.newInputStream(path);
            //OutputStream out = Files.newOutputStream(path);
            //BufferedReader reader = Files.newBufferedReader(path, Charset.forName("utf-8"));
            //BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("utf-8"));

            /*Path fromPath = null;
            Path toPath = null;
            //文件拷贝 - 支持对目标路径已有文件操作
            Files.copy(fromPath,toPath,StandardCopyOption.COPY_ATTRIBUTES);
            //文件移动 - 支持对目标路径已有文件操作
            Files.move(fromPath,toPath, StandardCopyOption.REPLACE_EXISTING);

            //删除文件 - 如果文件不存在则抛出异常
            Files.delete(fromPath);
            //删除文件 - 不抛出异常，返回 false；同时支持移除空目录
            boolean b = Files.deleteIfExists(fromPath);

            //创建新目录 - 路径中除最后一个外，所有父路径都必须是存在的
            Files.createDirectory(fromPath);
            //创建新目录 - 可以创建所有路径，包含中间路径
            Path directories = Files.createDirectories(fromPath);
            //创建一个空文件 - 如果文件已经存在则抛出异常
            Files.createFile(fromPath);*/

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
