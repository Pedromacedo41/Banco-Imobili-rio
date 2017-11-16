package com.BancoImobiliario.Controllers;

import com.BancoImobiliario.ClassesModels.Apartamento;
import com.BancoImobiliario.ClassesModels.Casa;
import com.BancoImobiliario.ClassesModels.Casa_Propietaria;
import com.BancoImobiliario.ClassesModels.Companhia;
import com.BancoImobiliario.Partida;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import static com.BancoImobiliario.Enums.cores.Vermelho;

public class ComprarPagarController implements Initializable {
    private Partida partida;
    private PrincipalController principalController;
    private boolean pagou=false;

    public ComprarPagarController(Partida partida, PrincipalController principalController) {
        this.partida = partida;
        this.principalController = principalController;

    }

    @FXML
    private Label NameJogador, casa, dono, preco, warning;

    @FXML
    private  ImageView pict;

    private boolean temdono;

    @FXML
    private Polygon rect;

    @FXML
    private Button bot1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        NameJogador.setText("Vez de: "+partida.getJogadorRodada().getNome()+"("+partida.getJogadorRodada().getPontuacao()+")");
        NameJogador.setTextFill(partida.getJogadorRodada().getCor().Converte());
        rect.setFill(partida.getJogadorRodada().getCor().Converte());
        casa.setText(partida.getTabuleiro().get(partida.getJogadorRodada().getPosicao()).getNome()+ ", Casa: "+ (partida.getJogadorRodada().getPosicao()-1));
        Casa v = partida.getTabuleiro().get(partida.getJogadorRodada().getPosicao());


        if(((Casa_Propietaria) v).isTemDono()){
            bot1.setText("Pagar Agora");
            bot1.setTextFill(Color.RED);
            dono.setText("Dono: " + ((Casa_Propietaria) v).getDono().getNome());
            dono.setTextFill(((Casa_Propietaria) v).getDono().getCor().Converte());
            preco.setTextFill(Color.RED);

            if(v instanceof Companhia){
                preco.setText("Aluguel R$" + Integer.toString(((Companhia) v).Valor_Pagar(3)));

            }else{
                preco.setText("Aluguel R$" +((Apartamento) v).ValorAluguel());
            }

        }else{
            preco.setText("R$ "+Integer.toString(((Casa_Propietaria) v).getPreco()));
            dono.setText("Ainda nao possui dono");
        }
    }

    @FXML
    private void Butao1() throws  Exception   {
        if(partida.getCont() == (partida.qtd_jogadores() -1)){
            partida.setCont(0);
        }
        else partida.setCont(partida.getCont()+1);

        if(pagou || !((Casa_Propietaria) partida.getTabuleiro().get(partida.getJogadorRodada().getPosicao())).isTemDono()){
            partida.setNewScene("Views/PlayerBoard.fxml");
        }else{
            warning.setText("Nao pode sair sem pagar!");
        }

    }

    @FXML
    private void Butao2()  throws  Exception  {
        Casa v = partida.getTabuleiro().get(partida.getJogadorRodada().getPosicao());

        if(!pagou){
            if(v instanceof Companhia){
                partida.getJogadorRodada().setValorJogada(((Companhia) v).Valor_Pagar(3));
                partida.getJogadorRodada().setEcobramca(true);
            }else{
                partida.getJogadorRodada().setValorJogada(((Apartamento) v).ValorAluguel());
                partida.getJogadorRodada().setEcobramca(true);
            }
        }
        partida.setNewScene("Views/Gerencia.fxml");
    }

    @FXML
    private void Comprar()  throws  Exception  {
        bot1.setDisable(true);
        pagou = true;
        Casa_Propietaria v = (Casa_Propietaria) partida.getTabuleiro().get(partida.getJogadorRodada().getPosicao());

        if(v.isTemDono()){
            int valor;
            int c = partida.getJogadorRodada().getPontuacao();
            if(v instanceof Companhia){

                valor=((Companhia) v).Valor_Pagar(3);
                c-=valor;
            }else{
                valor= ((Apartamento)v).ValorAluguel();
                c-=valor;
            }

            v.getDono().setPontuacao(v.getDono().getPontuacao()+valor);
            partida.getJogadorRodada().setPontuacao(c);
            NameJogador.setText("Vez de: "+partida.getJogadorRodada().getNome()+"("+partida.getJogadorRodada().getPontuacao()+")");

        }else{
            v.setDono(partida.getJogadorRodada());
            int c = partida.getJogadorRodada().getPontuacao() - v.getPreco();
            partida.getJogadorRodada().setPontuacao(c);
            NameJogador.setText("Vez de: "+partida.getJogadorRodada().getNome()+"("+partida.getJogadorRodada().getPontuacao()+")");

            if(v instanceof Companhia){
                partida.getJogadorRodada().AdicionaCompanhia((Companhia) v);
                principalController.setc(partida.getJogadorRodada().getPosicao()-2, partida.getJogadorRodada().getNome(), partida.getJogadorRodada().getCor().Converte());
                principalController.sete(partida.getJogadorRodada().getPosicao()-2, "", partida.getJogadorRodada().getCor().Converte());
            }else{
                partida.getJogadorRodada().AdicionaApartamento((Apartamento) v);
                principalController.sete(partida.getJogadorRodada().getPosicao()-2, partida.getJogadorRodada().getNome(), partida.getJogadorRodada().getCor().Converte());
                principalController.setf(partida.getJogadorRodada().getPosicao()-2,"R$ " +((Apartamento) v).ValorAluguel(), Vermelho.Converte());
            }

        }



    }


}

