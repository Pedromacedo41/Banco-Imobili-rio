package com.BancoImobiliario.ClassesModels;
import com.BancoImobiliario.Enums.Mensagem;
import com.BancoImobiliario.Enums.cores;

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class Jogador {
    private String Nome;
    private boolean Naprisao=false;
    private int ContPrisao=0;
    private cores cor;
    private int valorJogada=0;
    private boolean ecobramca=true;
    private int pontuacao=1500;
    private int VantagemConsecutiva = 0;
    private int Posicao=0;
    private ArrayList<Companhia> minhascompanhias = new ArrayList<>();
    private ArrayList<Apartamento> meusapartamentos = new ArrayList<>();

    public int getValorJogada() {
        return valorJogada;
    }

    public void setValorJogada(int valorJogada) {
        this.valorJogada = valorJogada;
    }

    public boolean isEcobramca() {
        return ecobramca;
    }

    public void setEcobramca(boolean ecobramca) {
        this.ecobramca = ecobramca;
    }


    public Jogador(String nome, cores cor) {
        this.Nome = nome;
        this.cor = cor;
    }

    public ArrayList<Companhia> getMinhascompanhias() {
        return minhascompanhias;
    }

    public ArrayList<Apartamento> getMeusapartamentos() {
        return meusapartamentos;
    }

    public boolean isNaprisao() {
        return Naprisao;
    }

    public void setNaprisao(boolean naprisao) {
        Naprisao = naprisao;
    }

    public Jogador() {
        this.Nome = "";
    }

    public int LancarDado1(){
        Random Dado1 = new Random();
        return (1+ Dado1.nextInt(6));
    }

    public int LancarDado2(){
        Random Dado1 = new Random();
        return (1+ Dado1.nextInt(6));
    }

    public void AdicionaApartamento(Apartamento a){
        meusapartamentos.add(a);
    }
    public void AdicionaCompanhia(Companhia a){
        minhascompanhias.add(a);
    }

    public void HipotecaApartamento(Apartamento a){
        meusapartamentos.remove(a);
        pontuacao+=a.Hipoteca;
    }

    public void HipotecaCompanhia(Companhia a){
        minhascompanhias.remove(a);
        pontuacao+=a.Hipoteca;

    }


    private int ApartamentosColor(cores cor){
        int quantidade=0;
        for (Apartamento T: meusapartamentos) {
            if (T.getMinhacor() == cor) quantidade++;
        }
        return quantidade;
    }

    private ArrayList<cores> Conjuntos(){
        ArrayList<cores> conjunto = new ArrayList<>();
        for (cores cor : cores.values()) {
            if(cor.getQuantidade()==ApartamentosColor(cor) && cor.getQuantidade()!=0)  conjunto.add(cor);
        }
        return conjunto;
    }



    public int getContPrisao() {
        return ContPrisao;
    }

    public void setContPrisao(int contPrisao) {
        ContPrisao = contPrisao;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String getNome() {
        return Nome;
    }

    public cores getCor() {
        return cor;
    }

    public int getPosicao() {
        return Posicao;
    }

    public void setPosicao(int posicao) {
        Posicao = posicao;
    }

}
