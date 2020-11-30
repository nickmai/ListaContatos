package com.example.listacontatos;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;

import android.widget.ImageView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;


public class AvatarActivity extends AppCompatActivity {

    int position = -1;

    ArrayList<String> urls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar);


        String imageUri = "https://codeapi.io/photo/500x500?subject=compute";
        saveURLs(imageUri);
        final ImageView ivBasicImage = (ImageView) findViewById(R.id.img);
        Glide.with(AvatarActivity.this).load(imageUri)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(ivBasicImage);

        String imageUri2 = "https://codeapi.io/photo/500x500?subject=game";
        saveURLs(imageUri2);
        ImageView ivBasicImage2 = (ImageView) findViewById(R.id.img2);
        Glide.with(AvatarActivity.this).load(imageUri2)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(ivBasicImage2);

        String imageUri3 = "https://codeapi.io/photo?size=400x400&random=3500";
        saveURLs(imageUri3);
        ImageView ivBasicImage3 = (ImageView) findViewById(R.id.img3);
        Glide.with(AvatarActivity.this).load(imageUri3)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(ivBasicImage3);

        String imageUri4 = "https://codeapi.io/photo?size=200x200";
        saveURLs(imageUri4);
        ImageView ivBasicImage4 = (ImageView) findViewById(R.id.img4);
        Glide.with(AvatarActivity.this).load(imageUri4)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(ivBasicImage4);

        String imageUri5 = "https://codeapi.io/photo?size=400x400&random=1923";
        saveURLs(imageUri5);
        ImageView ivBasicImage5 = (ImageView) findViewById(R.id.img5);
        Glide.with(AvatarActivity.this).load(imageUri5)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(ivBasicImage5);

        String imageUri6 = "https://codeapi.io/photo?size=400x400&random=1990";
        saveURLs(imageUri6);
        ImageView ivBasicImage6 = (ImageView) findViewById(R.id.img6);
        Glide.with(AvatarActivity.this).load(imageUri6)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(ivBasicImage6);

        String imageUri7 = "https://codeapi.io/photo?size=400x400&random=834";
        saveURLs(imageUri7);
        ImageView ivBasicImage7 = (ImageView) findViewById(R.id.img7);
        Glide.with(AvatarActivity.this).load(imageUri7)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(ivBasicImage7);

        String imageUri8 = "https://codeapi.io/photo?size=400x400&random=231";
        saveURLs(imageUri8);
        ImageView ivBasicImage8 = (ImageView) findViewById(R.id.img8);
        Glide.with(AvatarActivity.this).load(imageUri8)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(ivBasicImage8);

        Intent intent = getIntent();
        position = intent.getIntExtra("position", -1);

    }

    public void escolherImagem(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);

        ImageView iv = (ImageView) view;
        String txtUrl = "http://schemas.android.com/apk/res/android";

        if (view.equals(findViewById(R.id.img))){
            txtUrl = urls.get(0);
        }if (view.equals(findViewById(R.id.img2))){
            txtUrl = urls.get(1);
        }if (view.equals(findViewById(R.id.img3))){
            txtUrl = urls.get(2);
        }if (view.equals(findViewById(R.id.img4))){
            txtUrl = urls.get(3);
        }if (view.equals(findViewById(R.id.img5))){
            txtUrl = urls.get(4);
        }if (view.equals(findViewById(R.id.img6))){
            txtUrl = urls.get(5);
        }if (view.equals(findViewById(R.id.img7))){
            txtUrl = urls.get(6);
        }if (view.equals(findViewById(R.id.img8))){
            txtUrl = urls.get(7);
        }


        intent.putExtra("imagem", txtUrl);
        intent.putExtra("position", position);

        setResult(RESULT_OK, intent);
        finish();

    }

    public void saveURLs(String url){
        urls.add(url);
    }


}
