package com.yjj.tng;

import org.testng.annotations.Test;

import java.util.concurrent.TimeoutException;

public class TimeOutTest {
    @Test(timeOut = 300)
    public void testSuccess() throws  InterruptedException {
        Thread.sleep(200);
    }
    @Test(timeOut = 300)
    public void testFail() throws  InterruptedException {
        Thread.sleep(400);
    }

}
