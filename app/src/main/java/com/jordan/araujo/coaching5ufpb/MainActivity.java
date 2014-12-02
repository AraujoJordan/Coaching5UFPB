package com.jordan.araujo.coaching5ufpb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jordan.araujo.coaching5ufpb.imgCamera.ImageCameraActivity;
import com.jordan.araujo.coaching5ufpb.imgGallery.GalleryActivity;
import com.jordan.araujo.coaching5ufpb.navigationDrawer.NavigationDrawerActivity;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View.OnClickListener listener = new View.OnClickListener() {
            public void onClick(View v) {
                Intent abrirUmaActivity = null;
                switch (v.getId()) {
                    case (R.id.drawerBtn):
                        abrirUmaActivity =
                                new Intent(getApplicationContext(), NavigationDrawerActivity.class);
                        break;
                    case (R.id.imgCamBtn):
                        abrirUmaActivity =
                                new Intent(getApplicationContext(), ImageCameraActivity.class);
                        break;
                    case (R.id.galleryBtn):
                        abrirUmaActivity =
                                new Intent(getApplicationContext(), GalleryActivity.class);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "Botão não implementado ainda", Toast.LENGTH_SHORT);
                        return;
                }
                startActivity(abrirUmaActivity);
            }
        };

        Button btnDrawer = (Button) findViewById(R.id.drawerBtn);
        Button btnImgCam = (Button) findViewById(R.id.imgCamBtn);
        Button btnImgGallery = (Button) findViewById(R.id.galleryBtn);

        btnDrawer.setOnClickListener(listener);
        btnImgCam.setOnClickListener(listener);
        btnImgGallery.setOnClickListener(listener);
    }
}
