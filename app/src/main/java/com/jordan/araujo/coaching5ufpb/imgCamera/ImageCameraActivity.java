package com.jordan.araujo.coaching5ufpb.imgCamera;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.jordan.araujo.coaching5ufpb.R;


public class ImageCameraActivity extends Activity {

    private final int REQUEST_CAM = 111;

    private ImageView imageViewCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_camera);

        ImageButton camButton = (ImageButton) findViewById(R.id.getImgCamBtn);
        imageViewCamera = (ImageView) findViewById(R.id.imageViewCam);

        camButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(callCameraIntent, REQUEST_CAM);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CAM && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageViewCamera.setImageBitmap(imageBitmap);
        }
    }
}
