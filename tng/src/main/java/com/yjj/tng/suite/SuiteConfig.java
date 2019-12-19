package com.yjj.tng.suite;

import org.testng.annotations.*;

public class SuiteConfig {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before suite running");

    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("after suite running");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("before test");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("after test");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("before method");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("after method");
    }
}
