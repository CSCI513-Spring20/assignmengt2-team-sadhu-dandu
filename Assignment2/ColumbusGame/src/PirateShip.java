import java.awt.Point;
import java.util.Observable;
import java.util.Observer;


public class PirateShip implements Observer {
    Point pship;
    Point ccship;
    int i,j ;
    @Override
    public void update(Observable o, Object arg) {

        if(o instanceof Ship) {
            ccship = ((Ship)o).getLocation();
            movepirates();
        }
    }

    public void setLocation (int a, int b) {
        i=a/50;j=b/50;
        OceanMap.myGrid[i][j]= true;

        pship =new Point(a,b);


    }

    public void movepirates() {
        if (i+1<10&&pship.x - ccship.x < 0) {
            pship.x = pship.x + 50;

        }
        else if (i-1>-1&&pship.x - ccship.x > 0){
            pship.x =pship.x - 50;

        }

        if (j+1<10&&pship.y - ccship.y < 0) {
            pship.y = pship.y+ 50;

        }
        else if (j-1>-1&&pship.y - ccship.y > 0){
            pship.y = pship.y-50;

        }
    }

    public Point getLocation() {

        return new Point(pship.x,pship.y);
    }



}