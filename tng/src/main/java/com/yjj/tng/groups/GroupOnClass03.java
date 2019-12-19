package com.yjj.tng.groups;

import org.testng.annotations.Test;

@Test(groups = "g2")
public class GroupOnClass03 {
    public void test01(){
        System.out.println("test01 of group2");
    }
    public void test02(){
        System.out.println("test02 of group2");
    }
}
