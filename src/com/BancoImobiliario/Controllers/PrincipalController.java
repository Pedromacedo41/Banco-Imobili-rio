package com.BancoImobiliario.Controllers;
import com.BancoImobiliario.Jogo;
import com.BancoImobiliario.Partida;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;


import java.net.URL;
import java.util.ResourceBundle;

public class PrincipalController implements Initializable{

    public PrincipalController(){}
    private double  giro=0;

    @FXML
    private AnchorPane archor;

    @FXML
    private TextArea d0,d1,d2,d3,d4,d5,d6,d7,d8,d9,d10, d11, d12, d13,d14,d15,d16, d17, d18, d19, d20, d21,d22, d23, d24,d25,d26,d27,d28,d29,d30, d31,d32,d33,d34,d35,d36,d37, d38,d39;

    @FXML
    private Label c1,c2,c3,c4,c5,c6, c7,c8,c9,c10,c11,c12, c13,c14,c15, c16,c17,c18, c19,c20, c21,c22,c23,c24, c25,c26, c27,c28,c29,c30, c31,c32, c33, c34,c35,c36,c37,c38,c39;

    @FXML
    private Label e1,e2, e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15,e16, e17,e18, e19,e20, e21, e22, e23, e24, e25,e26,e27 ,e28,e29,e30, e31,e32, e33,e34,e35,e36,e37, e38,e39;

    @FXML
    private Label f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16,f17,f18,f19,f20,f21,f22,f23,f24, f25,f26,f27,f28,f29,f30,f31,f32,f33,f34,f35,f36,f37,f38,f39;

    @FXML
    private Label[] labels1;

    @FXML
    private Label[] labels2;

    @FXML
    private Label[] labels3;

    @FXML
    private TextArea[] textAreas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //String Parentpath = "/media/pedro/Pedro/Dropbox -Ubuntu/Dropbox/Codes/FirstIntelliJ/src/com/BancoImobiliario/Views/Images/";
       // File Prisao = new File(Parentpath+"Prisao.png");
        //Image minhaimagem = new Image(Prisao.toURI().toString());
        textAreas = new TextArea[] {d0,d1,d2,d3,d4,d5,d6,d7,d8,d9,d10, d11, d12, d13,d14,d15,d16, d17, d18, d19, d20, d21,d22, d23, d24,d25,d26,d27,d28,d29,d30, d31,d32,d33,d34,d35,d36,d37, d38,d39};
        labels1 = new Label[] {c1,c2,c3,c4,c5,c6, c7,c8,c9,c10,c11,c12, c13,c14,c15, c16,c17,c18, c19,c20, c21,c22,c23,c24, c25,c26, c27,c28,c29,c30, c31,c32, c33, c34,c35,c36,c37,c38,c39};
        labels2 = new Label[] {e1,e2, e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15,e16, e17,e18, e19,e20, e21, e22, e23, e24, e25,e26,e27 ,e28,e29,e30, e31,e32, e33,e34,e35,e36,e37, e38,e39};
        labels3 = new Label[] {f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16,f17,f18,f19,f20,f21,f22,f23,f24, f25,f26,f27,f28,f29,f30,f31,f32,f33,f34,f35,f36,f37,f38,f39};
        archor.setLayoutY(-400);
    }

    @FXML
    private void Giro90(){
        giro+=90;
        archor.setRotate(giro);
    }

    public void Giro902(){
        archor.setRotate(90);
    }


    public void Giro180(){
        archor.setRotate(180);
    }

    public void Giro270(){
        archor.setRotate(270);
    }

    public void Giro0(){
        archor.setRotate(0);
    }

    private void disable(){
        for(TextArea a: textAreas){
            a.setDisable(true);
        }
    }
    public void setd(int k, String a, Paint paint){
        textAreas[k].setText(a);

    }


    public void setc(int k, String a, Paint paint){
        labels1[k].setText(a);
        labels1[k].setTextFill(paint);

    }

    public void setf(int k, String a, Paint paint){
        labels3[k].setText(a);
        labels3[k].setTextFill(paint);

    }
    public void sete(int k, String a, Paint paint){
        labels2[k].setText(a);
        labels2[k].setTextFill(paint);

    }



}
