package com.BancoImobiliario.Controllers;
import com.BancoImobiliario.ClassesModels.Sorte;
import com.BancoImobiliario.Enums.Mensagem;
import com.BancoImobiliario.Partida;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.control.TextArea;

import java.net.URL;

import java.util.ResourceBundle;

public class SorteRevesController implements Initializable {

    private Partida partida;
    private PrincipalController principalController;
    private Mensagem m;

    @FXML
    private Label NameJogador, tag, valor, din, casa;

    @FXML
    private Polygon rect;

    @FXML
    private TextArea textarea;


    @FXML
    private Button bot1, bot2;

    public SorteRevesController(Partida partida, PrincipalController principalController) {
        this.partida = partida;
        this.principalController=principalController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        NameJogador.setText("Vez de: "+partida.getJogadorRodada().getNome()+"("+partida.getJogadorRodada().getPontuacao()+")");
        NameJogador.setTextFill(partida.getJogadorRodada().getCor().Converte());
        rect.setFill(partida.getJogadorRodada().getCor().Converte());
        casa.setText(partida.getTabuleiro().get(partida.getJogadorRodada().getPosicao()).getNome()+ ", Casa: "+ (partida.getJogadorRodada().getPosicao()-1));
        m = new Sorte().SorteiaMensagem();
        textarea.setText(m.getMensagem());


        if(m==Mensagem.M18){
            valor.setText("Vá para a Prisão!");
            valor.setTextFill(Color.RED);
            tag.setTextFill(Color.RED);
            tag.setText("Reves");
            bot1.setText("Bangu1");
            partida.getJogadorRodada().setNaprisao(true);

        }else{
            if(m.isReves()) {
                valor.setText("Pague "+ m.getValor());
                valor.setTextFill(Color.RED);
                tag.setTextFill(Color.RED);
                tag.setText("Reves");
                bot1.setText("Pagar e Passar");
            }else{
                valor.setText("Receba "+ m.getValor());
                valor.setTextFill(Color.GREEN);
                tag.setTextFill(Color.GREEN);
                tag.setText("Sorte");
                bot1.setText("Receber e Passar");
            }

        }

    }

    @FXML
    private void Butao1() throws  Exception   {
        if(partida.getCont() == (partida.qtd_jogadores() -1)){
            partida.setCont(0);
        }
        else partida.setCont(partida.getCont()+1);

        if(m.isReves()) partida.getJogadorRodada().setPontuacao(partida.getJogadorRodada().getPontuacao()-m.getValor());
        else partida.getJogadorRodada().setPontuacao(partida.getJogadorRodada().getPontuacao()+m.getValor());

        partida.setNewScene("Views/PlayerBoard.fxml");
    }

    @FXML
    private void Butao2()  throws  Exception  {
        partida.getJogadorRodada().setValorJogada(m.getValor());
        partida.getJogadorRodada().setEcobramca(m.isReves());
        partida.setNewScene("Views/Gerencia.fxml");
    }



}
