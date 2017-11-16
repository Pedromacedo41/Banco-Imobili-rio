package com.BancoImobiliario.ClassesModels;

public class Companhia extends Casa_Propietaria {

    private int Valor_Jogada;

    public Companhia(String nome, int numeracao, int preco, int hipoteca, int valor_Jogada) {
        super(nome, numeracao, preco, hipoteca);
        Valor_Jogada = valor_Jogada;
    }

    public int Valor_Pagar(int numeroDado){
        return numeroDado*Valor_Jogada;
    }


}
