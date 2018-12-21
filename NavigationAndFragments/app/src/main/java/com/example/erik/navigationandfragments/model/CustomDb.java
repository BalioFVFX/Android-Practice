package com.example.erik.navigationandfragments.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomDb {
    private static List<Book> books;

    static{
        books = new ArrayList<>();

        books.add(new Book("0001", "The first book"));
        books.add(new Book("0002", "The second book"));
    }

    public void removByIsbn(String isbn){
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i).getIsbn().equals(isbn)){
                books.remove(i);
            }
        }
    }

    public static void addBook(String isbn, String name){
        books.add(new Book(isbn, name));
    }

    public static List<Book> getBooks(){
        return books;
    }

    public static void addBook(Book book){
        books.add(book);
    }

    public static List<Book> getNewBooks(){
        return new ArrayList<>(books);
    }


}
