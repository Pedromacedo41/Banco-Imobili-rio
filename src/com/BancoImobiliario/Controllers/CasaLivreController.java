package com.BancoImobiliario.Controllers;

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

public class CasaLivreController implements Initializable {
    private Partida partida;
    private PrincipalController principalController;

    public CasaLivreController(Partida partida, PrincipalController principalController) {
        this.partida = partida;
        this.principalController = principalController;

    }

    @FXML
    private Label NameJogador, casa, mensagem;

    @FXML
    private  ImageView pict;

    @FXML
    private Polygon rect;

    @FXML
    private Button bot1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File um = new File("/media/pedro/Pedro/Dropbox -Ubuntu/Dropbox/Codes/FirstIntelliJ/src/com/BancoImobiliario/Views/Images/PrisaoVisitante.png");
        File dois = new File("/media/pedro/Pedro/Dropbox -Ubuntu/Dropbox/Codes/FirstIntelliJ/src/com/BancoImobiliario/Views/Images/PontoPartida.png");
        File tres = new File("/media/pedro/Pedro/Dropbox -Ubuntu/Dropbox/Codes/FirstIntelliJ/src/com/BancoImobiliario/Views/Images/LucroseDividendos.png");
        File quatro = new File("/media/pedro/Pedro/Dropbox -Ubuntu/Dropbox/Codes/FirstIntelliJ/src/com/BancoImobiliario/Views/Images/war.png");
        File cinco = new File("/media/pedro/Pedro/Dropbox -Ubuntu/Dropbox/Codes/FirstIntelliJ/src/com/BancoImobiliario/Views/Images/ImpostoRenda.png");
        File seis = new File("/media/pedro/Pedro/Dropbox -Ubuntu/Dropbox/Codes/FirstIntelliJ/src/com/BancoImobiliario/Views/Images/Lucros.png");

        Image paradalivre = new Image(tres.toURI().toString());
        Image prisaovisitante = new Image(um.toURI().toString());
        Image pontoinicial = new Image(dois.toURI().toString());
        Image prisao = new Image(quatro.toURI().toString());
        Image imposto = new Image(cinco.toURI().toString());
        Image lucro = new Image(seis.toURI().toString());


        NameJogador.setText("Vez de: "+partida.getJogadorRodada().getNome()+"("+partida.getJogadorRodada().getPontuacao()+")");
        NameJogador.setTextFill(partida.getJogadorRodada().getCor().Converte());
        rect.setFill(partida.getJogadorRodada().getCor().Converte());
        casa.setText(partida.getTabuleiro().get(partida.getJogadorRodada().getPosicao()).getNome()+ ", Casa: "+ (partida.getJogadorRodada().getPosicao()-1));
        if(partida.getJogadorRodada().getPosicao() == 1){
            mensagem.setText("Parabéns, acaba de ganhar 200 reais !");
            pict.setImage(pontoinicial);
        }
        if(partida.getJogadorRodada().getPosicao() == 11){
            mensagem.setText("Visitando os amigos de cela?");
            pict.setImage(prisaovisitante);
        }
        if(partida.getJogadorRodada().getPosicao() == 21){
            mensagem.setText("Aproveite um bar enquanto ainda tem dinheiro!");
            pict.setImage(paradalivre);

        }
        if(partida.getJogadorRodada().getPosicao() == 31){

            mensagem.setText("Ordem de Prisao! Aproveite Bangu com seus 'Parceriros'");
            bot1.setText("Ir para Bangú");
            partida.getJogadorRodada().setNaprisao(true);
            pict.setImage(prisao);
            mensagem.setTextFill(Color.RED);

        }

        if(partida.getJogadorRodada().getPosicao() == 25){

            mensagem.setText("Perdeu 200! Nao sonegue Imposto!");
            mensagem.setTextFill(Color.RED);
            partida.getJogadorRodada().setPontuacao(partida.getJogadorRodada().getPontuacao()+200);
            NameJogador.setText("Vez de: "+partida.getJogadorRodada().getNome()+"("+partida.getJogadorRodada().getPontuacao()+")");
            pict.setImage(imposto);
        }

        if(partida.getJogadorRodada().getPosicao() == 31){

            mensagem.setText("Ganhou 200! Parece que seus investimentos deram certo!");
            mensagem.setTextFill(Color.GREEN);
            partida.getJogadorRodada().setPontuacao(partida.getJogadorRodada().getPontuacao()+200);
            NameJogador.setText("Vez de: "+partida.getJogadorRodada().getNome()+"("+partida.getJogadorRodada().getPontuacao()+")");
            pict.setImage(lucro);
        }
    }

    @FXML
    private void Butao1() throws  Exception   {
        if(partida.getCont() == (partida.qtd_jogadores() -1)){
            partida.setCont(0);
        }
        else partida.setCont(partida.getCont()+1);
        partida.setNewScene("Views/PlayerBoard.fxml");
    }

    @FXML
    private void Butao2()  throws  Exception  {
        partida.setNewScene("Views/Gerencia.fxml");
    }


}
