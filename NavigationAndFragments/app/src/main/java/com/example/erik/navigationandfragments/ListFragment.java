package com.example.erik.navigationandfragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.erik.navigationandfragments.model.Book;
import com.example.erik.navigationandfragments.model.CustomDb;
import com.example.erik.navigationandfragments.service.BookService;

import java.io.Serializable;
import java.io.SerializablePermission;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends android.support.v4.app.Fragment {

    private ListView listView;
    private BookService bookService;

    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_list, container, false);

        init(view);

        this.listView.setAdapter(new MySuperAdapter(getActivity().getApplicationContext(), R.layout.fragment_list, bookService.getBooks()));
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                Book book = (Book)parent.getItemAtPosition(position);
                bundle.putSerializable(DetailFragment.BOOK_NAME_BUNDLE_KEY, book);
                DetailFragment detailFragment = DetailFragment.createDetailFragment(bundle);
                getFragmentManager().beginTransaction().replace(R.id.content_frame, detailFragment).addToBackStack(null).commit();
            }
        });
        return view;
    }
    private void init(View view){
        this.listView = view.findViewById(R.id.lv_id);
        this.bookService = new BookService();
    }
}
