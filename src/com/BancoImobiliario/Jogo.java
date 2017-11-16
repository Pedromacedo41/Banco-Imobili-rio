package com.BancoImobiliario;

import com.BancoImobiliario.Controllers.PrincipalController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



public final class Jogo extends Application {

    private static Stage mystage;
    private Partida partida;
    private PrincipalController principalController;

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        mystage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("Views/EnrollPlayers.fxml"));
        mystage.setTitle("Banco Imobiliario - Lançar Dados");
        mystage.setScene(new Scene(root));
        mystage.show();

    }

    public void ChangeScenePrincipal(Partida partida) throws Exception {
        this.partida = partida;
        mystage.close();

        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("Views/Principal.fxml"));
        principalController = new PrincipalController();
        loader2.setController(principalController);

        AnchorPane b = loader2.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(b));
        stage.show();

        this.partida.IniciarJogo(mystage, principalController);
    }






}
