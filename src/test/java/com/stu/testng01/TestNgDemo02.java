package com.stu.testng01;

        import org.testng.Assert;
        import org.testng.annotations.Test;

public class TestNgDemo02 {
    //    校验 a = a
    @Test
    public void assertEqualTest(){
        String a ="abc";
        String b ="cde";
//        if(a.equals(b)){
//            System.out.println("正确");
//        }else{
//            System.out.println("错误");
//        }
//        Assert.assertEquals(a,b,"a不等于b");
//        System.out.println("===============");//执行失败后，后面不执行
        Assert.assertEquals(a,b);

    }
    @Test
    public void assertNotEqualsTest(){
        int a = 1;
        int b = 2;
        Assert.assertNotEquals(a,b);

    }
    @Test
    public void assertNullTest(){
        String a = null;
        Assert.assertNull(a);
    }
    @Test
    public void assertNotNullTest(){
        String a = "a";
        Assert.assertNotNull(a);
    }
    @Test
    public void a(){
        Boolean a = false;
        Assert.assertFalse(a);

    }
}
