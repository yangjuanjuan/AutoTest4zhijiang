package com.yjj.tng;

import org.testng.annotations.Test;

public class ExceptionTest {
//    @Test
//    public void runTimeExceptionFail(){
//        System.out.println("这是一个失败的异常测试");
//    }
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeException(){
        System.out.println("这是一个成功的异常测试");
        throw new RuntimeException();
    }

}
