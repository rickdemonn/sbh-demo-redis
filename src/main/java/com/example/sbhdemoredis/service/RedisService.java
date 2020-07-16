package com.example.sbhdemoredis.service;

import com.example.sbhdemoredis.exception.BookNotFoundException;
import com.example.sbhdemoredis.model.Book;
import com.example.sbhdemoredis.repo.RedisRepo;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisService {

    private final RedisRepo redisRepo;

    public RedisService(RedisRepo redisRepo) {
        this.redisRepo = redisRepo;
    }

    @SneakyThrows
    public Book getOne(Integer id) {
        Thread.sleep(3000);
        return redisRepo.findById(id).orElseThrow(BookNotFoundException::new);
    }

    @SneakyThrows
    public List<Book> findAll() {
        Thread.sleep(3000);
        return redisRepo.findAll();
    }

    public Book create(Book book) {
        return redisRepo.save(book);
    }

    public Book update(Integer id, Book book) {
        Book bookFromDb = redisRepo.findById(id).orElseThrow(BookNotFoundException::new);
        bookFromDb.setTitle(book.getTitle());
        bookFromDb.setAuthor(book.getAuthor());
        return redisRepo.save(bookFromDb);
    }

    public void delete(Integer id) {
        redisRepo.deleteById(id);
    }
}
