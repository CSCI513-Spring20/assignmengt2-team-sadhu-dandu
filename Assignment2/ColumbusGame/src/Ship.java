import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

public class Ship extends Observable {
    int scale = 50;


    OceanMap omap = new OceanMap();
    int xcoord = omap.getLocation().x;
    int ycoord = omap.getLocation().y;
    public Point goEast(int x , int y){
        if(xcoord != 450){
            xcoord = x + 50;
            ycoord = y;

        }
        else{
            xcoord = xcoord;
            ycoord = ycoord;
        }
        setChanged();
        notifyObservers();

        return new Point (xcoord , ycoord);
    }
    public Point goWest(int x , int y){
        if(xcoord != 0){
            xcoord = x - 50;
            ycoord = y;


        }
        else{
            xcoord = xcoord;
            ycoord = ycoord;


        }
        setChanged();
        notifyObservers();

        return new Point(xcoord , ycoord);
    }
    public Point goNorth(int x, int y) {
        if(ycoord != 0){
            xcoord = x;
            ycoord = y - 50;

        }
        else {
            xcoord = xcoord;
            ycoord = ycoord;
        }
        setChanged();
        notifyObservers();
        //OceanMap.myGrid[x/50][y/50]=true;
        return new Point(xcoord , ycoord);
    }
    public Point goSouth(int x, int y) {
        if(ycoord != 450){
            xcoord = x;
            ycoord = y + 50;


        }
        else {
            xcoord = xcoord;
            ycoord = ycoord;
        }
        setChanged();
        notifyObservers();

        return new Point(xcoord , ycoord);
    }

    public Point  getLocation(){
        return new Point(xcoord , ycoord);
    }

}