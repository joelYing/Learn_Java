package com.jdk;

import java.util.UUID;

/**
 * @PackageName jdk
 * @Author joel
 * @Date 2018/12/25 15:39
 **/
public class UuidExample {
    public static void main(String[] args) {
        // UUID 是通用唯一识别码 目前应用最广泛的 UUID 是微软的 GUID
        String uuid = UUID.randomUUID().toString();
        // 生成 32 位的 UUID
        System.out.println(uuid);
        System.out.println(uuid.replace("-", "").toLowerCase());
    }
}
