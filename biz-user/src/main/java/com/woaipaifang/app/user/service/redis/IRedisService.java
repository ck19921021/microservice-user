/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.woaipaifang.app.user.service.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IRedisService<T> {

    public String getRedisDatabase();

    /**
     *      * 将map写入缓存
     * <p>
     *      * @param key
     * <p>
     *      * @param map
     * <p>
     *      * @param time 失效时间(秒)
     * <p>
     *     
     */
    public <T> void setMap(String key, Map<String, T> map, long expirationtime) throws Exception;


    public <T> Map<String, T> mget(String key, Class<T> clazz) throws Exception;


    /**
     * 添加
     *
     * @param key    key
     * @param doamin 对象
     * @param expire 过期时间(单位:秒),传入 -1 时表示不设置过期时间
     */
    public void put(String key, T doamin, long expire);

    /**
     * 删除
     *
     * @param key 传入key的名称
     */
    public void remove(String key);

    /**
     * 查询
     *
     * @param key 查询的key
     * @return
     */
    public T get(String key);

    /**
     * 获取当前redis库下所有对象
     *
     * @return
     */
    public List<T> getAll();

    /**
     * 查询查询当前redis库下所有key
     *
     * @return
     */
    public Set<String> getKeys();

    /**
     * 判断key是否存在redis中
     *
     * @param key 传入key的名称
     * @return
     */
    public boolean isKeyExists(String key);

    /**
     * 查询当前key下缓存数量
     *
     * @return
     */
    public long count();

    /**
     * 清空redis
     */
    /*
     * public void empty() { Set<String> set =
     * hashOperations.keys(getRedisKey()); set.stream().forEach(key ->
     * hashOperations.delete(getRedisKey(), key)); }
     */
}