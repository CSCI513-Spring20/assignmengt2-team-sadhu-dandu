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
    OceanMap map = new OceanMap();// object of Ocean Map
    AnchorPane root ;
    Scene scene;
    boolean[][] grid = map.getMap();
    Image ShipImage,Pirateship,imgisland;
    ImageView ShipImageView , PirateShipView,imgislandView;
    int xval = 6;
    int yval = 6;
    int xcoor = 4;
    int ycoor = 4;
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
                rect.setFill(Color.PALETURQUOISE);	
                root.getChildren().add(rect);  //Adding Rectangle to the scene
            }
        }
        loadShipImage(); //Loading Christopher columbus ship image
        loadPirateShip(xcoor,ycoor); //Function call for Displaying First pirateship
        loadPirateShip(xcoor+1,ycoor+1);//Function call for Displaying second pirateship
        for(int z=0; z<10; z++){        
            int l = (int)(Math.random()*10);//Generating x coordinates for island images
            int m = (int)(Math.random()*10);// Generating y coordinates for island images
            if(l != xval && m != yval) {
                if(l != xcoor && m != ycoor) {
                    if (l != (xcoor + 1) && m != (ycoor + 1)) {
                        loadIsland(l, m); //Function call for displaying island images 

                    }
                }
            }

        }
        oceanStage.setScene(scene);
        oceanStage.setTitle("Christopher Columbus Game");
        oceanStage.show();
        startSailing();

    }
    public void loadShipImage() throws Exception{ //Function for displaying christopher columbus ship
        ShipImage = new Image("ship.png",50,50,true,true);
        ShipImageView = new ImageView(ShipImage);
        map.setLocation(xval,yval);
        ShipImageView.setX(xval * scale);
        ShipImageView.setY(yval * scale);
        root.getChildren().add(ShipImageView);

    }
    public void loadPirateShip(int a  , int b) throws Exception{ // Function for displaying Pirateship images
        Pirateship = new Image("pirateShip.png",50,50,true,true);
        PirateShipView = new ImageView(Pirateship);
        map.setLocation(a,b);
        PirateShipView.setX(a* scale);
        PirateShipView.setY(b* scale);
        root.getChildren().add(PirateShipView);

    }
    public void loadIsland(int a , int b) throws Exception{ // Function for displaying Island images
        imgisland = new Image("island.jpg",50,50,true,true);
        imgislandView = new ImageView(imgisland);
        map.setLocation(a,b);
        imgislandView.setX(a* scale);
        imgislandView.setY(b* scale);
        root.getChildren().add(imgislandView);

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

