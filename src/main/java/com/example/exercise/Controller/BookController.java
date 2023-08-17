package com.example.exercise.Controller;

import com.example.exercise.Api.ApiResponse;
import com.example.exercise.Model.Book;
import com.example.exercise.Service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Library/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(bookService.getAllBooks());
    }
    @PostMapping("/add")
    public ResponseEntity addBook(@RequestBody @Valid Book book){
        bookService.addBook(book);
        return ResponseEntity.status(200).body(new ApiResponse("book added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateCoffee(@PathVariable Integer id,@RequestBody @Valid Book book){
        bookService.UpdateBook(id,book);
        return ResponseEntity.status(200).body(new ApiResponse("book updated"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteCoffee(@PathVariable Integer id){
        bookService.deleteBook(id);
        return ResponseEntity.status(200).body(new ApiResponse("book deleted"));
    }
    @GetMapping("/find-By-Category/{category}")
    public ResponseEntity findByCategory(@PathVariable String category){

        return ResponseEntity.status(200).body( bookService.findByCategory(category));
    }
    @GetMapping("/pages/{number_of_page}")
    public ResponseEntity pagesMoreThan300(@PathVariable Integer number_of_page){
        return ResponseEntity.status(200).body(bookService.pagesMoreThan300(number_of_page));
    }
    @GetMapping("/find-BookBy-Author/{author}")
    public ResponseEntity findBookByAuthor(@PathVariable String author){
        return ResponseEntity.status(200).body(bookService.findBookByAuthor(author));
    }
    @GetMapping("/get-book/{title}")
    private ResponseEntity getBookBytitle(@PathVariable String title){
        return ResponseEntity.status(200).body(bookService.getBookBytitle(title));
    }










}
