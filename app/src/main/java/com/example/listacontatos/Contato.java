package com.example.listacontatos;

public class Contato {
    private String nome;
    private int idade;
    private String numero;

    public Contato(String nome, int idade, String numero) {
        this.nome = nome;
        this.idade = idade;
        this.numero = numero;
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
    

}
