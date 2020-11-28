package com.example.listacontatos;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "table_name")
public class Contato implements Serializable{

    @PrimaryKey(autoGenerate = true)
    private int ID;

    @ColumnInfo(name = "Nome")
    private String nome;

    @ColumnInfo(name = "idade")
    private int idade;

    @ColumnInfo(name = "numero")
    private String numero;

    public Contato(String nome, int idade, String numero) {
        this.nome = nome;
        this.idade = idade;
        this.numero = numero;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Contato { " +
                "ID: " + ID +
                "| nome: '" + nome + '\'' +
                "| idade: " + idade +
                "| numero: '" + numero + '\'' +
                '}'+ "\n";
    }
}
