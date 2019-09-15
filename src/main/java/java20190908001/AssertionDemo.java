package java20190908001;

import org.testng.Assert;

public class AssertionDemo {
    public static boolean flag = true;
    public static void verityEquals(Object actual, Object expected){
        try {
            System.out.println("start");
            Assert.assertEquals(actual,expected);
            System.out.println("end");
        } catch (Exception e) {
            flag = false;
        }
    }

    public static void verifyEquals(Object actual,Object expected,String message){
        try {
            System.out.println("start!");
            Assert.assertEquals(actual,expected,message);
            System.out.println("end");
        } catch (Exception e) {
            flag = true;
        }
    }

}
