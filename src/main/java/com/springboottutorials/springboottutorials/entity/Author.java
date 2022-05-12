package com.springboottutorials.springboottutorials.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Author
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id")
    private int id;
    private String firstName;
    private String lastName;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "author")
    @JsonBackReference // For JSON Bidirectional Mapping
    private Book book;
}
