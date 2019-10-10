package com.ravi.spring.springboot.dao.repository;

import com.ravi.spring.springboot.dao.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findByReader(String reader);


}
