package com.example.listacontatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Alterar extends AppCompatActivity {

    TextView alNome, alNumero, alIdade;
    FloatingActionButton al_fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar);

        alNome = findViewById(R.id.al_nome);
        alNumero = findViewById(R.id.al_numero);
        alIdade = findViewById(R.id.al_idade);

        alNumero.addTextChangedListener(Mask.insert("(##)#####-####", (EditText) alNumero));
        alIdade.addTextChangedListener(Mask.insert("##", (EditText) alIdade));


        al_fab = findViewById(R.id.fab_alterar_confirmar);

        Intent intent = getIntent();

        Bundle bundle = this.getIntent().getExtras();
        int pic = bundle.getInt("image");
        final String aNome = intent.getStringExtra("nome");
        String aNumero = intent.getStringExtra("numero");
        String aIdade = intent.getStringExtra("idade");
        final int pos = intent.getIntExtra("position", -1);

        alNome.setText(aNome);
        alNumero.setText(aNumero);
        alIdade.setText(aIdade);

        al_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                String txtNome = alNome.getText().toString();
                String txtNumero = alNumero.getText().toString();
                int txtIdade = Integer.parseInt(alIdade.getText().toString());




                intent.putExtra("nome", txtNome);
                intent.putExtra("numero", txtNumero);
                intent.putExtra("idade", txtIdade);
                intent.putExtra("position", pos);

                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}