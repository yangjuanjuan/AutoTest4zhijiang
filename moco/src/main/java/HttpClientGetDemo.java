import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HttpClientGetDemo {
    @Test
    public void testGetBD() throws URISyntaxException, IOException{
        String result;
//        HttpGet get = new HttpGet("http://www.baidu.com");
        URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("www.baidu.com")
                .build();
        HttpGet get = new HttpGet(uri);
        System.out.println(get.getURI());
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse= httpclient.execute(get);
            HttpEntity entity = httpResponse.getEntity();
            result=EntityUtils.toString(entity,"utf-8");
            System.out.println(result);
        }finally {

            httpResponse.close();
        }
    }
}
