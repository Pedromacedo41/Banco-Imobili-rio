package com.BancoImobiliario.Controllers;

import com.BancoImobiliario.Jogo;
import com.BancoImobiliario.Partida;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class textSimplesController implements Initializable{

    @FXML
    private TextArea textarea;

    private Partida partida;

    public textSimplesController(Partida partida) {
        this.partida = partida;
    }

    @FXML
    private void Butao1() throws  Exception   {
        partida.setNewScene("Views/PlayerBoard.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
