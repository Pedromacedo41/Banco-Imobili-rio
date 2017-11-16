package com.BancoImobiliario.ClassesModels;

public class Ganha_Perde extends Casa_NaoPropietaria {
    private int valor;

    public Ganha_Perde(String nome, int numeracao, int valor) {
        super(nome, numeracao);
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
