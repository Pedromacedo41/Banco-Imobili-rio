package com.BancoImobiliario.ClassesModels;

public class Casa_Propietaria extends Casa {
    protected int preco;
    protected int Hipoteca;
    protected Jogador Dono = new Jogador();
    protected boolean TemDono = false;


    public void setDono(Jogador dono) {
        Dono = dono;
        TemDono = true;
    }

    public Casa_Propietaria(String nome, int numeracao, int preco, int hipoteca) {
        super(nome, numeracao);
        this.preco = preco;
        this.Hipoteca = hipoteca;
    }

    public Jogador getDono() {
        return Dono;
    }

    public boolean isTemDono() {
        return TemDono;
    }

    public void setTemDono(boolean temDono) {
        TemDono = temDono;
    }

    public int getPreco() {
        return preco;
    }

    public int getHipoteca() {
        return Hipoteca;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public void setHipoteca(int hipoteca) {
        Hipoteca = hipoteca;
    }

}
