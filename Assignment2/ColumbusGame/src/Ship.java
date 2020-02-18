import java.awt.Point;
import java.util.Observable;
import java.util.Observer;
// New class Ship extending observable
public class Ship extends Observable {
    int scale = 50;


    OceanMap omap = new OceanMap();
    int xcoord = omap.getLocation().x;// assigning the x coordinate of the ship to the xcoord
    int ycoord = omap.getLocation().y;// assigning the y coordinate of the ship to the ycoord
    public Point goEast(int x , int y){ // method to run when right key is pressed
        if(xcoord != 450){ // Checking for the right most boundary of the grid
            if(omap.myGrid[(x/50)+1][y/50] != true) { // checking for the island locations
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
    public Point goWest(int x , int y){ // method to run when left key is pressed
        if(xcoord != 0){// checking for left most boundary of the grid
            if(omap.myGrid[(x/50)-1][y/50] != true) { // checking for island locations
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
    public Point goNorth(int x, int y) { // method to run when up arrow is pressed
        if(ycoord != 0){ //checking for upper boundary of the grid
            if(omap.myGrid[x/50][(y/50)-1] != true) {// checking for the island locations
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
    public Point goSouth(int x, int y) { // method to run when down arrow is pressed
        if(ycoord != 450){ // checking for bottom boundary of the grid
            if(omap.myGrid[x/50][(y/50)+1] != true)  { // Checking for island locations
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