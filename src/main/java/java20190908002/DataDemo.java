package java20190908002;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataDemo {
    public String getSimpleDateFormat(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        return df.format(new Date());
    }
}
