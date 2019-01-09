package com.example.erik.easycamera;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.erik.easycamera_dagger.R;

import java.io.File;

import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;
import pl.aprilapps.easyphotopicker.EasyImageConfig;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    private ImageView imageView;
    private Button saveButton;
    private Button photoButton;
    private String imagePath;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);

        } else {
            EasyImage.openCamera(this, EasyImageConfig.REQ_TAKE_PICTURE);
        }

        this.imageView = findViewById(R.id.iv_taken_photo);
        this.saveButton = findViewById(R.id.btn_save_photo);
        this.photoButton = findViewById(R.id.btn_take_photo);
        this.saveButton.setOnClickListener(this);
        this.photoButton.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(final int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        EasyImage.handleActivityResult(requestCode, resultCode, data, this, new DefaultCallback() {
            @Override
            public void onImagePicked(File imageFile, EasyImage.ImageSource source, int type) {
                imagePath = imageFile.getAbsolutePath();
                imageView.setImageBitmap(BitmapFactory.decodeFile(imageFile.getAbsolutePath()));
            }

            @Override
            public void onImagePickerError(Exception e, EasyImage.ImageSource source, int type) {
                super.onImagePickerError(e, source, type);
                Toast.makeText(MainActivity.this, "ERROR!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCanceled(EasyImage.ImageSource source, int type) {
                super.onCanceled(source, type);
                Toast.makeText(MainActivity.this, "CANCEL!", Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save_photo:
                this.savePhoto();
                break;
            case R.id.btn_take_photo:
                EasyImage.openCamera(this, EasyImageConfig.REQ_TAKE_PICTURE);
                break;
            default:
                break;
        }
    }

    private void savePhoto() {
        if (this.imagePath == null) {
            return;
        }
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, "Example");
        values.put(MediaStore.Images.Media.DATE_TAKEN, System.currentTimeMillis()); // DATE HERE
        values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
        values.put(MediaStore.MediaColumns.DATA, imagePath);
        this.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        Toast.makeText(this, "Image saved!", Toast.LENGTH_SHORT).show();
    }
}
