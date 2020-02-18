import java.awt.*;
import java.lang.*;
import java.util.Random;
import javafx.application.Application;
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
import javafx.scene.input.MouseEvent;


public class OceanExplorer extends Application {
    final int dimension = 10;
    final int scale = 50;
    final int islandcount = 10;
    OceanMap map = new OceanMap();
    AnchorPane root ;
    Scene scene;
    boolean[][] grid = map.getMap();
    Image ShipImage,Pirateship,imgisland;
    ImageView ShipImageView , PirateShipView,PirateShipView2,imgislandView;
    int xval = 6;
    int yval = 6;
    int xcoor = 4;
    int ycoor = 4;
    Ship navy = new Ship();
    PirateShip ps1 = new PirateShip();
    PirateShip ps2 = new PirateShip();
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage oceanStage) throws Exception {
        root = new AnchorPane();
        scene = new Scene(root,scale*dimension,scale*dimension);
        Button button =  new Button("Reset");
        for (int x = 0; x < dimension; x++) {
            for (int y = 0; y < dimension; y++) {
                Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
                rect.setStroke(Color.BLACK);
                rect.setFill(Color.PALETURQUOISE);
                root.getChildren().add(rect);
            }
        }
        loadShipImage();
        button.setLayoutX(200);
        button.setLayoutY(500);
        root.getChildren().add(button);
        /*button.setOnAction(new EventHandler<MouseEvent>() {
            @Override
            //public void handle(MouseEvent e) {



            }
        });*/

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
        oceanStage.setScene(scene);
        oceanStage.setTitle("Christopher Columbus Game");
        navy.addObserver(ps1);
        navy.addObserver(ps2);
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
    public void loadPirateShip(int a  , int b) throws Exception{
        Pirateship = new Image("pirateShip.png",50,50,true,true);
        PirateShipView = new ImageView(Pirateship);
        ps1.setLocation(a*scale,b*scale);
        PirateShipView.setX(a* scale);
        PirateShipView.setY(b* scale);
        root.getChildren().add(PirateShipView);

    }
    public void loadPirateShip2(int a  , int b) throws Exception{
        //Pirateship = new Image("pirateShip.png",50,50,true,true);
        PirateShipView2 = new ImageView(Pirateship);
        ps2.setLocation(a*scale,b*scale);
        PirateShipView2.setX(a* scale);
        PirateShipView2.setY(b* scale);
        root.getChildren().add(PirateShipView2);

    }
    public void loadIsland(int a , int b) throws Exception{
        imgisland = new Image("island.jpg",50,50,true,true);
        imgislandView = new ImageView(imgisland);
        map.setLocation(a,b);
        //map.myGrid[a][b] = true;
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

