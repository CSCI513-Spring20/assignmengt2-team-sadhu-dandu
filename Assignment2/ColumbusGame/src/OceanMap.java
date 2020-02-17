
import java.awt.Point;

public class OceanMap {

    int xcoord ,ycoord  ;

    boolean[][] myGrid = new boolean[10][10]; // creating grid

    public void setLocation(int i , int j){ // setting Locations 
        xcoord = i;
        ycoord = j;
    }

    public boolean[][] getMap() {
        return myGrid;
    }
    public Point getLocation(){
        return new Point(xcoord,ycoord);

    }
}
