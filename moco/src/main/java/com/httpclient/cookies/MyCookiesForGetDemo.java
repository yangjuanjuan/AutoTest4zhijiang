package com.httpclient.cookies;

import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGetDemo {
    private String url;
    private ResourceBundle bundle;
    private CookieStore store;

    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("httpclient", Locale.CHINA);
        url=bundle.getString("test.host");
    }
    @Test
    public void testGetCookies()  {
       String path=bundle.getString("get.cookies.path") ;
       String uri=this.url+path;

        HttpGet httpGet = new HttpGet(uri);

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpClientContext context = HttpClientContext.create();

        try{
            CloseableHttpResponse response =httpClient.execute(httpGet,context);
            try {
                String result = EntityUtils.toString(response.getEntity());
                System.out.println(">>>>>>响应结果>>>>>>");
                System.out.println(result);

                System.out.println(">>>>>>>cookies>>>>>>>>");
                this.store=context.getCookieStore();

                this.store.getCookies().forEach(System.out::println);
            }finally {
                response.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    /**
     * 测试携带cookies访问请求,依赖上面获取cookies
     */
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testWithCookies(){
        String path = this.bundle.getString("with.cookies.path");
        String uri = this.url+path;
        HttpGet get = new HttpGet(uri);
        CloseableHttpClient client = HttpClients.createDefault();
        HttpClientContext context = HttpClientContext.create();
        context.setCookieStore(this.store);
        try {
            CloseableHttpResponse response =client.execute(get,context);


            int code =response.getStatusLine().getStatusCode();
            if(200==code){
                String result = EntityUtils.toString(response.getEntity());
                System.out.println(">>>>>>响应结果>>>>>>");
                System.out.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
