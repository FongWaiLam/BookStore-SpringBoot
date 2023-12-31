package com.bookStore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="my_books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyBookList {
    @Id
    private int id;
    private String name;
    private String author;
    private double price;
}
