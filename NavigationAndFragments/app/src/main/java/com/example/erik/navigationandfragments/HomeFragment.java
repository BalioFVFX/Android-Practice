package com.example.erik.navigationandfragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.erik.navigationandfragments.model.Book;
import com.example.erik.navigationandfragments.model.CustomDb;
import com.example.erik.navigationandfragments.service.BookService;

import es.dmoral.toasty.Toasty;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    private Button btnAddBook;
    private EditText etBookIsbn;
    private EditText etBookTitle;
    private BookService bookService;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        initWidgets(root);
        setListeners();
        return root;
    }

    private void initWidgets(View root){
        this.btnAddBook = (Button) root.findViewById(R.id.btn_add_book);
        this.etBookTitle = (EditText) root.findViewById(R.id.et_book_name);
        this.etBookIsbn = (EditText) root.findViewById(R.id.et_book_isbn);
        this.bookService = new BookService();
    }

    private void setListeners(){
        this.btnAddBook.setOnClickListener(v -> {
            String bookName = this.etBookTitle.getText().toString();
            String bookIsbn = this.etBookIsbn.getText().toString();

            if(bookName.equals("")){
                Toasty.error(this.getContext(), "Invalid title", Toast.LENGTH_SHORT).show();
                return;
            }
            else if(bookIsbn.equals("")){
                Toasty.error(this.getContext(), "Invalid ISBN", Toast.LENGTH_SHORT).show();
                return;
            }
            Book book = new Book(bookIsbn, bookName);
            if(this.bookService.addBook(book)){
                Toasty.success(this.getContext(), "New book added successfully", Toast.LENGTH_SHORT).show();
                this.etBookTitle.setText("");
                this.etBookIsbn.setText("");
            }
            else{
                Toasty.error(this.getContext(), String.format("Book with ISBN %s already exists", bookIsbn), Toast.LENGTH_SHORT).show();
            }

        });
    }

}
