package cn.cxy.test.XML;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Function: XML 文档读取测试
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/4/20 9:02 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class XMLReadTest {

    /**
     * 使用JDK自带DOM解析器
     *
     * @param args 示例读取：
     *             <?xml version="1.0" encoding="UTF-8"?>
     *             <font>
 *                  <name color="red">
     *                  HarryPorter
     *              </name>
     *              <size>36</size>
     *             </font>
     */
    public static void main(String[] args) {
        try {
            //1、获取 DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            //2、待读取的xml文档
            File file = null;
            //URL url = null; // 或者从 URL 读取
            //InputStream inputStream = null; //或者从输入流读入

            //3、获取 Document ：为 XML 文档的树形结构在内存中表现
            Document parse = builder.parse(file);
            //4、分析由此方法开始 - 将返回根元素，即<font></font>
            Element root = parse.getDocumentElement();
            //获取元素标签名 - font
            String tagName = root.getTagName();
            //5、得到根元素的子元素（子元素、文本、注释、其他节点等） - TODO 如上示例文档，将获取到5个元素【包含各元素之间空格等，如 font 和 name 之间的空格】
            NodeList childNodes = root.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node child = childNodes.item(i);
                //TODO 如上示例文档，如果希望忽略空白字符
                //如果有 DTD 文档类型定义，则自动剔除空格
                if (child instanceof Element){
                    Element childElement = (Element)child;
                    //6、子节点所包含的文本字符串都包含在 Text 类型的子节点中 - 可以继续遍历 childElement 或者方法 getFirstChild()/getLastChild()【只有唯一子节点】
                    Text textNode = (Text) childElement.getFirstChild();
                    //7、获取节点内的文本
                    String text = textNode.getData().trim();
                    //8、获取节点的属性名称及属性值
                    NamedNodeMap attributes = textNode.getAttributes();
                    for (int k = 0;k < attributes.getLength(); k++){
                        Node attribute = attributes.item(k);
                        //属性名称
                        String nodeName = attribute.getNodeName();
                        //属性值
                        String nodeValue = attribute.getNodeValue();
                        //fixme 属性类型
                        short nodeType = attribute.getNodeType();
                    }
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
