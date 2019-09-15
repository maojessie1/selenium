package java20190911;

public class Config {
    public static int waitTime;
    public static String Browser;
    static {
        ParseXml ps = new ParseXml("src\\main\\resources\\config.xml");
        waitTime = Integer.valueOf(ps.getElementText("/*/waitTime"));
        Browser = ps.getElementText("/*/browser");
    }

}
