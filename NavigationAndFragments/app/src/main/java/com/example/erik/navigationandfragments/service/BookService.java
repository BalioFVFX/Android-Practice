package com.example.erik.navigationandfragments.service;

import com.example.erik.navigationandfragments.model.Book;
import com.example.erik.navigationandfragments.model.CustomDb;

import java.util.List;

public class BookService implements BookServiceImpl {
    public List<Book> getBooks(){
        return CustomDb.getBooks();
    }

    @Override
    public boolean updateBook(Book book) {
        for (Book entity: CustomDb.getBooks()){
            if(entity.getIsbn().equals(book.getIsbn())){
                entity = book;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addBook(Book book) {
        for (Book entity: CustomDb.getBooks()){
            if(entity.getIsbn().equals(book.getIsbn())){
                return false;
            }
        }
        CustomDb.addBook(book);
        return true;
    }
}
