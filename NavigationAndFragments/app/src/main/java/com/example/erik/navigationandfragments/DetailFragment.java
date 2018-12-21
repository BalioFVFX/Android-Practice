package com.example.erik.navigationandfragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.erik.navigationandfragments.model.Book;
import com.example.erik.navigationandfragments.service.BookService;

import es.dmoral.toasty.Toasty;

public class DetailFragment extends android.support.v4.app.Fragment {

    public final static String BOOK_NAME_BUNDLE_KEY = "book_key";
    public final static String BOOK_POSITION_BUNDLE_KEY = "book_key";

    private TextView textView;
    private EditText editText;
    private Button button;
    private Book book;
    private BookService bookService;

    public DetailFragment() {
        // Required empty public constructor
    }

    public static DetailFragment createDetailFragment(Bundle bundle){
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setArguments(bundle);

        return detailFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        this.book = (Book)this.getArguments().getSerializable(BOOK_NAME_BUNDLE_KEY);
        this.init(view);
        this.setListeners();

        return view;
    }

    private void init(View view){
        this.textView = (TextView)view.findViewById(R.id.tv_detail_book_name);
        this.editText = (EditText)view.findViewById(R.id.et_new_book);
        textView.setText(String.format("%s %s", this.book.getTitle(), this.book.getIsbn()));
        this.editText.setText(this.book.getTitle());
        this.button = (Button)view.findViewById(R.id.btn_rename_book);
        this.bookService = new BookService();
    }

    private void setListeners(){
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textView.setText(String.format("%s %s", s, book.getIsbn()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        this.button.setOnClickListener(v -> {
            this.book.setTitle(editText.getText().toString());
            if(this.bookService.updateBook(book)){
                Toasty.success(this.getContext(), "Book updated successfully", Toast.LENGTH_SHORT).show();
            }else{
                Toasty.error(this.getContext(), "Book update failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
