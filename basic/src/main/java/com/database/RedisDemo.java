package com.database;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @PackageName database
 * @Author joel
 * @Date 2018/12/20 12:53
 **/

public class RedisDemo {
    private static Properties properties = new Properties();
    private static String userDir = System.getProperties().getProperty("user.dir");
    private static String DS = File.separator;
    private static String redis_host = null;
    private static int redis_port;
    private static String redis_passwd = null;

    public static void main(String[] args) {
        File input = new File(userDir + DS + "config" + DS + "redis.properties");
        try {
            properties.load(new FileInputStream(input));
            redis_host = properties.getProperty("redis.host");
            redis_port = Integer.parseInt(properties.getProperty("redis.port"));
            redis_passwd = properties.getProperty("redis.password");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


//        single();
        pool();
    }

    public static void single() {
        // 简单的jedis实例不是线程安全的
        Jedis jedis = new Jedis(redis_host, redis_port);
        jedis.auth(redis_passwd);

        jedis.set("foo", "bar");
        jedis.set("hello", "world");
        String value1 = jedis.get("foo");
        String value2 = jedis.get("hello");

        System.out.println(value1);
        System.out.println(value2);
        System.out.println("=====");
    }

    public static void pool() {
        JedisPool pool = new JedisPool(new JedisPoolConfig(), redis_host, redis_port);
        Jedis jedis = null;
        try {
            // 连接池中取得一个Jedis实例
            jedis = pool.getResource();
            jedis.auth(redis_passwd);
            jedis.set("foo1", "bar");
            String foobar = jedis.get("foo1");
            System.out.println(foobar);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        pool.destroy();
    }

}
