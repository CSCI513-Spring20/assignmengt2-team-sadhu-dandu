
import java.awt.Point;

public class OceanMap {


    int xcoord ,ycoord  ;

    static boolean[][] myGrid = new boolean[10][10]; // creating a grid of size 10*10

    public void setLocation(int i , int j){ // to intiate and to update locations on the grid
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
