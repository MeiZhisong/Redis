package com.mzs.redis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class RedisHashUtil {

    @Autowired
    private static RedisTemplate<String, Object> redisTemplate;

    public static void set(String key, Object field, Object value) {
        redisTemplate.opsForHash().put(key, field, value);
    }

    public static void multiSet(String key, Map<Object, Object> fieldMap) {
        redisTemplate.opsForHash().putAll(key, fieldMap);
    }

    public static Boolean setIfAbsent(String key, Object field, Object value) {
        return redisTemplate.opsForHash().putIfAbsent(key, field, value);
    }

    public static Long delete(String key, Object... field) {
        return redisTemplate.opsForHash().delete(key, field);
    }

    public static Map<Object, Object> getAll(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    public static Object get(String key, Object field) {
        return redisTemplate.opsForHash().get(key, field);
    }

    public static Boolean exists(String key, Object field) {
        return redisTemplate.opsForHash().hasKey(key, field);
    }

    public static List<Object> values(String key) {
        return redisTemplate.opsForHash().values(key);
    }

    public static Long len(String key) {
        return redisTemplate.opsForHash().size(key);
    }

    public static List<Object> multiGet(String key, Set<Object> fields) {
        return redisTemplate.opsForHash().multiGet(key, fields);
    }

    public static Long strLen(String key, Object field) {
        return redisTemplate.opsForHash().lengthOfValue(key, field);
    }

    public static Set<Object> set(String key) {
        return redisTemplate.opsForHash().keys(key);
    }

    public static Long incrBy(String key, Object field, long delta) {
        return redisTemplate.opsForHash().increment(key, field, delta);
    }

    public static Double incrBy(String key, Object field, double delta) {
        return redisTemplate.opsForHash().increment(key, field, delta);
    }
}
