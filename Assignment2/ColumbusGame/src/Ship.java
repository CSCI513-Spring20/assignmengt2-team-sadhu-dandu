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
            if(omap.myGrid[(x/50)+1][y/50] != true) {
                xcoord = x + 50;
                ycoord = y;
            }
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
            if(omap.myGrid[(x/50)-1][y/50] != true) {
                xcoord = x - 50;
                ycoord = y;
            }

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
            if(omap.myGrid[x/50][(y/50)-1] != true) {
                xcoord = x;
                ycoord = y - 50;
            }
        }
        else {
            xcoord = xcoord;
            ycoord = ycoord;
        }
        setChanged();
        notifyObservers();

        return new Point(xcoord , ycoord);
    }
    public Point goSouth(int x, int y) {
        if(ycoord != 450){
            if(omap.myGrid[x/50][(y/50)+1] != true)  {
                xcoord = x;
                ycoord = y + 50;

            }
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