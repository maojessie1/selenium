package java20190818;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class SeleniumDemo {
    @Test
    public void test6(){
/*
        Assert.assertEquals("1","1");
        System.out.println("ok");
        System.out.println("start");
        Assert.assertEquals(1, 22);
        System.out.println("stop");*/
    }

    public static void main(String[] args) {

        int i = (int) (Math.random() * 30) + 1;
        System.out.println(i);
        switch (i%7){
            case 0:System.out.println(i+"日是星期天");
            break;
            case 1:System.out.println(i+"日是星期1");
                break;
            case 2:System.out.println(i+"日是星期2");
                break;
            case 3:System.out.println(i+"日是星期3");
                break;
            case 4:System.out.println(i+"日是星期4");
                break;
            case 5:System.out.println(i+"日是星期5");
                break;
            case 6:System.out.println(i+"日是星期6");
                break;

        }

        /*  double v = Math.random() * 100;
        int v1 = (int)(Math.random() * 100);
        System.out.println(v);
        System.out.println(v1);


      float f = 9.0f;
        int q=5;
        int i = --q;
        System.out.println(f++*i);
          final int TIME   = 10;
        int j=20;
        j=i+j;
        System.out.println(j);

       WebDriver driver = new FirefoxDriver();

        File file = new File("D:\\BaiduNetdiskDownload\\firebug.xpi");
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.addExtension(file);

        firefoxProfile.setPreference("extensions.firebug.currentVersion","2.0.19");

        ProfilesIni profilesIni = new ProfilesIni();
        FirefoxProfile profile=profilesIni.getProfile("default");
        WebDriver driver = new FirefoxDriver(profile);
        driver.get("file:///C:/Users/123/Desktop/demo.html");

*/
    }
}
