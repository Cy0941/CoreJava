package cn.cxy.test.XML;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Function: XML解析 - 使用SAX解析 - 解析给定url地址中的超链接 -- “网络爬虫”
 * Reason: TODO XML解析 - SAX解析器 - 通过安装对应事件进行回调解析 - 命名空间感知默认关闭
 * Date: 2017/4/22 9:33 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class SAXTest {

    public static void main(String[] args) throws SAXException, ParserConfigurationException, IOException {
        String url;
        if (args.length == 0){
            url = "http://www.w3c.org";
            System.out.println("Using: "+url);
        }else {
            url = args[0];
        }
        DefaultHandler handler = new DefaultHandler(){
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if (localName.equals("a") && attributes != null){
                    for (int i = 0; i < attributes.getLength(); i++){
                        String aName = attributes.getLocalName(i);
                        if (aName.equals("href")){
                            System.out.println(attributes.getValue(i));
                        }
                    }
                }
            }
        };
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //cxy 打开命名空间处理特性
        factory.setNamespaceAware(true);
        factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd",false);
        SAXParser saxParser = factory.newSAXParser();
        InputStream inputStream = new URL(url).openStream();
        saxParser.parse(inputStream,handler);
    }

}
