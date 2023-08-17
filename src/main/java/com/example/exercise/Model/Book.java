package com.example.exercise.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Column(columnDefinition = "varchar(25) not null")
    private String  title;
    @NotEmpty
    @Column(columnDefinition = "varchar(25) not null unique")
    private String author;
    @NotEmpty
    @Pattern(regexp = "Academic|Mystery|Novel ")
    @Column(columnDefinition = "varchar(25) not null")
    private String category;
    @NotNull
    private Integer isbn;
    @Min(50)
    @Column(columnDefinition = "int")
    private Integer number_of_Pages;

}
