package com.jordan.araujo.coaching5ufpb.imgGallery;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.jordan.araujo.coaching5ufpb.R;

import java.io.FileDescriptor;

public class GalleryActivity extends Activity {

    private ImageView imgView;
    private int REQUEST_GALLERY = 356;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        ImageButton imgBtn = (ImageButton) findViewById(R.id.callGalleryBtn);
        imgView = (ImageView) findViewById(R.id.galleryImageView);

        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,
                        "Select Picture"), REQUEST_GALLERY);
            }
        });

    }

    public void onActivityResult(int request, int result, Intent data) {
        String path;
        Uri selectedImageUri = data.getData();
        if (Build.VERSION.SDK_INT < 19) {
            path = selectedImageUri.getPath();
            Bitmap bitmap = BitmapFactory.decodeFile(path);
            imgView.setImageBitmap(bitmap);
        } else {
            ParcelFileDescriptor parcelFileDescriptor;
            try {
                parcelFileDescriptor = getContentResolver().openFileDescriptor(selectedImageUri, "r");
                FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
                Bitmap image = BitmapFactory.decodeFileDescriptor(fileDescriptor);
                parcelFileDescriptor.close();
                imgView.setImageBitmap(image);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
