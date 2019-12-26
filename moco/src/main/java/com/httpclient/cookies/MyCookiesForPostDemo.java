package com.httpclient.cookies;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPostDemo {
    private ResourceBundle bundle;
    private String host;
    private CookieStore store;

    @BeforeTest
    public void getHost(){
        bundle = ResourceBundle.getBundle("httpclient", Locale.CHINA);
        host=bundle.getString("test.host");
    }

    @Test
    public void getCookies(){
        String path = this.bundle.getString("get.cookies.path");
        String uri = this.host+path;
        HttpGet get = new HttpGet(uri);
        CloseableHttpClient closeableHttpClient= HttpClients.createDefault();
        HttpClientContext context = HttpClientContext.create();

        try {
            closeableHttpClient.execute(get,context);
            this.store = context.getCookieStore();
            this.store.getCookies().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                closeableHttpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    @Test(dependsOnMethods = {"getCookies"})
    public void testPostWithCookies(){
        String path = this.bundle.getString("post.cookies.path");
        String uri = this.host+path;
        HttpPost post = new HttpPost(uri);
//        设置请求头信息
        post.addHeader("Content-Type", "application/json");

//        设置请求参数
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","cookie");
        jsonObject.put("age","18");
        try {
            post.setEntity(new StringEntity(jsonObject.toJSONString()));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        CloseableHttpClient psClient =HttpClients.createDefault();
        HttpClientContext context = HttpClientContext.create();
        context.setCookieStore(this.store);
        try {
            CloseableHttpResponse response= psClient.execute(post,context);
            if(response.getStatusLine().getStatusCode()==200){
                String result = EntityUtils.toString(response.getEntity());
                System.out.println("response: "+result);
                JSONObject obj = JSONObject.parseObject(result);
               String expString="Welcome cookie,Ha ha ha ";
                Assert.assertEquals(obj.getString("message"),expString);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                psClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
