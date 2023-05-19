package com.example.miniblog.controleur;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.miniblog.R;
import com.example.miniblog.model.Article;

import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;

public class Ajouter extends AppCompatActivity {
    Button button1,button2;
    EditText titre,contenu;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter);
        button1 = findViewById(R.id.button1);
        titre = findViewById(R.id.titre);
        contenu = findViewById(R.id.contenu);
        button2 = findViewById(R.id.button2);
        titre.setMovementMethod(null);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ajouter.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               operationdb mydb = new operationdb(Ajouter.this);
               Article article = new Article(titre.getText().toString().trim(),contenu.getText().toString().trim());
               mydb.ajouterArticle(article.getTitre(), article.getContenue());

            }
        });
    }
}