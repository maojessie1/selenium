package java20190925;

import org.testng.annotations.Test;

//“¿¿µ
public class DependTest {
    @Test
    public void test1(){
        System.out.println("test1 run");
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());

//        throw new RuntimeException();
    }

    @Test(dependsOnMethods = {"test1"})
    public void test2(){

        System.out.println("test2 run");
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());

    }
}
