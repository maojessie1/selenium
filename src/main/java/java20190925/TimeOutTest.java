package java20190925;

import org.testng.annotations.Test;

public class TimeOutTest {
    @Test(timeOut = 3000)  //µ•Œª∫¡√Î÷µ
    public void testSuccess() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("test");
    }
    @Test(timeOut = 2000)
    public void testFailed() throws InterruptedException {
        Thread.sleep(3000);
    }
}
