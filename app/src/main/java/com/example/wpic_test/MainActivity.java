package com.example.wpic_test;

import android.os.Bundle;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        window.setStatusBarColor(ContextCompat.getColor(this,R.color.pink));

        ArrayList<MenuListElement> menuListElements = new ArrayList<MenuListElement>();
        menuListElements.add(new MenuListElement("Single Frames"));
        menuListElements.add(new MenuListElement("Double Frames"));
        menuListElements.add(new MenuListElement("Triple Frames"));
        menuListElements.add(new MenuListElement("Collage"));
        menuListElements.add(new MenuListElement("Photo Edit"));
        menuListElements.add(new MenuListElement("Add Text"));

        ArrayList<ImageListElement> imageListElements = new ArrayList<ImageListElement>();

        imageListElements.add(new ImageListElement("image1"));
        imageListElements.add(new ImageListElement("image2"));
        imageListElements.add(new ImageListElement("image4"));
        imageListElements.add(new ImageListElement("image3"));

        imageListElements.add(new ImageListElement("image5"));
        imageListElements.add(new ImageListElement("image6"));
        imageListElements.add(new ImageListElement("image8"));

        imageListElements.add(new ImageListElement("image7"));
        imageListElements.add(new ImageListElement("image9"));




        RecyclerView optionsContainer = findViewById(R.id.options_container);
        RecyclerView imageContainer = findViewById(R.id.images_container);

        MenuAdapter menuAdapter = new MenuAdapter(MainActivity.this, menuListElements,MainActivity.this);
        optionsContainer.setAdapter(menuAdapter);
        GridLayoutManager layoutManager=new GridLayoutManager(this,3);
        optionsContainer.setLayoutManager(layoutManager);

        ImageListAdapter imageListAdapter = new ImageListAdapter(MainActivity.this, imageListElements, MainActivity.this);
        imageContainer.setAdapter(imageListAdapter);

        StaggeredGridLayoutManager imageLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        imageContainer.setLayoutManager(imageLayoutManager);
        imageContainer.setLayoutManager(imageLayoutManager);
        imageContainer.setAdapter(imageListAdapter);

        imageContainer.setHasFixedSize(true);

        //THIS SETS UP THE IMAGES CONTAINER TO BE UNSCROLLABLE BUT DISABLES THE LAST IMAGE
//        imageContainer.setNestedScrollingEnabled(false);

    }


    @Override
    public void onItemClick(int position) {

    }
}

