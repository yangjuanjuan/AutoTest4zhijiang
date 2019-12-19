package com.yjj.tng.parallel;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParallelTestByXml {
    @BeforeMethod
    public void beforeMethod(){
        long id = Thread.currentThread().getId();
        System.out.println("before Method, threadID="+id);
    }
    @AfterMethod
    public void afterMethod(){
        long id = Thread.currentThread().getId();
        System.out.println("after Method, threadID="+id);
    }
    @Test
    public void test01(){
        long id = Thread.currentThread().getId();
        System.out.println("test01, threadID="+id);
    }
    @Test
    public void test02(){
        long id = Thread.currentThread().getId();
        System.out.println("test02, threadID="+id);
    }
}
