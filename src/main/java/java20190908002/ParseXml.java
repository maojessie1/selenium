package java20190908002;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class ParseXml {
    private String filepath;
    private Document document;

    public ParseXml(String filepath) {
        this.filepath = filepath;
        load(this.filepath);
    }

    private void load(String filepath) {
        File file = new File(filepath);
        if (file.exists()) {
            SAXReader saxReader = new SAXReader();
            try {
                document = saxReader.read(file);
            } catch (DocumentException e) {
                System.out.println("文件异常" + filepath);
            }
        } else {
            System.out.println("文件不存在" + filepath);
        }
    }

    public Element getElementObject(String elementPath) {
        return (Element) document.selectSingleNode(elementPath);
    }

    public List<Element> getElementObjects(String elementPath) {
        return document.selectNodes(elementPath);
    }

    public boolean isExist(String elementPath) {
        boolean flag = false;
        Element element = this.getElementObject(elementPath);
        if (element != null) {
            flag = true;
        }
        return flag;
    }

        public String getElementText (String elementPath){
            Element elementObject = this.getElementObject(elementPath);
            if (elementObject != null) {
                return elementObject.getTextTrim();
            } else {

                return null;
            }
        }


}