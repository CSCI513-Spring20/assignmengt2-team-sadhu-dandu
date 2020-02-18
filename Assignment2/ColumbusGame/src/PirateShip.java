import java.awt.Point;
import java.util.Observable;
import java.util.Observer;


public class PirateShip implements Observer {
    Point pship;
    Point ccship;
    int c,d ;
    @Override
    public void update(Observable o, Object arg) {

        if(o instanceof Ship) {
            ccship = ((Ship)o).getLocation();
            movepirates();
        }
    }

    public void setLocation (int a, int b) {
        c=a/50;d=b/50;
        OceanMap.myGrid[c][d]= true;

        pship =new Point(a,b);


    }

    public void movepirates() {
        //System.out.println("Moved");
        if (c+1<10&&pship.x - ccship.x < 0) {
            pship.x = pship.x + 50;

        }
        else if (c-1>-1&&pship.x - ccship.x > 0){
            pship.x =pship.x - 50;

        }

        if (d+1<10&&pship.y - ccship.y < 0) {
            pship.y = pship.y+ 50;

        }
        else if (d-1>-1&&pship.y - ccship.y > 0){
            pship.y = pship.y-50;

        }
    }

    public Point getLocation() {
        System.out.println(pship.x);

        return new Point(pship.x,pship.y); 		//Return the ships coordinates
    }



}