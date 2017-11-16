package com.BancoImobiliario.ClassesModels;
import com.BancoImobiliario.Enums.Mensagem;
import javafx.application.Application;

import java.util.Random;


public class Sorte extends Casa_NaoPropietaria {

    private Random mensagem = new Random();

    public Sorte() {
    }

    public Sorte(String nome, int numeracao) {
        super(nome, numeracao);
    }

    public Mensagem SorteiaMensagem(){
        int a =1+ mensagem.nextInt(29);
        return Mensagem.values()[a];
    }



}
