package java20190818;


import org.dom4j.Element;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.List;

public class TestBase {
    @DataProvider
    public Object[][] providerMethod(Method method){
        ParseXml px = new ParseXml("src\\main\\resources\\Test1.xml");
        String methodName=method.getName();
        List<Element> elements = px.getElementObjects("/*/"+methodName);
        Object[][] objects = new Object[elements.size()][];
        for (int i = 0; i <elements.size() ; i++) {
            Object[] temp = new Object[]{px.getChildrenInfoByElement(elements.get(i))};
            objects[i] = temp;
        }
        return objects;
    }
}
