package com.BancoImobiliario.Enums;
import com.BancoImobiliario.ClassesModels.Apartamento;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.ArrayList;

public enum cores {
    Branco("Branco"), Amarelo("Amarelo"), Vermelho("Vermelho"), AzulMarinho("Azul Marinho"),
    AzulEscuro("Azul Escuro"), AzulClaro("Azul Claro"),
    Preto("Preto"), Verde("Verde"), Laranja("Laranja"), Rosa("Rosa"), Roxo("Roxo"), Erro("Erro");

    private String Nome;
    private int quantidade=0;
    private ArrayList<Apartamento> apdaCor = new ArrayList<>();

    cores(String nome) {
        this.Nome = nome;
    }

    public String getNome() {
        return Nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public ArrayList<Apartamento> getApdaCor() {
        return apdaCor;
    }

    public void AdicionaApartamento(Apartamento ApdaCor) {
        this.apdaCor.add(ApdaCor);
    }

    public static cores toColor(String teste){
        for(cores Cor: cores.values()){
            if(Cor.toString()==teste) return Cor;
        }
        return Erro;
    }

    public Paint Converte(){
       if(this == Amarelo) return Color.ORANGE;
       if(this == Vermelho) return javafx.scene.paint.Color.RED;
       if(this == Verde) return Color.DARKGREEN;
       if(this == AzulEscuro) return Color.DARKBLUE;
       if(this == Preto) return javafx.scene.paint.Color.BLACK;
       if(this == Roxo) return Color.PURPLE;
       return javafx.scene.paint.Color.WHITE;

    }


}
