package com.atguigu.cloud;

import java.time.ZonedDateTime;

/**
 * @create 2019-12-02 17:37
 */
public class ZonedDateTimeDemo
{
    public static void main(String[] args)
    {
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        System.out.println(zbj);
    }
}