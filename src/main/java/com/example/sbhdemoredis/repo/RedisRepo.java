package com.example.sbhdemoredis.repo;

import com.example.sbhdemoredis.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisRepo extends JpaRepository<Book, Integer> {
}
