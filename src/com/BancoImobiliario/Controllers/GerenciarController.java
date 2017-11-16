package com.BancoImobiliario.Controllers;

import com.BancoImobiliario.ClassesModels.Apartamento;
import com.BancoImobiliario.ClassesModels.Casa;
import com.BancoImobiliario.ClassesModels.Casa_Propietaria;
import com.BancoImobiliario.ClassesModels.Companhia;
import com.BancoImobiliario.Partida;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn.CellDataFeatures;

import javax.security.auth.callback.Callback;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GerenciarController implements Initializable {
    private Partida partida;
    private PrincipalController principalController;
    private ObservableList<Apartamento> meusapps;
    private ObservableList<Companhia> minhasCias;
    private ObservableList <Casa_Propietaria> totaldecasa;
    private ArrayList<Casa_Propietaria> inter = new ArrayList<>();
    private int valorjogada;
    private boolean ecobranca;

    public GerenciarController(Partida partida, PrincipalController principalController) {
        this.partida = partida;
        this.principalController = principalController;
    }



    @FXML
    private Label preco, casa, NameJogador;

    @FXML
    private Button botaddcasa, botaddhotel, botDelcasa, botDelhotel, botHipo;

    @FXML
    private ChoiceBox<Casa_Propietaria> dropaddcasa, dropaddHot, dropDelcasa, dropDelHotel, dropHipo;

    @FXML
    private TableView<Apartamento> apps;

    @FXML
    private TableView<Companhia> cias;

    @FXML
    private Polygon rect;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(partida.getJogadorRodada().getValorJogada()!=0){
            preco.setText("Ação Pendente R$ " + partida.getJogadorRodada().getValorJogada());
            if(partida.getJogadorRodada().isEcobramca()){
                preco.setTextFill(Color.RED);
            }else{
                preco.setTextFill(Color.RED);
            }
        }

        NameJogador.setText("Vez de: "+partida.getJogadorRodada().getNome()+"("+partida.getJogadorRodada().getPontuacao()+")");
        NameJogador.setTextFill(partida.getJogadorRodada().getCor().Converte());
        rect.setFill(partida.getJogadorRodada().getCor().Converte());
        casa.setText(partida.getTabuleiro().get(partida.getJogadorRodada().getPosicao()).getNome()+ ", Casa: "+ (partida.getJogadorRodada().getPosicao()-1));

        meusapps = FXCollections.observableArrayList(partida.getJogadorRodada().getMeusapartamentos());
        minhasCias = FXCollections.observableArrayList(partida.getJogadorRodada().getMinhascompanhias());
        inter.addAll(partida.getJogadorRodada().getMeusapartamentos());
        inter.addAll(partida.getJogadorRodada().getMinhascompanhias());
        totaldecasa = FXCollections.observableArrayList(inter);
        dropHipo.setItems(totaldecasa);

        TableColumn nome = new TableColumn<Casa, String>("Nome");
        TableColumn cor = new TableColumn<>("Cor");
        TableColumn ValorJogada = new TableColumn<>("Valor Jogada");
        TableColumn hipoteca = new TableColumn<>("Hipoteca");
        TableColumn Casa = new TableColumn<>("Casa(R$)");
        TableColumn Hotel = new TableColumn<>("Hotel(R$)");

        nome.setCellValueFactory(new PropertyValueFactory<Casa_Propietaria, String>("Nome"));
        nome.setMaxWidth(105);
        nome.setPrefWidth(105);

        cor.setCellValueFactory(new PropertyValueFactory<>("minhacor"));
        hipoteca.setMaxWidth(50);
        hipoteca.setPrefWidth(50);
        hipoteca.setCellValueFactory(new PropertyValueFactory<>("Hipoteca"));
        cor.setMaxWidth(50);
        cor.setPrefWidth(50);
        Casa.setCellValueFactory(new PropertyValueFactory<>("Valor_Casa"));
        Casa.setMaxWidth(50);
        Casa.setPrefWidth(50);
        Hotel.setCellValueFactory(new PropertyValueFactory<>("Valor_Hotel"));
        Hotel.setMaxWidth(50);
        Hotel.setPrefWidth(50);
        ValorJogada.setCellValueFactory(new PropertyValueFactory<>("Valor_Jogada"));
        ValorJogada.setMaxWidth(80);
        ValorJogada.setPrefWidth(80);

        apps.getColumns().addAll(nome,cor,Casa,Hotel,hipoteca);
        cias.getColumns().addAll(nome,ValorJogada, hipoteca);

        apps.setItems(meusapps);
        cias.setItems(minhasCias);


    }

    @FXML
    private void BotAddCasa() throws  Exception   {


    }

    @FXML
    private void BotAddHotel() throws  Exception   {

    }

    @FXML
    private void BotDelCasa() throws  Exception   {


    }

    @FXML
    private void BotDelHotel() throws  Exception   {


    }

    @FXML
    private void BotHipo() throws  Exception   {


    }

    @FXML
    private void Butao1() throws  Exception   {
        if(partida.getCont() == (partida.qtd_jogadores() -1)){
            partida.setCont(0);
        }
        else partida.setCont(partida.getCont()+1);
        partida.setNewScene("Views/PlayerBoard.fxml");
    }


    private void FiltrarCasa(){

    }
    private void FiltrarHotel(){

    }

    private void FiltrarRemoveCasa(){

    }

    private void FiltrarRemoveHotel(){

    }

}
