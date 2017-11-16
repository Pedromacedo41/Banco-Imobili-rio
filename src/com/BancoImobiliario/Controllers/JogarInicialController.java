package com.BancoImobiliario.Controllers;
import com.BancoImobiliario.ClassesModels.*;
import com.BancoImobiliario.Partida;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.shape.Polygon;

import java.net.URL;


import java.util.ResourceBundle;


public class JogarInicialController implements Initializable{

    private Partida partida;
    private boolean prisao;

    @FXML
    private Label NameJogador, StatusPrisao, dado1, dado2, SaidaPrisao, Saida2Prisao, ErroMessage, din;

    @FXML
    private Polygon rect;

    private int dado=0, Dado=0;
    private boolean flag=false;  //Os dois dados foram jogados

    @FXML
    private Button bot1, bot2;

    public JogarInicialController(Partida partida) {
        this.partida = partida;
    }

    public JogarInicialController() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        NameJogador.setText("Vez de : "+partida.getJogadorRodada().getNome()+"("+partida.getJogadorRodada().getPontuacao()+")");
        NameJogador.setTextFill(partida.getJogadorRodada().getCor().Converte());
        rect.setFill(partida.getJogadorRodada().getCor().Converte());
        prisao = partida.getJogadorRodada().isNaprisao();
        if(prisao==false){
            StatusPrisao.setText("");
            Saida2Prisao.setText("Boa sorte!");
        }
        else{
            StatusPrisao.setText("Você está na prisão. Tente sair ("+(3-partida.getJogadorRodada().getContPrisao())+ " Tentativas Restantes)");
        }
    }

    @FXML
    private void LancarDado1(){
        dado1.setText(Integer.toString(dado=partida.getJogadorRodada().LancarDado1()));
        bot1.setDisable(true);
        if(Dado!=0) flag =true;
        if(partida.getJogadorRodada().isNaprisao()) {


            if(dado==Dado){
                SaidaPrisao.setText("Parabéns, você Saiu da Prisao!");
                Saida2Prisao.setText("Jogue na Próxima Rodada");
                partida.getJogadorRodada().setNaprisao(false);
                partida.getJogadorRodada().setContPrisao(0);
            }else{
                if(Dado!=0) {
                    if (partida.getJogadorRodada().getContPrisao() == 2) {
                        SaidaPrisao.setText("Fim do tempo máximo de prisao");
                        Saida2Prisao.setText("Jogue na Próxima Rodada");
                        partida.getJogadorRodada().setNaprisao(false);
                        partida.getJogadorRodada().setContPrisao(0);

                    } else {
                        Saida2Prisao.setText("Tente da Próxima Vez");
                        partida.getJogadorRodada().setContPrisao(partida.getJogadorRodada().getContPrisao() + 1);
                    }
                }
            }

        }

    }

    @FXML
    private void LancarDado2(){
        dado2.setText(Integer.toString(Dado =partida.getJogadorRodada().LancarDado2()));
        bot2.setDisable(true);
        if(dado!=0) flag =true;
        if(partida.getJogadorRodada().isNaprisao()) {


            if(dado==Dado){
                SaidaPrisao.setText("Parabéns, você Saiu da Prisao!");
                Saida2Prisao.setText("Jogue na Próxima Rodada");
                partida.getJogadorRodada().setNaprisao(false);
                partida.getJogadorRodada().setContPrisao(0);
            }else{
                if(dado!=0) {
                    if (partida.getJogadorRodada().getContPrisao() == 2) {
                        SaidaPrisao.setText("Fim do tempo máximo de prisao");
                        Saida2Prisao.setText("Jogue na Próxima Rodada");
                        partida.getJogadorRodada().setNaprisao(false);
                        partida.getJogadorRodada().setContPrisao(0);

                    } else {
                        Saida2Prisao.setText("Tente da Próxima Vez");
                        partida.getJogadorRodada().setContPrisao(partida.getJogadorRodada().getContPrisao() + 1);
                    }
                }
            }

        }
    }


    @FXML
    private void Avancar() throws Exception {
        int k = dado+Dado;
        int novaposicao = 0;
        if(flag){

            if(prisao){
                //passar para o próximo jogador
                if(partida.getCont() == (partida.qtd_jogadores() -1)){
                    partida.setCont(0);
                }
                else partida.setCont(partida.getCont()+1);
                partida.setNewScene("Views/PlayerBoard.fxml");
            }else{

                int atual = partida.getJogadorRodada().getPosicao();
                if((k+atual) > 40 ){
                    partida.getJogadorRodada().setPontuacao(partida.getJogadorRodada().getPontuacao()+200);
                }
                partida.getJogadorRodada().setPosicao((k+atual)%40);
                novaposicao= partida.getJogadorRodada().getPosicao();
            }

            Casa MinhaJogada = partida.getTabuleiro().get(novaposicao);
            System.out.println(MinhaJogada.getNome()+MinhaJogada.getNumeracao());
            partida.rotatepanel(novaposicao);

            if(MinhaJogada instanceof Casa_Livre || MinhaJogada instanceof Prisao || MinhaJogada instanceof Ganha_Perde){
                partida.setNewScene("Views/CasaLivre.fxml");
                System.out.println("Casa_livre");
            }
            if(MinhaJogada instanceof Casa_Propietaria){
                partida.setNewScene("Views/ComprarPagar.fxml");
                System.out.println("Propri");
            }
            if(MinhaJogada instanceof Sorte){

                partida.setNewScene("Views/SorteOuReves.fxml");
                System.out.println("sorte");
            }


        }else{
            ErroMessage.setText("Lance os dois Dados para prosseguir");
        }

    }

}
