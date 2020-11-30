package com.example.listacontatos;

import android.graphics.Bitmap;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;


@Dao
public interface MainDao {

    @Insert(onConflict = REPLACE)
    void insert(Contato contato);

    @Delete
    void reset(List<Contato> contatoData);

    @Delete
    void delete(Contato contato);

    @Query("UPDATE table_name SET nome = :sNome, " +
            "idade = :sIdade, " +
            "numero = :sNumero WHERE ID = :sID")
    void update(int sID, String sNome, int sIdade, String sNumero);

    @Query("UPDATE table_name SET imagem = :sImagem WHERE ID = :sID")
    void updateImage(int sID, String sImagem);

    @Query("SELECT * FROM table_name")
    List<Contato> getAll();

}
