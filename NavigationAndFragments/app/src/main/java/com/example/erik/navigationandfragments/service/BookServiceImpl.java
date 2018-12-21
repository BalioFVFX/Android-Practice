package com.example.erik.navigationandfragments.service;

import com.example.erik.navigationandfragments.model.Book;

import java.util.List;

public interface BookServiceImpl {
    List<Book> getBooks();
    boolean updateBook(Book book);
    boolean addBook(Book book);
}
