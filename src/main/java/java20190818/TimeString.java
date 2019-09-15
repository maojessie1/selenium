package java20190818;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeString {
    private String ValueOfString(String str,int len){
        String string="";
        for (int i = 0; i < len- str.length() ; i++) {
            string = string +"0";
        }
        return (str.length()==len)?(str):(string+str);
    }

    public String getSimpleDateFormat(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }

    public String getTime(){
        return String.valueOf(new Date().getTime());
    }

    public String getTimeString(){
        Calendar calendar = new GregorianCalendar();
        String year = String.valueOf(calendar.get(Calendar.YEAR));
        return year;
    }

    public static void main(String[] args) {
        TimeString ts = new TimeString();
        System.out.println(ts.getTimeString());
        System.out.println(ts.getTime());
        System.out.println(ts.getSimpleDateFormat());



    }

}
