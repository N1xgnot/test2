
import java.util.Random;

public class Human {

    private int x;
    private int dx = 0;
    private int y;
    private int dy = 0;
    private int speed;
    private int dir;
    private Random rdm = new Random();

    public Human(int sx, int sy, int s) {
        x = sx;
        y = sy;
        speed = s;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void updatePosition() {
        x = x + dx;
        y = y + dy;
    }

    public void reverseDirection() {
        x = x + dx;
        y = y + dy;
    }

    public void moveLeft() {
        dx = -speed;
        dy = 0;
        dir = 2;
        
    }

    public void moveRight() {
        dx = speed;
        dy = 0;
        dir = 3;
    }

    public void moveUp() {
        dx = 0;
        dy = -speed;
        dir = 0;
    }

    public void moveDown() {
        dx = 0;
        dy = speed;
        dir = 1;
    }
    
    public int getDir(){
        return dir;
    }

}
