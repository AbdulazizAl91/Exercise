package com.example.exercise.Controller;

import com.example.exercise.Api.ApiResponse;
import com.example.exercise.Model.Book;
import com.example.exercise.Model.Librarian;
import com.example.exercise.Service.LibrarianService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Library/librarian")
@RequiredArgsConstructor
public class LibrarianController {
    private final LibrarianService librarianService;
    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(librarianService.getAllLibrarians());
    }
    @PostMapping("/add")
    public ResponseEntity addBook(@RequestBody @Valid Librarian librarian){
        librarianService.addLibrarian(librarian);
        return ResponseEntity.status(200).body(new ApiResponse("librarian added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateBook(@PathVariable Integer id,@RequestBody @Valid Librarian librarian){
        librarianService.UpdateLibrarian(id,librarian);
        return ResponseEntity.status(200).body(new ApiResponse("librarian updated"));


    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable Integer id){
        librarianService.deleteLibrarian(id);
        return ResponseEntity.status(200).body(new ApiResponse("librarian deleted"));
    }
    @GetMapping("/find-by-id/{id}")
    public ResponseEntity findLibrarianById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(librarianService.findLibrarianById(id));
    }
    @GetMapping("check-user/{username}/{password}")
    public ResponseEntity checkuser(@PathVariable String username,@PathVariable String password){
        return ResponseEntity.status(200).body(librarianService.checkuser(username,password));
    }
    @GetMapping("/find-by-email/{email}")
    public ResponseEntity findLibrariansByUsername(@PathVariable String email){
        return ResponseEntity.status(200).body(librarianService.findLibrariansByUsername(email));
    }








}
