package com.zlk.common.util.distributeutil;

import com.zlk.common.util.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

@Component
public class Mylock implements Lock {

    private static final String key = "lock";
    private static final String ok = "OK";

    ThreadLocal<String> local = new ThreadLocal<>();

    @Autowired
    JedisConnectionFactory jedisConnectionFactory;
    @Autowired
    JedisPool jedisPool;

    @Override
    public void lock() {
        if (tryLock()){
            return;
        } else{
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lock();
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        String uuid = UUID.randomUUID().toString();
//        Jedis jedis = (Jedis) jedisConnectionFactory.getConnection().getNativeConnection();
        Jedis jedis =  jedisPool.getResource();
        String a = jedis.set(key,uuid,"NX","PX",10000);
//        System.out.println(Thread.currentThread().getName()+a);
        if (ok.equals(a)){
            local.set(uuid);
            return true;
        }
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        Jedis jedis =  jedisPool.getResource();
//        Jedis jedis = (Jedis) jedisConnectionFactory.getConnection().getNativeConnection();
        String script = FileUtils.getScript("lua/unlock.lua");
        jedis.eval(script, Arrays.asList(key),Arrays.asList(local.get()));
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
