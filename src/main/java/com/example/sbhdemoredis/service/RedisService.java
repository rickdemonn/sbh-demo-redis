package com.example.sbhdemoredis.service;

import com.example.sbhdemoredis.exception.BookNotFoundException;
import com.example.sbhdemoredis.model.Book;
import com.example.sbhdemoredis.repo.RedisRepo;
import lombok.SneakyThrows;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisService {

    private final RedisRepo redisRepo;

    public RedisService(RedisRepo redisRepo) {
        this.redisRepo = redisRepo;
    }

    @SneakyThrows
    @Cacheable(value = "books", key = "#id")
    public Book getOne(Integer id) {
        Thread.sleep(3000);
        return redisRepo.findById(id).orElseThrow(BookNotFoundException::new);
    }

    @SneakyThrows
    @Cacheable("books")
    public List<Book> findAll() {
        Thread.sleep(3000);
        return redisRepo.findAll();
    }

    @CachePut(value = "books", key = "#book.id")
    public Book create(Book book) {
        return redisRepo.save(book);
    }

    @CachePut(value = "books", key = "#id")
    public Book update(Integer id, Book book) {
        Book bookFromDb = redisRepo.findById(id).orElseThrow(BookNotFoundException::new);
        bookFromDb.setTitle(book.getTitle());
        bookFromDb.setAuthor(book.getAuthor());
        return redisRepo.save(bookFromDb);
    }

    @CacheEvict(value = "books", allEntries=true)
    public void delete(Integer id) {
        redisRepo.deleteById(id);
    }
}
