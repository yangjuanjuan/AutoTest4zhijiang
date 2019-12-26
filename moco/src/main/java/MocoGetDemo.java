import com.github.dreamhead.moco.HttpServer;
import com.github.dreamhead.moco.Runner;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.github.dreamhead.moco.Moco.httpServer;
import static com.github.dreamhead.moco.Runner.runner;

public class MocoGetDemo {
    private Runner runner;
    private Content content;
    @BeforeMethod
    public void beforeMethod()throws IOException{
        HttpServer server = httpServer(12306);
        server.response("这是一个没有参数的get请求");
        runner=runner(server);
        runner.start();
        content = Request.Get("http://localhost:12306").execute().returnContent();

    }
    @Test
    public void testSuccess()  {
        Assert.assertEquals(content.asString(),"这是一个没有参数的get请求");
    }
    @Test
    public void testFail(){
        Assert.assertEquals(content.asString(),"这是一个没有参数的get请求!");
    }
    @AfterMethod
    public void afterMethod(){
        runner.stop();
    }
}
