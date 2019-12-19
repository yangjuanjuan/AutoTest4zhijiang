package com.yjj.tng.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * 通过dataProvider提供参数
 */
public class DataProviderTest {
    @Test(dataProvider="test1Dp")
    public void test1(String name,int age){
        System.out.println("name:"+name+"; age:"+age);

    }
    @DataProvider(name = "test1Dp")
    public Object[][] providerData(){
        Object[][] o = new Object[][]{
                {"zhang shan",10},
                {"li shi",12},
                {"wang wu",16}
        };
        return o;
    }
    @Test(dataProvider = "dp")
    public void test2(String name,int age){
        System.out.println("name:"+name+"; age:"+age);
    }
    @Test(dataProvider = "dp")
    public void test3(String name,int age){
        System.out.println("name:"+name+"; age:"+age);
    }
    @DataProvider(name = "dp")
    public Object[][] providerData2(Method method){
        Object[][] result=null;
        if(method.getName().equals("test2")){
            result=new Object[][]{
                    {"zhang2 shan",67},
                    {"li shi2",32},
                    {"wang wu2",46}
            };
        }else if(method.getName().equals("test3")){
            result=new Object[][]{
                    {"zhang3 shan",57},
                    {"li shi3",22},
                    {"wang wu3",56}
            };
        }
        return result;
    }
}
