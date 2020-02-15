import java.lang.*;
import java.util.Random;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;


public class OceanExplorer extends Application {
    final int dimension = 10;
    final int scale = 50;
    OceanMap map = new OceanMap();
    AnchorPane root ;
    Scene scene;
    boolean[][] grid = map.getMap();
    Image ShipImage;
    ImageView ShipImageView;
    int xval = 6;
    int yval = 6;
    Ship navy = new Ship();
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage oceanStage) throws Exception {
        root = new AnchorPane();
        scene = new Scene(root,scale*dimension,scale*dimension);
        for (int x = 0; x < dimension; x++) {
            for (int y = 0; y < dimension; y++) {
                Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
                rect.setStroke(Color.BLACK);
                rect.setFill(Color.PALETURQUOISE);	//Filling the background
                root.getChildren().add(rect);
            }
        }
        loadShipImage();
        oceanStage.setScene(scene);
        oceanStage.setTitle("Christopher Columbus Game");
        oceanStage.show();
        startSailing();

    }
    public void loadShipImage() throws Exception{
        ShipImage = new Image("ship.png",50,50,true,true);
        ShipImageView = new ImageView(ShipImage);
        map.setLocation(xval,yval);
        ShipImageView.setX(xval * scale);
        ShipImageView.setY(yval * scale);
        root.getChildren().add(ShipImageView);

    }
    private void startSailing() {	//Method to  start Sailing
        scene.setOnKeyPressed(new EventHandler<KeyEvent>(){


            public void handle(KeyEvent ke) {
                switch(ke.getCode()) {
                    case RIGHT :
                        navy.goEast(map.getLocation().x*scale,map.getLocation().y*scale);
                        break;
                    case LEFT :
                        navy.goWest(map.getLocation().x*scale,map.getLocation().y*scale);

                        break;
                    case UP :
                        navy.goNorth(map.getLocation().x*scale,map.getLocation().y*scale);
                        break;
                    case DOWN :
                        navy.goSouth(map.getLocation().x*scale,map.getLocation().y*scale);
                        break;
                    default :
                        break;
                }
                ShipImageView.setX(navy.getLocation().x);
                ShipImageView.setY(navy.getLocation().y);

                map.setLocation(navy.getLocation().x/scale, navy.getLocation().y/scale);
            }
        });
    }





}

