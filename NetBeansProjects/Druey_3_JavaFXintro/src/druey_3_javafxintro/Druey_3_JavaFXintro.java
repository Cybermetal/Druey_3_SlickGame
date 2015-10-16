package druey_3_javafxintro;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class Druey_3_JavaFXintro extends Application {

   public static void main(String[] args) {
        launch(args);
    }
 
   // @Override
   
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Drawing Operations Test");      
        Group root = new Group();
        Canvas canvas = new Canvas(2500, 2000);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        for (int i= 5; i <1000; i++) {
        drawSomeCircle(gc, (int) (Math.random() * i),(int) (Math.random() * i) , 100);
        drawSomeRectangles(gc, (int) (Math.random() * i)+2,(int) (Math.random() * i) +2,(int) (Math.random() * i)+2,(int) (Math.random() * i)+2);
      
        }
        drawSomeRectangles(gc, 50, 50, 50,50);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
     
    private void drawSomeCircle(GraphicsContext gc, int x, int y, int d) {
    //gc.setStroke(Color.BLACK);
    gc.fillOval(x, y, d, d);
    gc.setFill(Color.INDIGO);
    gc.setStroke(null);
    //gc.strokeOval(x, y, d, d);
    }

    private void drawSomeRectangles(GraphicsContext gc, double x , double y, double w, double h){
        //gc.setFill(Color.PURPLE);   
        //gc.fillRect( x, y, w, h );
        gc.setStroke(Color.PURPLE);
        gc.strokeRect( x, y, w, h);
    }
    /*private void drawShapes(GraphicsContext gc) {
        gc.setFill(Color.CORAL);
        gc.setStroke(Color.TURQUOISE);
        gc.setLineWidth(5);
        gc.strokeLine(40, 10, 10, 40);
        gc.fillOval(50, 50, 50, 50);
        gc.strokeOval(100, 100, 30, 30);
        gc.fillRoundRect(110, 60, 30, 30, 10, 10);
        gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
        gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
        gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
        gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
        gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
        gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
        gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
        gc.fillPolygon(new double[]{10, 40, 10, 40},
                       new double[]{210, 210, 240, 240}, 4);
        gc.strokePolygon(new double[]{60, 90, 60, 90},
                         new double[]{210, 210, 240, 240}, 4);
        gc.strokePolyline(new double[]{110, 140, 110, 140},
                          new double[]{210, 210, 240, 240}, 4);
    }*/

//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

   
}