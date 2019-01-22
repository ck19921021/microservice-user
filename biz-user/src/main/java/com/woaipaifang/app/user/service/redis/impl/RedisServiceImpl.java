/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.woaipaifang.app.user.service.redis.impl;

import com.woaipaifang.app.user.service.redis.IRedisService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public abstract class RedisServiceImpl<T> implements IRedisService<T> {

    private final String LOCKVALUE = "lockvalue";
    @Autowired
    protected RedisTemplate<String, Object> redisTemplate;
    @Resource
    protected HashOperations<String, String, T> hashOperations;
    @Value("${spring.redis.database.name}")
    private String redisDatabase;
    @Autowired
    private StringRedisTemplate redisTemplate1;
    private boolean locked = false;

    public String getRedisDatabase() {
        return this.redisDatabase;
    }

    public synchronized boolean lock(String lockKey) {
        /*该方法会在没有key时，设置key;存在key时返回false；因此可以通过该方法及设置key的有效期，判断是否有其它线程持有锁*/
        Boolean success = redisTemplate1.opsForValue().setIfAbsent(lockKey, LOCKVALUE);
        if (success != null && success) {
            redisTemplate1.expire(lockKey, 3, TimeUnit.SECONDS);
            locked = true;
        } else {
            locked = false;
        }
        return locked;
    }


    /**
     * 加锁
     *
     * @param key   商品id
     * @param value 当前时间+超时时间
     * @return
     */
    public boolean lock1(String key, String value) {
        if (redisTemplate1.opsForValue().setIfAbsent(key, value)) {     //这个其实就是setnx命令，只不过在java这边稍有变化，返回的是boolea
            return true;
        }

        //避免死锁，且只让一个线程拿到锁
        String currentValue = redisTemplate1.opsForValue().get(key);
        //如果锁过期了
        if (!StringUtils.isEmpty(currentValue) && Long.parseLong(currentValue) < System.currentTimeMillis()) {
            //获取上一个锁的时间
            String oldValues = redisTemplate1.opsForValue().getAndSet(key, value);

            /*
               只会让一个线程拿到锁
               如果旧的value和currentValue相等，只会有一个线程达成条件，因为第二个线程拿到的oldValue已经和currentValue不一样了
             */
            if (!StringUtils.isEmpty(oldValues) && oldValues.equals(currentValue)) {
                return true;
            }
        }
        return false;
    }


    /**
     * 解锁
     *
     * @param key
     * @param value
     */
    public void unlock(String key, String value) {
        try {
            String currentValue = redisTemplate1.opsForValue().get(key);
            if (!StringUtils.isEmpty(currentValue) && currentValue.equals(value)) {
                redisTemplate.opsForValue().getOperations().delete(key);
            }
        } catch (Exception e) {
//			log.error("『redis分布式锁』解锁异常，{}", e);
        }
    }

    /**
     * 添加
     *
     * @param key    key
     * @param doamin 对象
     * @param expire 过期时间(单位:秒),传入 -1 时表示不设置过期时间
     */
    public void put(String key, T doamin, long expire) {
        hashOperations.put(getRedisDatabase(), key, doamin);
        if (expire != -1) {
            redisTemplate.expire(getRedisDatabase(), expire, TimeUnit.SECONDS);
        }
    }

    /**
     * 删除
     *
     * @param key 传入key的名称
     */
    public void remove(String key) {
        hashOperations.delete(getRedisDatabase(), key);
    }

    /**
     * 查询
     *
     * @param key 查询的key
     * @return
     */
    public T get(String key) {
        return hashOperations.get(getRedisDatabase(), key);
    }

    /**
     * 获取当前redis库下所有对象
     *
     * @return
     */
    public List<T> getAll() {
        return hashOperations.values(getRedisDatabase());
    }

    /**
     * 查询查询当前redis库下所有key
     *
     * @return
     */
    public Set<String> getKeys() {
        return hashOperations.keys(getRedisDatabase());
    }

    /**
     * 判断key是否存在redis中
     *
     * @param key 传入key的名称
     * @return
     */
    public boolean isKeyExists(String key) {
        return hashOperations.hasKey(getRedisDatabase(), key);
    }

    /**
     * 查询当前key下缓存数量
     *
     * @return
     */
    public long count() {
        return hashOperations.size(getRedisDatabase());
    }

    public <T> void setMap(String key, Map<String, T> map, long expirationtime) throws Exception {
        redisTemplate.opsForHash().putAll(key, map);
//        redisTemplate.expire(key, expirationtime, TimeUnit.SECONDS);
    }

    public <T> Map<String, T> mget(String key, Class<T> clazz)throws Exception {
        BoundHashOperations boundHashOperations = redisTemplate.boundHashOps(key);
        return boundHashOperations.entries();
    }


}
