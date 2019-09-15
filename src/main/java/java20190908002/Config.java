package java20190908002;

public class Config {
    public static String Browser;
    public static int waitTime;

    static {
        ParseXml px = new ParseXml("E:\\ideaworkspaces\\javastudy\\src\\main\\resources\\config.xml");
        Browser = px.getElementText("/*/browser");
        waitTime = Integer.valueOf(px.getElementText("/*/waitTime"));

    }
}
