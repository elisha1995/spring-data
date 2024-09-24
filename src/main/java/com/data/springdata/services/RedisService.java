package com.data.springdata.services;

import com.data.springdata.model.RedisEmployee;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RedisService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // Create
    public void createEmployee(RedisEmployee employee) {
        redisTemplate.opsForHash().put("redisEmployees", employee.getId(), employee);
    }

    // Read
    public RedisEmployee getEmployee(String id) {
        Object obj = redisTemplate.opsForHash().get("redisEmployees", id);
        return (obj instanceof RedisEmployee) ? (RedisEmployee) obj : null;
    }

    public List<RedisEmployee> getAllEmployees() {
        List<Object> objects = redisTemplate.opsForHash().values("redisEmployees");
        List<RedisEmployee> employees = new ArrayList<>();
        for (Object obj : objects) {
            if (obj instanceof RedisEmployee) {
                employees.add((RedisEmployee) obj);
            }
        }
        return employees;
    }

    // Update
    public void updateEmployee(String id, RedisEmployee employee) {
        redisTemplate.opsForHash().put("redisEmployees", id, employee);
    }

    // Delete
    public void deleteEmployee(String id) {
        redisTemplate.opsForHash().delete("redisEmployees", id);
    }

    public void setSimpleKeyValue(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public String getSimpleKeyValue(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }

    public void setHashKeyValue(String key, Map<String, Object> map) {
        redisTemplate.opsForHash().putAll(key, map);
    }

    public Object getHashValue(String key, String hashKey) {
        return redisTemplate.opsForHash().get(key, hashKey);
    }

    public void addToList(String key, String value) {
        redisTemplate.opsForList().rightPush(key, value);
    }

    public List<Object> getList(String key) {
        return redisTemplate.opsForList().range(key, 0, -1);
    }
}
