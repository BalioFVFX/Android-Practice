package com.example.erik.anonymousclassesdifferentwaystoimplementabuttonlistener;

import android.view.View;
import android.widget.Toast;

public class Buttoner implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "Other class that implements View.OnClickListener, passing (buttoner object as parameter)", Toast.LENGTH_SHORT).show();
    }
}
