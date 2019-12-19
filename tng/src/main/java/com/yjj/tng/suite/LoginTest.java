package com.yjj.tng.suite;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    @Test
    public void login(){
        System.out.println("Login success");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("This is before method");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("This is after method");
    }

}
