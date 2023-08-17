package com.example.exercise.Service;

import com.example.exercise.Api.ApiException;
import com.example.exercise.Model.Book;
import com.example.exercise.Model.Librarian;
import com.example.exercise.Repository.LibrarianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibrarianService {
    private final LibrarianRepository librarianRepository;
    public List<Librarian> getAllLibrarians(){
        return librarianRepository.findAll();
    }
    public void addLibrarian(Librarian librarian){
        librarianRepository.save(librarian);
    }
    public void UpdateLibrarian(Integer id,Librarian librarian){
        Librarian librarian1 =librarianRepository.findLibrarianById(id);
        if(librarian1==null){
            throw new ApiException("id not founded");
        }
        librarian1.setName(librarian.getName());
        librarian1.setUsername(librarian.getUsername());
        librarian1.setPassword(librarian.getPassword());
        librarian1.setEmail(librarian.getEmail());

    }
    public void deleteLibrarian(Integer id){
        Librarian librarian=librarianRepository.findLibrarianById(id);
        if(librarian==null){
            throw new ApiException("id not founded");
        }
        librarianRepository.delete(librarian);

    }
    public Librarian findLibrarianById(Integer id){
        Librarian librarian = librarianRepository.findLibrarianById(id);
        if ( librarian==null){
            throw new ApiException("id not founded");
        }
        return librarian;



    }
    public Librarian checkuser(String username,String password){
        Librarian librarian = librarianRepository.checkuser(username,password);
        if (librarian == null){
            throw new ApiException("check username or password");
        }
        return librarian;
    }
    public Librarian findLibrariansByUsername(String email){
        Librarian librarian= librarianRepository.findLibrarianByUsername(email);
        if (librarian ==null){
            throw new ApiException("no accont");
        }
        return librarian;

    }


}
