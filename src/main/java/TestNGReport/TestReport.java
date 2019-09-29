package TestNGReport;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestReport {

    public static class java {
        public static class TestMethodsDemo {
            @Test
            public void test1(){
                Assert.assertEquals(1,2);
            }
            @Test
            public void test2(){
                Assert.assertEquals(1,1);
            }

            @Test
            public void test3(){
                Assert.assertEquals("aaa","aaa");
            }

            @Test
            public void log(){
                Reporter.log("???????????§Õ?????");
                throw new RuntimeException("??????????????????");
            }
        }
    }
}
