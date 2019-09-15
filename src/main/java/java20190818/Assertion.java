package java20190818;

import org.testng.Assert;

public class Assertion {
    public static boolean flag = true;
    public static void verifyEquals(Object actual,Object excepted){
        try {
            Assert.assertEquals(actual,excepted);
        } catch (Exception e) {
            flag=false;
        }
    }

    public static void verityEquals(Object actual,Object excepted,String message){
        try {
            Assert.assertEquals(actual,excepted,message);
        } catch (Exception e) {
            flag =false;
        }
    }
}
