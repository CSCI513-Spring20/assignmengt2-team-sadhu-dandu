
import java.awt.Point;

public class OceanMap {

    int xcoord ,ycoord  ;

    boolean[][] myGrid = new boolean[10][10];

    public void setLocation(int i , int j){
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
