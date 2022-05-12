package com.springboottutorials.springboottutorials.dao;

import com.springboottutorials.springboottutorials.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>
{
    Book findById(int id);
    void deleteBookById(int id);
    boolean existsBookById(int id);
}
