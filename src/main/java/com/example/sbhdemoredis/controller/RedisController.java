package com.example.sbhdemoredis.controller;

import com.example.sbhdemoredis.model.Book;
import com.example.sbhdemoredis.service.RedisService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/redis")
public class RedisController {
    private final RedisService redisService;

    public RedisController(RedisService redisService) {
        this.redisService = redisService;
    }

    @GetMapping("/{id}")
    public Book getOne(@PathVariable Integer id) {
        return redisService.getOne(id);
    }

    @GetMapping
    public List<Book> findAll() {
        return redisService.findAll();
    }

    @PostMapping
    public Book create(@RequestBody Book book){
        return redisService.create(book);
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable Integer id, @RequestBody Book book) {
        return redisService.update(id, book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        redisService.delete(id);
    }
}
