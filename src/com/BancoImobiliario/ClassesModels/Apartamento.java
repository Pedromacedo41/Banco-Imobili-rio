package com.BancoImobiliario.ClassesModels;

import com.BancoImobiliario.Enums.cores;

public class Apartamento extends  Casa_Propietaria {

    private int Valor_Casa;
    private int Valor_Hotel;
    private int NumeroCasas;
    private boolean hotel;
    private int[] TabelaAluguel = new int[6];
    private cores minhacor;

    public Apartamento(String nome, int numeracao, int preco, int hipoteca, int valor_Casa, int valor_Hotel, int[] tabelaAluguel, cores minhacor) {
        super(nome, numeracao, preco, hipoteca);
        this.Valor_Casa = valor_Casa;
        this.Valor_Hotel = valor_Hotel;
        this.TabelaAluguel = tabelaAluguel;
        this.minhacor = minhacor;
    }

    public int ValorAluguel(){
        int c=0;
        if(hotel) c=1;
        return TabelaAluguel[c+NumeroCasas];
    }

    public int getNumeroCasas() {
        return NumeroCasas;
    }

    public void setNumeroCasas(int numeroCasas) {
        NumeroCasas = numeroCasas;
    }

    public boolean isHotel() {
        return hotel;
    }

    public void setHotel(boolean hotel) {
        this.hotel = hotel;
    }

    public int getValor_Casa() {
        return Valor_Casa;
    }

    public int getValor_Hotel() {
        return Valor_Hotel;
    }

    public cores getMinhacor() {
        return minhacor;
    }

    public int[] getTabelaAluguel() {
        return TabelaAluguel;
    }

}
