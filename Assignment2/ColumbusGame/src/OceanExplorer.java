import java.awt.*;
import java.lang.*;
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;


// OceanExplorer class extending the application
public class OceanExplorer extends Application {

    // variables like dimension, scale, islandcount
    final int dimension = 10;
    final int scale = 50;
    final int islandcount = 10;
    String e;

    // OceanMap object instantiation
    OceanMap map = new OceanMap();
    AnchorPane root ;
    Scene scene;

    boolean[][] grid = map.getMap();

    // variables is of type shipimage, pirateship, imgisland

    Image ShipImage,Pirateship,imgisland;

    // variables is of type imageview , shipviewimage, pirateshipview,

    ImageView ShipImageView , PirateShipView,PirateShipView2,imgislandView;
    int xval = 6;
    int yval = 6;
    int xcoor = 4;
    int ycoor = 4;

    //instantiating the Ship object

    Ship navy = new Ship();
    Stage oS;
    Button button;

    // Instantiating the Pirateship objects

    PirateShip ps1 = new PirateShip(); // objects of pirateShip class
    PirateShip ps2 = new PirateShip();


    // Main Method execution
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage oceanStage) throws Exception {
        // Instantiating the Anchorplane

        root = new AnchorPane();
        scene = new Scene(root,scale*dimension,scale*dimension);
        for (int x = 0; x < dimension; x++) {
            for (int y = 0; y < dimension; y++) {
                Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
                rect.setStroke(Color.BLACK);
                rect.setFill(Color.PALETURQUOISE);
                root.getChildren().add(rect);
            }
        }
// Instantiating the reset button
        button = new Button("Reset");
        // Button dimensions

        button.setLayoutX(250);
        button.setLayoutY(500);
        root.getChildren().add(button);
        // Button action insantiation on click
        button.setOnAction(event -> {
            try {
                start(oceanStage);

            } catch(Exception e){
                e.printStackTrace();
            }
        });
        loadShipImage();
        // pirateship x and y coordinates
        loadPirateShip(xcoor,ycoor);
        loadPirateShip2(xcoor+1,ycoor+1);
        for(int z=0; z<islandcount; z++){
            int l = (int)(Math.random()*10);
            int m = (int)(Math.random()*10);
            if(l != xval && m != yval) {
                if(l != xcoor && m != ycoor) {
                    if (l != (xcoor + 1) && m != (ycoor + 1)) {
                        loadIsland(l, m);

                    }
                }
            }

        }
        //  setting the scene and title
        oceanStage.setScene(scene);
        oceanStage.setTitle("Christopher Columbus Game");
        // adding observer objects
        navy.addObserver(ps1);
        navy.addObserver(ps2);
        oceanStage.show();
        //Instantiating the sailing method
        startSailing();

    }
// Method for loadshipImage
    public void loadShipImage() throws Exception{
        // ShipImage objects with the dimensions
        ShipImage = new Image("ship.png",50,50,true,true);
        ShipImageView = new ImageView(ShipImage);
        // Setting the location for map
        map.setLocation(xval,yval);
        ShipImageView.setX(xval * scale);
        ShipImageView.setY(yval * scale);
        root.getChildren().add(ShipImageView);

    }
    // method for loading the first pirateship
    public void loadPirateShip(int a  , int b) throws Exception{
        // PirateShipImage objects with the dimensions
        Pirateship = new Image("pirateShip.png",50,50,true,true);
        PirateShipView = new ImageView(Pirateship);
        ps1.setLocation(a*scale,b*scale);
        PirateShipView.setX(a* scale);
        PirateShipView.setY(b* scale);
        root.getChildren().add(PirateShipView);

    }
    // method for loading the second pirateship
    public void loadPirateShip2(int a  , int b) throws Exception{
        // PirateShipImage objects with the dimensions
        //Pirateship = new Image("pirateShip.png",50,50,true,true);
        PirateShipView2 = new ImageView(Pirateship);
        ps2.setLocation(a*scale,b*scale);
        PirateShipView2.setX(a* scale);
        PirateShipView2.setY(b* scale);
        root.getChildren().add(PirateShipView2);

    }
    //Method for loaing the islandimage
    public void loadIsland(int a , int b) throws Exception{
        //IslandImage objects with the dimensions
        imgisland = new Image("island.jpg",50,50,true,true);
        imgislandView = new ImageView(imgisland);
        map.setLocation(a,b);
        map.myGrid[a][b] = true;
        //X and Y attributes
        imgislandView.setX(a* scale);
        imgislandView.setY(b* scale);
        root.getChildren().add(imgislandView);

    }

    private void startSailing() {	//Method to  start Sailing
        scene.setOnKeyPressed(new EventHandler<KeyEvent>(){

// method for event handling
            public void handle(KeyEvent ke) {
                switch(ke.getCode()) {
                    case RIGHT :
                        navy.goEast(map.getLocation().x,map.getLocation().y*scale);
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
                PirateShipView.setX(ps1.getLocation().x);
                PirateShipView.setY(ps1.getLocation().y);
                PirateShipView2.setX(ps2.getLocation().x);
                PirateShipView2.setY(ps2.getLocation().y);
                map.setLocation(navy.getLocation().x/scale,navy.getLocation().y/scale);
                map.setLocation(ps1.getLocation().x/scale, ps1.getLocation().y/scale);
                map.setLocation(ps2.getLocation().x/scale, ps2.getLocation().y/scale);



            }
        });
    }





}

