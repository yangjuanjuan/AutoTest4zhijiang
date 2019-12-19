package com.yjj.tng.groups;

import org.testng.annotations.Test;

@Test(groups = "g1")
public class GroupOnClass01 {
    public void test01(){
        System.out.println("test01 of group1");
    }
    public void test02(){
        System.out.println("test02 of group1");
    }
}
