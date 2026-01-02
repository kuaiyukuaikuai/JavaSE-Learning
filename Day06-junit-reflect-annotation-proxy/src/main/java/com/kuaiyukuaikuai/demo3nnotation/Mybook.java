package com.kuaiyukuaikuai.demo3nnotation;

public @interface Mybook {
    String value();
    int age() default 18;//default默认值
    String[] address();
}
