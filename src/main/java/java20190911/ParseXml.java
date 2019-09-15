package java20190911;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class ParseXml {
    private String filePath;
    private Document document;

    ParseXml(String filePath){
        this.filePath = filePath;
        load(this.filePath);
    }

    private  void load(String filePath) {
        File file = new File(filePath);
        if (file.exists()){
            try {
                SAXReader saxReader = new SAXReader();
                document=saxReader.read(file);
            } catch (DocumentException e) {
                System.out.println("文件加载异常"+filePath);
            }
        }else {
            System.out.println("文件不存在"+filePath);
        }
    }

    public Element getObject(String elementPath){
        return (Element)document.selectSingleNode(elementPath);
    }

    public List<Element> getObjects(String elementPath){
        return document.selectNodes(elementPath);
    }

    public boolean isExist(String elementPath){
        boolean flag =false;
        Element element = this.getObject(elementPath);
        if (element != null) {
            flag = true;
        }
        return flag;
    }

    public String getElementText(String elementPath){
        Element object = this.getObject(elementPath);
        if (object != null) {
            return object.getTextTrim();
        }
        return null;
    }


}














// filePath = "src\\main\\resources\\config.xml";