package com.kuaiyukuaikuai.demo1junit;

import org.junit.Assert;
import org.junit.Test;

//测试类:junit单元测试框架,对业务类中的方法进行测试
public class StringUtilTest {
    //测试方法:测试方法必须使用@Test注解进行修饰，无参,无返回值,必须公开
    @Test
    public void testPrinNumber() {
        StringUtil.printNumber("张三abc");
        StringUtil.printNumber("张三123");
        StringUtil.printNumber("");
        StringUtil.printNumber(null);
    }

    @Test
    public void testGetMaxIndex() {
        int index = StringUtil.getMaxIndex("abcdefg");
        int index2 = StringUtil.getMaxIndex("abc123");
        int index3 = StringUtil.getMaxIndex("");
        int index4 = StringUtil.getMaxIndex(null);
        Assert.assertEquals("测试失败",6, index);
        Assert.assertEquals(5, index2);
        Assert.assertEquals(-1, index3);
        Assert.assertEquals(-1, index4);
    }
}
