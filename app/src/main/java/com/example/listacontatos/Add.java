package com.example.listacontatos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.MaskFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class Add extends AppCompatActivity {

    EditText ed_nome;
    EditText ed_numero;
    EditText ed_idade;

    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        ed_nome = findViewById(R.id.ed_nome);
        ed_numero = findViewById(R.id.ed_numero);
        ed_idade = findViewById(R.id.ed_idade);

        ed_numero.addTextChangedListener(Mask.insert("(##)#####-####", ed_numero));
        ed_idade.addTextChangedListener(Mask.insert("##", ed_idade));

        fab = findViewById(R.id.fab_add_confirmar);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                String txtNome = ed_nome.getText().toString();
                String txtNumero = ed_numero.getText().toString();
                int txtIdade = Integer.parseInt(ed_idade.getText().toString());

                intent.putExtra("nome", txtNome);
                intent.putExtra("numero", txtNumero);
                intent.putExtra("idade", txtIdade);

                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}