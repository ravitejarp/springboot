package com.ravi.spring.springboot.dao.repository;

import com.ravi.spring.springboot.dao.entities.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader,String> {
}
