package cn.cxy.test.ch11;

import java.io.IOException;

/**
 * Function: 自定义异常
 * Reason: 应该包含两个构造器：
 *              1、默认的构造器
 *              2、带有详细描述细信息的构造器（Throwable 的 toString() 方法会打印详细信息
 * Date: 2017/3/15 23:46 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class FileFormatException extends IOException {

    public FileFormatException() {
    }

    public FileFormatException(String message) {
        super(message);
    }
}
