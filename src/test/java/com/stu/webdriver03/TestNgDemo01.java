package com.stu.webdriver03;

import org.testng.annotations.*;

public class TestNgDemo01 {

    @BeforeTest
    public void beforeTest(){
        System.out.println("这是BeforeTest注解");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("这是BeforeMethod注解");
    }

    @Test
    public void testCase1() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("这是@Test注解,case1");
    }
    @Test
    public void testCase2() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("这是@Test注解,case2");
    }
    @AfterTest
    public void afterTest() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("这是@AfterTest注解");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("这是@AfterMethod注解");
    }
}
