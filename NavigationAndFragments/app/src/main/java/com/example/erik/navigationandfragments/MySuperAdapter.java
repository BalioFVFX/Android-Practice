package com.example.erik.navigationandfragments;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.erik.navigationandfragments.model.Book;

import java.util.List;

public class MySuperAdapter extends ArrayAdapter<Book> {
    private Context context;
    private List<Book> books;

    public MySuperAdapter(@NonNull Context context, int resource, List<Book> books) {
        super(context, resource);
        this.context = context;
        this.books = books;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.fragment_list, parent, false);
        }
        TextView textView = view.findViewById(R.id.tv_book_name);
        textView.setText(books.get(position).getTitle());
        return view;
    }

    @Nullable
    @Override
    public Book getItem(int position) {
        return books.get(position);
    }

    @Override
    public int getCount() {
        return this.books.size();
    }


}
