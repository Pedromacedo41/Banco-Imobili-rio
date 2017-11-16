package com.BancoImobiliario.Controllers;
import com.BancoImobiliario.ClassesModels.*;
import com.BancoImobiliario.Comparators.*;
import com.BancoImobiliario.Enums.cores;
import com.BancoImobiliario.Jogo;
import com.BancoImobiliario.Partida;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import static com.BancoImobiliario.Enums.cores.*;


public class EnrollPlayersController implements Initializable{

    private int numeroJogadores=0;
    private ArrayList<String> coresjogadores = new ArrayList<>();
    private ObservableList<String> coresdisponiveis;
    private ArrayList<Casa> tabuleiro = new ArrayList<>();   //Lista com todas as casas do tabuleiro
    private Partida partida;



    @FXML
    private Label label1,label2,label3,label4,label5,label6, label7;

    @FXML
    private TextField inputText1, inputText2, inputText3, inputText4, inputText5, inputText6;

    @FXML
    private Button botao1,botao2,botao3,botao4,botao5,botao6;

    @FXML
    private ChoiceBox<String> check1,check2,check3,check4,check5,check6;


    public EnrollPlayersController() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        InicializaCores();
        check1.setItems(coresdisponiveis);
        check2.setItems(coresdisponiveis);
        check3.setItems(coresdisponiveis);
        check4.setItems(coresdisponiveis);
        check5.setItems(coresdisponiveis);
        check6.setItems(coresdisponiveis);
        PopularTabuleiro(tabuleiro);
        partida = new Partida(tabuleiro);

    }


    @FXML   //event handler
    private void StartGame() throws Exception{
        if(numeroJogadores<2) label7.setText("Insira pelo menos 2 jogadores");
        else {
            partida.SorteiaOrdem();
            new Jogo().ChangeScenePrincipal(partida);
        }

    }

    @FXML //event handler
    private void CheckPlayer1(){
        if(inputText1.getText().isEmpty()) label1.setText("Preencha o nome do Jogador");
        else{
            if(check1.getSelectionModel().isEmpty()) label1.setText("Escolha uma opcao de Cor");
            else {
                label1.setText("");
                inputText1.setDisable(true);
                botao1.setDisable(true);
                check1.setDisable(true);
                numeroJogadores++;
                String cor = check1.getSelectionModel().getSelectedItem();
                partida.AdicionaJogador(new Jogador(inputText1.getText(), cores.toColor(cor)));
                coresdisponiveis.remove(cor);
            }

        }
    }

    @FXML //event handler
    private void CheckPlayer2(){
        if(inputText2.getText().isEmpty()) label2.setText("Preencha o nome do Jogador");
        else{
            if(check2.getSelectionModel().isEmpty()) label2.setText("Escolha uma opcao de Cor");
            else {
                label2.setText("");
                inputText2.setDisable(true);
                botao2.setDisable(true);
                check2.setDisable(true);
                numeroJogadores++;
                String cor = check2.getSelectionModel().getSelectedItem();
                partida.AdicionaJogador(new Jogador(inputText2.getText(), cores.toColor(cor)));
                coresdisponiveis.remove(cor);

            }
        }
    }

    @FXML //event handler
    private void CheckPlayer3(){
        if(inputText3.getText().isEmpty()) label3.setText("Preencha o nome do Jogador");
        else{
            if(check3.getSelectionModel().isEmpty()) label3.setText("Escolha uma opcao de Cor");
            else {
                label3.setText("");
                inputText3.setDisable(true);
                botao3.setDisable(true);
                check3.setDisable(true);
                check3.setDisable(true);
                numeroJogadores++;
                String cor = check3.getSelectionModel().getSelectedItem();
                partida.AdicionaJogador(new Jogador(inputText3.getText(), cores.toColor(cor)));
                coresdisponiveis.remove(cor);
            }
        }
    }

    @FXML //event handler
    private void CheckPlayer4(){
        if(inputText4.getText().isEmpty()) label4.setText("Preencha o nome do Jogador");
        else{
            if(check4.getSelectionModel().isEmpty()) label4.setText("Escolha uma opcao de Cor");
            else {
                label4.setText("");
                inputText4.setDisable(true);
                botao4.setDisable(true);
                check4.setDisable(true);
                numeroJogadores++;
                String cor = check4.getSelectionModel().getSelectedItem();
                partida.AdicionaJogador(new Jogador(inputText4.getText(), cores.toColor(cor)));
                coresdisponiveis.remove(cor);
            }
        }
    }

    @FXML //event handler
    private void CheckPlayer5(){
        if(inputText5.getText().isEmpty()) label5.setText("Preencha o nome do Jogador");
        else{
            if(check5.getSelectionModel().isEmpty()) label5.setText("Escolha uma opcao de Cor");
            else {
                label5.setText("");
                inputText5.setDisable(true);
                botao5.setDisable(true);
                check5.setDisable(true);
                numeroJogadores++;
                String cor = check5.getSelectionModel().getSelectedItem();
                partida.AdicionaJogador(new Jogador(inputText5.getText(), cores.toColor(cor)));
                coresdisponiveis.remove(cor);
            }
        }
    }

    @FXML //event handler
    private void CheckPlayer6(){
        if(inputText6.getText().isEmpty()) label6.setText("Preencha o nome do Jogador");
        else{
            if(check6.getSelectionModel().isEmpty()) label6.setText("Escolha uma opcao de Cor");
            else {
                label6.setText("");
                inputText6.setDisable(true);
                botao6.setDisable(true);
                check6.setDisable(true);
                numeroJogadores++;
                String cor = check6.getSelectionModel().getSelectedItem();
                partida.AdicionaJogador(new Jogador(inputText6.getText(), cores.toColor(cor)));
                coresdisponiveis.remove(cor);
            }
        }
    }

    private void InicializaCores(){
        coresjogadores.add(Amarelo.toString());
        coresjogadores.add(AzulEscuro.toString());
        coresjogadores.add(Verde.toString());
        coresjogadores.add(Roxo.toString());
        coresjogadores.add(Vermelho.toString());
        coresjogadores.add(Preto.toString());
        coresdisponiveis= FXCollections.observableArrayList(coresjogadores);
    }

    private void PopularTabuleiro(ArrayList<Casa> casas){
        //adicionando companhias
        casas.add(new Companhia("Transporte Alternativo", 7, 200, 100, 50));
        casas.add(new Companhia("Segurança Patrimonial",5, 200, 100, 50));
        casas.add(new Companhia("Serviço de Moto-Taxi", 35, 200, 100, 50));
        casas.add(new Companhia("Máquina de Caça-Níqueis", 32, 200, 100, 50));
        casas.add(new Companhia("Sinal de TV à Gato", 25, 150, 75, 40));
        casas.add(new Companhia("Botijao de Gás", 15, 150, 75, 40));

        //adicionando ganhas e perdes
        casas.add(new Ganha_Perde("Imposto de Renda", 24 , -200));
        casas.add(new Ganha_Perde("Lucros ou Dividendos", 18, 200 ));
        casas.add(new Ganha_Perde("Ponto de Partida", 0, 200));

        //adicionando Casas Livres, Prisao
        casas.add(new Casa_Livre("Prisao Visitante", 10));
        casas.add(new Casa_Livre("Parada Livre", 20));
        casas.add(new Casa_Livre("Ponto Inicial", 0));
        casas.add(new Prisao("Prisao", 30));

        //adicionando Sorte ou Reves
        casas.add(new Sorte("Sorte ou Reves", 2));
        casas.add(new Sorte("Sorte ou Reves", 12));
        casas.add(new Sorte("Sorte ou Reves", 16));
        casas.add(new Sorte("Sorte ou Reves", 22));
        casas.add(new Sorte("Sorte ou Reves", 27));
        casas.add(new Sorte("Sorte ou Reves", 37));

        //adicionando apartamentos
        casas.add(new Apartamento("Av. Pacaembú", 13, 180, 90, 100, 100, new int[]{14,70,200,550,750,950}, Roxo));
        casas.add(new Apartamento("Rua Augusta" , 12, 180, 90, 100, 100, new int[]{14,70,200,550,750,950}, Roxo));
        casas.add(new Apartamento("Av. Europa", 11, 200, 100, 100, 100, new int[]{16,80,220,600,800,1000}, Roxo));

        casas.add(new Apartamento("Jardim Paulista", 38, 280, 140, 150, 150, new int[] {24,120,360,850,1025,1200}, AzulMarinho));
        casas.add(new Apartamento("Brooklin", 39, 260, 130, 150, 150, new int[]{22,110,330, 800, 975, 1150}, AzulMarinho));

        casas.add(new Apartamento("Botafogo", 21, 100, 50, 50, 50, new int[]{6,30,90,270,400,500}, Vermelho));
        casas.add(new Apartamento("Flamengo", 23, 120, 60, 50, 50, new int[]{8,40,100,300,450,600}, Vermelho));

        casas.add(new Apartamento("Interlagos", 17, 350, 175, 200, 200,new int[]{35,175,500,1100,1300,1500}, Laranja));
        casas.add(new Apartamento("Morumbi", 19, 400, 200, 200, 200, new int[]{50,200,600,1400,1700,2000}, Laranja));

        casas.add(new Apartamento("Av. 9 de Julho", 9, 220, 110, 150, 150, new int[]{18,90,250,700,875,1050}, AzulClaro));
        casas.add(new Apartamento("Av. Brigadeiro Faria Lima", 6, 240, 120, 150, 150, new int[] {20,100,300,750,925,1100}, AzulClaro));
        casas.add(new Apartamento("Av. Rebouças", 8 , 220, 110, 150, 150, new int[]{18,90,250,700,875,1050}, AzulClaro));

        casas.add(new Apartamento("Av. Paulista", 28, 140, 70, 100, 100,new int[]{10,50,150,450,625,750}, Amarelo));
        casas.add(new Apartamento("Av. Brasil", 26, 160, 80, 100, 100, new int[]{12,60,180,500,700,900}, Amarelo));
        casas.add(new Apartamento("Jardim Europa", 29, 140, 70, 100, 100, new int[]{10,50,150,450,625,750}, Amarelo));

        casas.add(new Apartamento("Leblon", 1, 100, 50, 50, 50, new int[] {6,30,90,270,400,500}, Rosa));
        casas.add(new Apartamento("Av. Presidente Vargas", 3, 60, 30, 50, 50, new int[] {2,10,30,90,160,250}, Rosa));
        casas.add(new Apartamento("Av. Nossa Sra de Copacabana", 4, 60, 30, 50, 50, new int[]{4,20,60,180,320,450}, Rosa));

        casas.add(new Apartamento("Ipanema", 36, 300, 150, 200, 200, new int[]{26,130,390,900,1100,1275}, Verde));
        casas.add(new Apartamento("Av. Vieira Souto", 33, 320, 160, 200, 200, new int[]{28,150,450,1000,1200,1400}, Verde));
        casas.add(new Apartamento("Av. Atlântica", 34, 300, 150, 200, 200, new int[]{26,130,390,900,1100,1275}, Verde));
        casas.add(new Apartamento("Copacabana", 31, 260, 130, 150, 150, new int[]{22,110,330,800,975,1150}, Verde));

        casas.sort(new ComparatorPosicao());

        for(int i =0; i< casas.size(); i++){
            Casa T = casas.get(i);
            if(T instanceof Apartamento){
                cores Cor = ((Apartamento) T).getMinhacor();
                Cor.setQuantidade(Cor.getQuantidade()+1);
                Cor.AdicionaApartamento((Apartamento) T);
            }
        }
    }



}
