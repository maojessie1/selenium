package java20190925;

import org.testng.annotations.Test;

public class IgnoreTest {
    @Test
    public void ignore1(){
        System.out.println("4");
    }
    @Test(enabled = false)
    public void Ignore2(){
        System.out.println("2");
    }
    @Test(enabled = true)
    public void Ignore3(){
        System.out.println("3");
    }
}
