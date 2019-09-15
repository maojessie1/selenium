package java20190818;

import org.testng.annotations.Test;

import java.util.Map;

public class Test1 extends TestBase{
    @Test(dataProvider = "providerMethod")
    public void testLogin(Map<String , String>param){
//        System.out.println(param.get("username"));
        Log.logInfo(param.get("username"));
        Log.logInfo(param.get("password"));
        Log.logInfo(param.get("inputValue"));
        Log.logInfo(param.get("url"));
    }
}

