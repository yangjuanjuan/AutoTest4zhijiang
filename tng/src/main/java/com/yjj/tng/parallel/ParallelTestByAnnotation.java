package com.yjj.tng.parallel;

import org.testng.annotations.*;

public class ParallelTestByAnnotation {
    @BeforeMethod
    public void beforeClass(){
        Long id = Thread.currentThread().getId();
        System.out.println("beforeClass threadID: "+id);
    }
    @Test(threadPoolSize = 3,invocationCount = 2,timeOut = 1000)
    public void test1(){
        Long id = Thread.currentThread().getId();
        System.out.println("test1 threadID: "+id);
    }
    @Test(threadPoolSize = 2,invocationCount = 2,timeOut = 1000)
    public void test2(){
        Long id = Thread.currentThread().getId();
        System.out.println("test2 threadID: "+id);
    }
    @AfterMethod
    public void afterClass(){
        Long id = Thread.currentThread().getId();
        System.out.println("afterClass threadID: "+id);
    }
}
