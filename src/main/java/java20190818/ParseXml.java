package java20190818;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParseXml {
    private Document document;
    private String filePath;
    ParseXml(String filePath){
        this.filePath = filePath;
        load(filePath);
    }

    private void load(String filePath){
        File file = new File(filePath);
        if (file.exists()){
            SAXReader saxReader = new SAXReader();
            try {
                document=saxReader.read(file);
            } catch (DocumentException e) {
                System.out.println("文件加载错误"+filePath);
            }
        }else {
            System.out.println("文件不存在"+filePath);
        }
    }

    private Element getElementObject(String elementPath){
        return (Element) document.selectSingleNode(elementPath);
    }

    public List<Element> getElementObjects(String elementPath){
        return document.selectNodes(elementPath);
    }

    public Map<String,String> getChildrenInfoByElement(Element element){
        Map<String,String> map = new HashMap<>();
        List<Element> children = element.elements();
        for (Element ch : children) {
            map.put(ch.getName(),ch.getText());
        }
        return map;
    }

    public boolean isExist(String elementPath){
        boolean flag = false;
        Element element = this.getElementObject(elementPath);
        if (element != null) {
            flag = true;
        }
        return flag;
    }

    public String getElementText(String elementPath){
        Element element = this.getElementObject(elementPath);
        if (element != null) {
            return element.getTextTrim();
        }

        return null;
    }
}
