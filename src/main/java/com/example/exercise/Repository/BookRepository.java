package com.example.exercise.Repository;

import com.example.exercise.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    Book findBookById(Integer id);
    List<Book> findBookByCategory(String category);
    @Query("select a from Book a where  a.number_of_Pages >?1")
    List<Book> wherebookhasmorethan50(Integer number_of_Pages);

    List<Book> findBookByAuthor(String author);
    Book findBookByTitle(String title);

}
