package com.yjj.tng.suite;

import org.testng.annotations.Test;

public class IgnoreTest {
    @Test(enabled = false)
    public void ignore1(){
        System.out.println("ignore 01 running");
    }
    @Test(enabled = true)
    public void ignore2(){
        System.out.println("ignore 02 running");
    }
}
