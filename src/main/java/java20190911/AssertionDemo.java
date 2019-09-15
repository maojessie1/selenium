package java20190911;

import org.testng.Assert;

public class AssertionDemo {
    public static boolean flag = true;

    public static void verityEquals(Object actual,Object expected){
        try {
            Assert.assertEquals(actual,expected);
        } catch (Exception e) {
            flag = false;
        }
    }

    public static void verityEquals(Object actual,Object expected,String message){
        try {
            Assert.assertEquals(actual,expected,message);
        } catch (Exception e) {
            flag = false;
        }
    }
}
