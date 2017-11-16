package com.BancoImobiliario.ClassesModels;

public class Casa {
    protected String Nome;
    protected int Numeracao;

    public Casa(String nome, int numeracao) {
        this.Nome = nome;
        this.Numeracao = numeracao;
    }

    public Casa() {
    }

    @Override
    public String toString() {
        return super.toString();
    }


    public String getNome() {
        return Nome;
    }

    public int getNumeracao() {
        return Numeracao;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public void setNumeracao(int numeracao) {
        Numeracao = numeracao;
    }

}
