package com.example.exercise.Service;

import com.example.exercise.Api.ApiException;
import com.example.exercise.Model.Book;
import com.example.exercise.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.boot.model.internal.ListBinder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    public void addBook(Book book){
    bookRepository.save(book);
    }
    public void UpdateBook(Integer id,Book book){
        Book books =bookRepository.findBookById(id);
        if(books==null){
            throw new ApiException("id not founded");
        }
    }
    public void deleteBook(Integer id){
        Book book=bookRepository.findBookById(id);
        if(book==null){
            throw new ApiException("id not founded");
        }
        bookRepository.delete(book);

    }
    public List<Book> findByCategory(String category){
        List<Book> books = bookRepository.findBookByCategory(category);
        if(category.isEmpty()){
            throw new ApiException("there is no books");

        }
        return books;
    }
    public List<Book> pagesMoreThan300(Integer number_of_Pages){
        List<Book> books = bookRepository.wherebookhasmorethan50(number_of_Pages);
        if(number_of_Pages<300){
            throw new ApiException("there is no books have more than 300");

        }
        return books;
    }
    public List<Book>findBookByAuthor(String author){
        List<Book>books = bookRepository.findBookByAuthor( author);
            if (author.isEmpty()){
                throw new ApiException("there is no books");
            }


        return books;
    }
    public Book getBookBytitle(String title){
        Book book = bookRepository.findBookByTitle(title);
        if (book==null){
            throw new ApiException("id not found");
        }
        return book;
    }



}
