import java.awt.Point;

public class Ship {
    int scale = 50;
    int xcoord = 6;
    int ycoord = 6;
    public Point goEast(int x , int y){
        if(xcoord >= 450){
            xcoord = xcoord;
            ycoord = ycoord;
        }
        else{
            xcoord = x + 50;
            ycoord = y;
        }
        return new Point (xcoord , ycoord);
    }
    public Point goWest(int x , int y){
        if(xcoord <= 0){
            xcoord = xcoord;
            ycoord = ycoord;

        }
        else{
            xcoord = x - 50;
            ycoord = y;
        }
        return new Point(xcoord , ycoord);
    }
    public Point goNorth(int x, int y) {
        if(ycoord <= 0){
            xcoord = xcoord;
            ycoord = ycoord;
        }
        else{
            xcoord = x;
            ycoord = y - 50;
        }
        return new Point(xcoord , ycoord);
    }
    public Point goSouth(int x, int y) {
        if(ycoord >= 450){
            xcoord = xcoord;
            ycoord = ycoord;

        }
        else{
            xcoord = x;
            ycoord = y +50;
        }
        return new Point(xcoord , ycoord);
    }

    public Point  getLocation(){
        return new Point(xcoord , ycoord);
    }

}