package com.yjj.tng.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * 通过xml的形式传参
 */
public class ParameterTest {
    @Test
    @Parameters({"name","age"})
    public void paramter01(String name,int age){
        System.out.println("name:"+name+"; age:"+age);
    }
}
