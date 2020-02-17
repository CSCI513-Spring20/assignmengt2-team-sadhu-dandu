import java.awt.Point;

public class Ship {
    int scale = 50;
    int xcoord = 6;
    int ycoord = 6;
    public Point goEast(int x , int y){ // Method to move ship right side and avoiding ship going to out of bounds
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
    public Point goWest(int x , int y){ // Method to move ship left side and avoiding ship going to out of bounds
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
    public Point goNorth(int x, int y) { // Method to move ship up and avoiding ship going to out of bounds
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
    public Point goSouth(int x, int y) { // Method to move ship down and avoiding ship going to out of bounds
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
