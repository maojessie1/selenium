package java20190925;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamterTest {
    //数据来源与xml，Paramter.xml
    @Test
    @Parameters({"name","age"})
    public void paramTest1(String name,int age){
        System.out.println("name = "+name+";  age = "+age);
    }
}
