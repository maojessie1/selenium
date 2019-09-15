package java20190908002;

import java.util.Random;

public class RandomUtil {
    public int getRandom(int count){
        return (int)Math.round(Math.random()*count);
    }

    private String string = "fdsakjf;ajdfoi2uoruwoerjalkflksaf";

    public String getRandomString(int length){
        StringBuffer sb = new StringBuffer();
        int len = string.length();

        for (int i = 0; i < length ; i++) {
            sb.append(string.charAt(this.getRandom(len -1)));
        }
        return sb.toString();
    }


}
