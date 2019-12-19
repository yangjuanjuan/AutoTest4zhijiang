package com.yjj.tng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupMethod {
    @Test(groups = "server")
    public void test1(){
        System.out.println("this is group of server 111");
    }
    @Test(groups = "server")
    public void test0(){
        System.out.println("this is group of server 000");
    }
    @Test(groups = "client",enabled = false)
    public void test2(){
        System.out.println("this is group of server 222");
    }
    @Test(groups = "client",enabled = false)
    public void test3(){
        System.out.println("this is group of server 333");
    }
    @BeforeGroups("server")
     public void beforeGroup(){
         System.out.println(" before Server group");
     }
     @AfterGroups("client")
    public void afterGroup(){
        System.out.println(" after client group");
    }





}
