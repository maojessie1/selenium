package java20190908001;

public class Config {
    public static String Browser;
    public static int waitTime;

    static {
        ParseXml px = new ParseXml("src\\main\\resources\\config.xml");
        Browser = px.getElementText("/config/browser");
        waitTime = Integer.valueOf(px.getElementText("/config/waitTime"));
    }


}
