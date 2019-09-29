package HttpClient;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {

    private String url;
    private ResourceBundle bundle;

    //?????洢cookies????????

    private CookieStore store;

    @BeforeTest
    public void beforeTest() {
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test1.url");
    }

    @Test
    public void testGetCookies() throws IOException {
        String result;
        String uri = bundle.getString("getCookies.uri");
        String testUrl = this.url + uri;
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(), "UTF-8");
        System.out.println(result);

        //???cookies???
        this.store = client.getCookieStore();
        List<Cookie> cookies = store.getCookies();
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("name = " + name + ";  value = " + value);
        }
    }

    @Test(dependsOnMethods = {"testGetCookies"})
    public void testPostMethod() throws IOException {
        String uri = bundle.getString("test.post.with.cookies");
        String testUrl = this.url +uri;

        //???????client???????????з???????С?
        DefaultHttpClient client = new DefaultHttpClient();
        //????????????????????????post????
        HttpPost post = new HttpPost(testUrl);
        //??????
        JSONObject param = new JSONObject();
        param.put("name","huhansan");
        param.put("age","18");
        //???????????? ????header
        post.setHeader("content-type","application/json");
        //???????????????????
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        //?????????????????????????洢
        String result;
        //????cookies???
        client.setCookieStore(this.store);
        //???post????
        HttpResponse response = client.execute(post);
        //?????????
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        //?????????ж???????????????
        //?????????????????????????json????
        JSONObject resultJson = new JSONObject(result);

        //?????????
        String sucess = (String) resultJson.get("huhansan");
        String status = (String)resultJson.get("status");
        //??????ж?????????
        Assert.assertEquals("1",status);
        Assert.assertEquals("sucess",sucess);

    }
}
