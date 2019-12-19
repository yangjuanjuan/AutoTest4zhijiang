package com.yjj.tng.groups;

import org.testng.annotations.Test;

@Test(groups = "g1")
public class GroupOnClass02 {
    public void test03(){
        System.out.println("test03 of group1");
    }
    public void test04(){
        System.out.println("test04 of group1");
    }
}
