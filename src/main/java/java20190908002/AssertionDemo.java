package java20190908002;

import org.testng.Assert;

public class AssertionDemo {
    public static boolean flag = false;

    public static void verifyEquals(Object actual,Object expected){
        try {
            System.out.println("1");
            Assert.assertEquals("1","2");
            System.out.println("2");
        } catch (Exception e) {
            flag = true;
        }
    }

    public static void verifyEquals(Object actual,Object expected,String message){
        try {
            System.out.println("1");
            Assert.assertEquals("1","1","m");
            System.out.println("2");
        } catch (Exception e) {
            flag = true;
        }
    }
}
