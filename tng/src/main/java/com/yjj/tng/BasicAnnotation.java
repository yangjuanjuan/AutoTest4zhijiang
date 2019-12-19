package com.yjj.tng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicAnnotation {
    @Test
    public void testCase1() {
        System.out.println("This is one test");
    }
    @Test
    public void testCase2(){
        System.out.println("this is second test");
    }

}
