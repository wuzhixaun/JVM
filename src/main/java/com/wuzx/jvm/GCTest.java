package com.wuzx.jvm;


/**
 * -XX:+PrintGCDetails    打印GC相信信息
 */
public class GCTest {
    public static void main(String[] args) throws InterruptedException { 
        byte[] allocation1, allocation2;
        allocation1 = new byte[60000*1024];
    } 
}