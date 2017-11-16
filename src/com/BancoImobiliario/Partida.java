package com.BancoImobiliario;
import com.BancoImobiliario.ClassesModels.Casa;
import com.BancoImobiliario.ClassesModels.Jogador;
import com.BancoImobiliario.Comparators.ComparatorDados;
import com.BancoImobiliario.Controllers.*;
import com.BancoImobiliario.Enums.cores;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.util.ArrayList;


public class Partida {

    private Stage mystage;
    private PrincipalController principalController;
    private int Rodada=0;
    private int cont=0;
    private int Numeracao;
    private ArrayList<Jogador> jogadores = new ArrayList<>();
    private ArrayList<Casa> tabuleiro = new ArrayList<>();
    private ArrayList<cores> TotalporCor = new ArrayList<>();
    private String path = "Views/TextSimples.fxml";

    public ArrayList<Casa> getTabuleiro() {
        return tabuleiro;
    }

    public Partida(ArrayList<Casa> tabuleiro) {
        this.tabuleiro = tabuleiro;
    }


    public void AdicionaJogador(Jogador a){
        jogadores.add(a);
    }

    public void ImprimeJogadores(){
        for(Jogador A: jogadores){
            System.out.println(A.getNome()+ " " + A.getCor().toString());
        }
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public void SorteiaOrdem(){
        jogadores.sort(new ComparatorDados());
    }

    private void EliminaJogador(){

    }


    public boolean VitoriaAbsoluta(){
        if(jogadores.size()==1) return true;
        else return false;
    }



    public void IniciarJogo(Stage mystage, PrincipalController principalController) throws Exception {
        this.principalController = principalController;
        this.mystage = mystage;
        CarregarScene();
    }

    public void setNewScene(String path) throws Exception {
        this.Numeracao = Numeracao;
        this.path = path;
        CarregarScene();
    }


    public int qtd_jogadores(){
        return jogadores.size();
    }
    public Jogador getJogadorRodada() {
        return jogadores.get(cont);
    }

    private void CarregarScene() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
        if(path.equals("Views/PlayerBoard.fxml")) {
            JogarInicialController oi = new JogarInicialController(this);
            loader.setController(oi);
        }
        if(path.equals("Views/SorteOuReves.fxml")){
            SorteRevesController oi = new SorteRevesController(this, principalController);
            loader.setController(oi);
        }
        if(path.equals("Views/ComprarPagar.fxml")){
            ComprarPagarController oi = new ComprarPagarController(this,principalController);
            loader.setController(oi);
        }
        if(path.equals("Views/Gerencia.fxml")){
            GerenciarController oi = new GerenciarController(this,principalController);
            loader.setController(oi);
        }
        if(path.equals("Views/TextSimples.fxml")){
            textSimplesController oi = new textSimplesController(this);
            loader.setController(oi);
        }
        if(path.equals("Views/CasaLivre.fxml")){
            CasaLivreController oi = new CasaLivreController(this,principalController);
            loader.setController(oi);
        }

        AnchorPane a = loader.load();
        mystage.setScene(new Scene(a));
        mystage.show();
    }

    public void rotatepanel(int c){
        if(c>=30 && c<=39) {
            principalController.Giro902();
        }
        if(c>=10 && c<21) principalController.Giro270();
        if(c>=20 && c<31) principalController.Giro180();
        if(c>=20 && c<31) principalController.Giro0();

    }
}
