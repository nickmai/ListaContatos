package com.example.listacontatos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Contato contato;
    List<Contato> contatos = new ArrayList<>();

    ListView listView;

    FloatingActionButton fab;

    static final int ACTIVITY_2_REQUEST = 1;
    static final int ACTIVITY_3_REQUEST = 2;


    List<String> mNome = new ArrayList<>(10);
    List<String> mNumero = new ArrayList<>(10);
    List<Integer> mIdade = new ArrayList<>(10);
    int mFoto[] = {0};

    TextView mText_Nome, mText_Numero, mText_Idade;


    boolean desc = false;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.fab_add);

        listView = findViewById(R.id.listView);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Add.class);

                startActivityForResult(intent, ACTIVITY_2_REQUEST);

            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, final int pos, long id) {

                final int position = pos;
                PopupMenu popup = new PopupMenu(MainActivity.this, arg1);

                popup.getMenuInflater().inflate(R.menu.pop_up_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {

                        if (item.getTitle().equals("Deletar")) {

                            contatos.remove(pos);

                            MyAdapter adapter = new MyAdapter(MainActivity.this, contatos);
                            listView.setAdapter(adapter);

                        } else if (item.getTitle().equals("Editar")) {
                            Intent intent = new Intent(getApplicationContext(), Alterar.class);


                            intent.putExtra("nome", contatos.get(pos).getNome());
                            intent.putExtra("numero", contatos.get(pos).getNumero());
                            intent.putExtra("idade", String.valueOf(contatos.get(pos).getIdade()));
                            intent.putExtra("position", pos);


                            startActivityForResult(intent, ACTIVITY_3_REQUEST);

                        } else if (item.getTitle().equals("Media")) {
                            Intent intent = new Intent(getApplicationContext(), OutraActivity.class);

                            int soma = 0;
                            float media = 0f;
                            for (Contato c : contatos) {
                                soma += c.getIdade();
                            }
                            media = soma / contatos.size();

                            intent.putExtra("media", String.valueOf(media));

                            startActivity(intent);
                        }
                        return true;
                    }
                });


                popup.show();
                return true;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                //final int position = pos;
                PopupMenu popup = new PopupMenu(MainActivity.this, view);

                popup.getMenuInflater().inflate(R.menu.pop_up_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {

                        if (item.getTitle().equals("Deletar")) {

                            contatos.remove(position);

                            MyAdapter adapter = new MyAdapter(MainActivity.this, contatos);
                            listView.setAdapter(adapter);

                        } else if (item.getTitle().equals("Editar")) {
                            Intent intent = new Intent(getApplicationContext(), Alterar.class);


                            intent.putExtra("nome", contatos.get(position).getNome());
                            intent.putExtra("numero", contatos.get(position).getNumero());
                            intent.putExtra("idade", String.valueOf(contatos.get(position).getIdade()));
                            intent.putExtra("position", position);


                            startActivityForResult(intent, ACTIVITY_3_REQUEST);

                        }else if (item.getTitle().equals("Media")) {
                            Intent intent = new Intent(getApplicationContext(), OutraActivity.class);

                            int soma = 0;
                            float media = 0f;
                            for (Contato c : contatos) {
                                soma += c.getIdade();
                            }
                            media = soma / contatos.size();

                            intent.putExtra("media", String.valueOf(media));

                            startActivity(intent);
                        }
                        return true;
                    }
                });


                popup.show();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == ACTIVITY_2_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {

                String aNome = intent.getStringExtra("nome");
                String aNumero = intent.getStringExtra("numero");
                int aIdade = intent.getIntExtra("idade", 0);


                if (aNome != null) {
                    contatos.add(new Contato(aNome, aIdade, aNumero));

                    MyAdapter adapter = new MyAdapter(this,  contatos);
                    listView.setAdapter(adapter);
                }
            }
            if (resultCode == Activity.RESULT_CANCELED) {

            }
        } else if (requestCode == ACTIVITY_3_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {

                String aNome = intent.getStringExtra("nome");
                String aNumero = intent.getStringExtra("numero");
                int aIdade = intent.getIntExtra("idade", 0);
                int aPos = intent.getIntExtra("position", -1);
                if (aNome != null) {

                    contatos.set(aPos, new Contato(aNome, aIdade, aNumero));

                    MyAdapter adapter = new MyAdapter(this, contatos);
                    listView.setAdapter(adapter);

                }
            }
            if (resultCode == Activity.RESULT_CANCELED) {

            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.mybutton) {
            if (desc == false) {
                Collections.sort(contatos, new Comparator<Contato>() {
                    @Override
                    public int compare(Contato c1, Contato c2) {

                        return Integer.compare(c1.getIdade(), c2.getIdade());
                    }
                });
                desc = !desc;
            } else if (desc == true) {
                Collections.reverse(contatos);
                desc = !desc;
            }

            MyAdapter adapter = new MyAdapter(this, contatos);
            listView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
        return super.onOptionsItemSelected(item);
    }


    class MyAdapter extends ArrayAdapter<Contato> {

        Context context;
        List<Contato> rContato;


        MyAdapter(Context c, List<Contato> contatoList) {
            super(c, R.layout.lista, R.id.textView1, contatoList);
            this.context = c;

            this.rContato = contatoList;

        }


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View lista = layoutInflater.inflate(R.layout.lista, parent, false);

            ImageView images = lista.findViewById(R.id.image);
            TextView myName = lista.findViewById(R.id.textView1);
            TextView myNumber = lista.findViewById(R.id.textView2);
            TextView myAge = lista.findViewById(R.id.idade_textView);

            myName.setText(rContato.get(position).getNome());
            myNumber.setText(rContato.get(position).getNumero());
            myAge.setText(String.valueOf(rContato.get(position).getIdade()));


            return lista;
        }
    }
}
