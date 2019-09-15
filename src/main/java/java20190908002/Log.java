package java20190908002;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Log {
    private static Logger logger;
    private static String filePath = "src\\main\\resources\\log4j.properties";
    private static boolean flag =false;

    private static synchronized void getPropertyFile(){
        logger = Logger.getLogger("abc");
        PropertyConfigurator.configure(new File(filePath).getAbsolutePath());
        flag = true;
    }

    public static void logInfo(String message){
        logger.info("message");
    }
    public static void logWarn(String message){
        logger.warn("message");
    }
    public static void logerror(String message){
        logger.error("message");
    }

    public static void main(String[] args) {
        Log.logInfo("d");
    }
}
