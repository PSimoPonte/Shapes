
import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.StrokeTransition;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import static javafx.scene.input.MouseEvent.MOUSE_PRESSED;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Simone.Pontalti
 */
public class FinestraDiGestione implements EventHandler<MouseEvent> {
    
       @Override
       public void handle(MouseEvent e){

            if(shapes.circ.isPressed()){
            
                scompariCerchio1();
            }
            
            if(shapes.rect1.isPressed()){
            
                coloraRettangolo1();
            }
            
            if(shapes.ell.isPressed()){
            
                coloraEllisse1();
            }
            if(shapes.rect2.isPressed()){
            
              ruotaRettangolo2();
            }
            
            if(shapes.cylinder.isPressed()){
                
                ingrandisciCilindro();
            }
            if(shapes.ell2.isPressed()){
                
                coloraBordoEll2();
            }
       }
   
        public void scompariCerchio1(){
            
            ScaleTransition transizione = new ScaleTransition();
            Duration d = new Duration(1000);
            transizione.setNode(shapes.circ); 
            transizione.setDuration(d); 
            transizione.setFromX(1); 
            transizione.setFromY(1); 
            transizione.setToX(2); 
            transizione.setToY(2); 
            transizione.setAutoReverse(true);
            transizione.setCycleCount(Timeline.INDEFINITE);
            transizione.play();
            
            FillTransition ft = new FillTransition(Duration.millis(8000), 
                                shapes.circ, Color.RED, Color.BLUE);
            ft.setCycleCount(Timeline.INDEFINITE);
            ft.setAutoReverse(true);
            //ft.setNode(rect);// non c'è!!
            ft.play();
            
    //######## ParallelTransition fa due Transition simultaneamente  ########
    //########################################################################
            ParallelTransition pt1 = new ParallelTransition( transizione, ft); 
           
            pt1.setCycleCount(2);

        }
        
        public void coloraRettangolo1(){
            
            Duration d = new Duration(1000);
            StrokeTransition st = new StrokeTransition(d,shapes.rect1, 
                                            Color.BLUE, Color.CHARTREUSE);
            st.setDuration(d);
            st.setCycleCount(Timeline.INDEFINITE);
            st.setAutoReverse(true);
            shapes.rect1.setStrokeWidth(10); // spessore del bordo
            shapes.rect1.setStroke(Color.GREEN);
            st.play();
            

        }
        
        public void coloraEllisse1(){
           
          Duration d = new Duration(1000);
          FillTransition ft = new FillTransition(d, shapes.ell, 
                                                    Color.RED, Color.BLUE);
          
          ft.setCycleCount(8);
          ft.setAutoReverse(true);
          ft.setCycleCount(Timeline.INDEFINITE);
          //ft.setNode(rect);// non c'è!!
           ft.play();
        }
        
        
        
        public void ingrandisciCilindro(){
           
          ScaleTransition transizione = new ScaleTransition();
            Duration d = new Duration(1000);
            transizione.setNode(shapes.cylinder); 
            transizione.setDuration(d); 
            transizione.setFromX(1); 
            transizione.setFromY(1); 
            transizione.setToX(2); 
            transizione.setToY(2); 
            transizione.setAutoReverse(true);
            transizione.setCycleCount(Timeline.INDEFINITE);
            transizione.play();
        }
        
        public void ruotaRettangolo2(){
           
         Duration d = new Duration(2000);
         RotateTransition transizione = new RotateTransition();
         transizione.setNode(shapes.rect2); 
         transizione.setDuration(d); 
         transizione.setByAngle(360f);
         transizione.setAutoReverse(true);
         transizione.setCycleCount(Timeline.INDEFINITE);
         transizione.play();
        }
        
        public void coloraBordoEll2(){
        
            Duration d = new Duration(1000);
            StrokeTransition st = new StrokeTransition(d,shapes.ell2,
                                                Color.BLUE, Color.CHARTREUSE);
            st.setDuration(d);
            st.setCycleCount(Timeline.INDEFINITE);
            st.setAutoReverse(true);
            shapes.ell2.setStrokeWidth(10); // spessore del bordo
            shapes.ell2.setStroke(Color.CRIMSON);
            st.play();
            
            FillTransition ft = new FillTransition(Duration.millis(8000), 
                                    shapes.circ, Color.RED, Color.BLUE);
            ft.setCycleCount(8);
            ft.setCycleCount(Timeline.INDEFINITE);
            //ft.setNode(rect);// non c'è!!
            ft.play();
            
            
            // ParallelTransition fa due Transition simultaneamente
            ParallelTransition pt1 = new ParallelTransition( st, ft); 
            pt1.setCycleCount(2);
        }
}

