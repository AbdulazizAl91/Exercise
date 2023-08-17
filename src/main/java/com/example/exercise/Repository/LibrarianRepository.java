package com.example.exercise.Repository;

import com.example.exercise.Model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian,Integer> {

    Librarian findLibrarianById(Integer id);
    List<Librarian> findLibrariansBy(Integer id);

    Librarian findLibrarianByUsername(String email);

    @Query("select a from Librarian a where a.username=?1 and a.password=?2")
    Librarian checkuser(String username,String password);
}
