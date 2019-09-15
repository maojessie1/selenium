package java20190908001;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeString {
    private String valueOfString(String str,int len){
        String string = "";
        for (int i = 0; i < len-str.length() ; i++) {
            string=string+"0";
        }

        return (str.length()==len)?(str):(string+str);
    }

    public static String getSimpleDteFormat(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-SSS");
        return df.format(new Date());
    }
}
