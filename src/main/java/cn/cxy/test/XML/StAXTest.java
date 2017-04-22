package cn.cxy.test.XML;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Function: XML解析 - 使用StAX解析 - 解析给定url地址中的超链接 -- “网络爬虫”
 * Reason: TODO XML解析 - StAX解析器 - 是一种“拉解析器” - 命名空间感知默认开启
 * Date: 2017/4/22 10:24 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class StAXTest {

    public static void main(String[] args) throws IOException, XMLStreamException {
        String urlString;
        if (args.length == 0) {
            urlString = "http://www.w3c.org";
            System.out.println("Using: " + urlString);
        } else {
            urlString = args[0];
        }
        URL url = new URL(urlString);
        InputStream in = url.openStream();
        XMLInputFactory factory = XMLInputFactory.newFactory();
        //cxy 关闭命名空间感知
        //factory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE,false);
        XMLStreamReader reader = factory.createXMLStreamReader(in);
        while (reader.hasNext()) {
            int next = reader.next();
            if (next == XMLStreamConstants.START_ELEMENT) {
                if (reader.getLocalName().equals("a")) {
                    String href = reader.getAttributeValue(null, "href");
                    if (href != null) {
                        System.out.println(href);
                    }
                }
            }
        }
    }

}
