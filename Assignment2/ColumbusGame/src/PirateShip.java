import java.awt.Point;
import java.util.Observable;
import java.util.Observer;


public class PirateShip implements Observer {
    Point pship;
    Point ccship;

    int i,j ;
    @Override
    public void update(Observable obs, Object a) {

        if(obs instanceof Ship) {
            ccship = ((Ship)obs).getLocation();
            catchCcs();
        }
    }

    public void setLocation (int x, int y) {
        i=x/50;j=y/50;
        OceanMap.myGrid[i][j]= true;

        pship =new Point(x,y);


    }

    public void catchCcs() {
        if(i+1<10&&j+1<10&&pship.x - ccship.x < 0&&pship.y - ccship.y < 0) {
        if(OceanMap.myGrid[i+1][j+1]==false) {
            pship.x=pship.x+50;
            pship.y=pship.y+50;
        }
    }
    else if(i+1<10&&j-1>-1&&pship.x - ccship.x < 0&&pship.y - ccship.y > 0) {
        if(OceanMap.myGrid[i+1][j-1]==false) {
            pship.x=pship.x+50;
            pship.y=pship.y-50;
        }
    }
    else if(i-1>-1&&j-1>-1&&pship.x - ccship.x > 0&&pship.y - ccship.y > 0) {
        if(OceanMap.myGrid[i-1][j-1]==false) {
            pship.x=pship.x-50;
            pship.y=pship.y-50;
        }
    }
    else if(i-1>-1&&j+1<10&&pship.x - ccship.x > 0&&pship.y - ccship.y < 0) {
        if(OceanMap.myGrid[i-1][j+1]==false) {
            pship.x=pship.x-50;
            pship.y=pship.y+50;
        }
    }

    else if(i+1<10&&pship.x - ccship.x < 0) {
        if(OceanMap.myGrid[i+1][j]==false) {
            pship.x = pship.x + 50;
        }
    }
    else if (i-1>-1&&pship.x - ccship.x > 0){
        if(OceanMap.myGrid[i-1][j]==false) {
            pship.x =pship.x - 50;
        }
    }

    else if (j+1<10&&pship.y - ccship.y < 0) {
        if(OceanMap.myGrid[i][j+1]==false) {
            pship.y = pship.y+ 50;
        }
    }
    else if (j-1>-1&&pship.y - ccship.y > 0){
        if(OceanMap.myGrid[i][j-1]==false) {
            pship.y = pship.y-50;
        }
    }

    }

    public Point getLocation() {

        return new Point(pship.x,pship.y);
    }



}