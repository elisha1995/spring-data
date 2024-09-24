package com.data.springdata.controller;

import com.data.springdata.model.Employee;
import com.data.springdata.model.RedisEmployee;
import com.data.springdata.services.MongoService;
import com.data.springdata.services.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HospitalController {

    @Autowired
    private MongoService mongoService;

    @Autowired
    private RedisService redisService;

    // MongoDB CRUD operations
    @PostMapping("/createEmployee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return mongoService.createEmployee(employee);
    }

    @GetMapping("/getEmployeeById/{id}")
    public Employee getEmployee(@PathVariable String id) {
        return mongoService.getEmployee(id);
    }

    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees() {
        return mongoService.getAllEmployees();
    }

    @PutMapping("/updateEmployee/{id}")
    public Employee updateEmployee(@PathVariable String id, @RequestBody Employee employee) {
        employee.setId(id);
        return mongoService.updateEmployee(employee);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public void deleteEmployee(@PathVariable String id) {
        mongoService.deleteEmployee(id);
    }

    // Redis CRUD operations
    @PostMapping("/redis/createEmployee")
    public void createRedisEmployee(@RequestBody RedisEmployee employee) {
        redisService.createEmployee(employee);
    }

    @GetMapping("/redis/getEmployee/{id}")
    public RedisEmployee getRedisEmployee(@PathVariable String id) {
        return redisService.getEmployee(id);
    }

    @GetMapping("/redis/getAllEmployees")
    public List<RedisEmployee> getAllRedisEmployees() {
        return redisService.getAllEmployees();
    }

    @PutMapping("/redis/updateEmployee/{id}")
    public void updateRedisEmployee(@PathVariable String id, @RequestBody RedisEmployee employee) {
        redisService.updateEmployee(id, employee);
    }

    @DeleteMapping("/redis/deleteEmployee/{id}")
    public void deleteRedisEmployee(@PathVariable String id) {
        redisService.deleteEmployee(id);
    }

    // Redis operations
    @PostMapping("/cache/set")
    public void setCache(@RequestParam String key, @RequestParam String value) {
        redisService.setSimpleKeyValue(key, value);
    }

    @GetMapping("/cache/get")
    public String getCache(@RequestParam String key) {
        return redisService.getSimpleKeyValue(key);
    }

    @PostMapping("/cache/hash")
    public void setHashCache(@RequestParam String key, @RequestBody Map<String, Object> map) {
        redisService.setHashKeyValue(key, map);
    }

    @GetMapping("/cache/hash")
    public Object getHashCache(@RequestParam String key, @RequestParam String hashKey) {
        return redisService.getHashValue(key, hashKey);
    }

    @PostMapping("/cache/list")
    public void addToList(@RequestParam String key, @RequestParam String value) {
        redisService.addToList(key, value);
    }

    @GetMapping("/cache/list")
    public List<Object> getList(@RequestParam String key) {
        return redisService.getList(key);
    }
}
