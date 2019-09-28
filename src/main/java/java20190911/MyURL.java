package java20190911;

import com.sun.security.ntlm.Client;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyURL {
    private String url;
    private ResourceBundle bundle;
    private CookieStore store;
    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }
    @Test
    public void testGet() throws IOException {
        String result;
        HttpGet get = new HttpGet(url);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

        //ªÒ»°cookie÷µ°£
        this.store = client.getCookieStore();
        List<Cookie> cookies = store.getCookies();
        for (Cookie cookie :cookies             ) {
            String name =cookie.getName();
            String value = cookie.getValue();
            System.out.println(name+value);
        }
    }

    @Test(dependsOnMethods = {"testGet"})
    public void testetWithCookies(){

    }


}
