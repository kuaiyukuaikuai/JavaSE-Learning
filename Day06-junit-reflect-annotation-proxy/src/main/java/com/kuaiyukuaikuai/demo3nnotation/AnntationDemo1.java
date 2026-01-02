package com.kuaiyukuaikuai.demo3nnotation;

@Mybook(value = "赵丽颖", age = 18, address = {"北京", "上海"})
@A("哈哈哈")
public class AnntationDemo1 {
    @Mybook(value = "王菲", age = 18, address = {"北京", "香港"})
    public static void main(String[] args) {
        //目标:自定义注解
        @A("lll")
        int a = 10;
    }
}
