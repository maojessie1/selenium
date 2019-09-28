package java20190925;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {
    @Test(groups = "server")
    public void test1(){
        System.out.println("fuwuduan1");

    }
    @Test(groups = "server")
    public void test2(){
        System.out.println("fuwuduan2");

    }
    @Test(groups = "client")
    public void test3(){
        System.out.println("fuwuduan3");

    }
    @Test(groups = "client")
    public void test4(){
        System.out.println("4");
    }
    @BeforeGroups("server")
    public void beforeGroupsOnServer(){
        System.out.println("BeforeGroups");
    }

    @AfterGroups("server")
    public void AfterGroupsOnServer(){
        System.out.println("AfterGroups");
    }


    @BeforeGroups("client")
    public void beforeGroupsOnClient(){
        System.out.println("BeforeGroups");
    }

    @AfterGroups("client")
    public void AfterGroupsOnclient(){
        System.out.println("AfterGroups");
    }

}
