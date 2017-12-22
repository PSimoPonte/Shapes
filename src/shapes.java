/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Simone.Pontalti
 */
public class shapes extends Application {
    
    BorderPane border,border2;
    Group gr,gr2;
    HBox hb,hb2;
    
    
    static Rectangle rect,rect1,rect2;
    static Circle circ;
    static Ellipse ell,ell2;
    static Cylinder cylinder;
    Label lbl1;
    
    @Override
    public void start(Stage primaryStage) {
    
        creaForme();
        rect = new Rectangle(620,115);
        rect.setStroke(Color.DODGERBLUE);
        rect.setStrokeWidth(4);
        rect.setFill(Color.CORNSILK);
        
        rect1.setFill(Color.ORANGE);
        rect1.setStrokeWidth(4);
        
        ell.setFill(Color.AQUAMARINE);
        
        circ.setFill(Color.YELLOW);
        circ.setStroke(Color.AQUA);
        
        rect2.setFill(Color.BROWN);
        rect2.setStrokeWidth(4);
        rect2.setStroke(Color.CADETBLUE);
        
        ell2.setFill(Color.DEEPSKYBLUE);
        ell2.setStroke(Color.LIGHTSLATEGRAY);
        
        
        
        lbl1 = new Label("°°Le figure°°");
        lbl1.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        lbl1.setLayoutX(200); //per centrare la scritta dentro il rect
        lbl1.setLayoutY(15);
        lbl1.setAlignment(Pos.CENTER);
        lbl1.setTextFill(Color.web("#0076a3"));
        
       
        
        gr= new Group();
        gr.getChildren().addAll(rect,lbl1);
        
        
        
  
        
        hb = new HBox(80);
        hb.setPadding(new Insets(10, 10, 10, 10));
        hb.getChildren().addAll(circ,rect1,ell);
        hb.setStyle
            (
                 "-fx-padding: 10;" +
                 "-fx-border-style: solid inside;" +
                 "-fx-border-width: 2;" +
                 "-fx-border-insets: 5;" +
                 "-fx-border-radius: 5;" +
                 "-fx-border-color: blue;"
            );

        
        hb2 = new HBox(80);
        hb2.setPadding(new Insets(10, 10, 10, 10));
        hb2.getChildren().addAll(cylinder,rect2,ell2);
        hb2.setStyle
            (
                 "-fx-padding: 10;" +
                 "-fx-border-style: solid inside;" +
                 "-fx-border-width: 2;" +
                 "-fx-border-insets: 5;" +
                 "-fx-border-radius: 5;" +
                 "-fx-border-color: green;"
            );

        
        border2 = new BorderPane();
        border2.setCenter(hb);
        //border2.setAlignment(hb, Pos.BOTTOM_CENTER);
        border2.setMargin(hb, new Insets(200,150,80,60));
        border2.setBottom(hb2);
        border2.setMargin(hb2, new Insets(100,150,80,60));

        
      //  FinestraDiGestione fin = new FinestraDiGestione();
        
        border = new BorderPane();
        border.setTop(gr);
        border.setCenter(border2);
        
        gr2= new Group();
        gr2.getChildren().addAll(border,gr,border2);
        
        
        
        
        
 //############################################################################
//##  COLLEGAMENTO CON LA CLASSE ESTERNA CHE GESTISCE IL CLICK SUL BOTTONE   ##
//############################################################################
 
        
        FinestraDiGestione ge = new FinestraDiGestione();
        
        circ.addEventHandler(MouseEvent.MOUSE_PRESSED, ge);
        rect1.addEventHandler(MouseEvent.MOUSE_PRESSED, ge);
        ell.addEventHandler(MouseEvent.MOUSE_PRESSED, ge);
        
        cylinder.addEventHandler(MouseEvent.MOUSE_PRESSED, ge);
        rect2.addEventHandler(MouseEvent.MOUSE_PRESSED, ge);
        ell2.addEventHandler(MouseEvent.MOUSE_PRESSED, ge);
        
//#############################################################################
//###########################################################################
    
        
        Scene scene = new Scene(gr2, 624, 800);
        
        primaryStage.setTitle("Windows");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void creaForme(){
    
       
        rect1 = new Rectangle(120,100);
        rect1.setId("rettangolo");
        
        circ = new Circle(40);
        circ.setId("cerchio");
      
        ell = new Ellipse(40,60);
        ell.setId("ellisse");
        
        cylinder = new Cylinder(25.0, 90);
        cylinder.setId("cilindro");
        
        
        rect2 = new Rectangle(120,90);
        rect2.setId("rettangolo");
       
        ell2 = new Ellipse(80,50);
        ell2.setId("ellisse");
        
        
    }
}
