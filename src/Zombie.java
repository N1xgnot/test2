
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Zombie extends Human {

    private Random rdm = new Random();

    public Zombie(int sx, int sy, int s) {
        super(sx, sy, s);
    }

    public void drawZombie(Graphics g) {
        g.setColor(Color.CYAN);
        int x = super.getX();
        int y = super.getY();
        int xpts[] = {x, x + 8, x + 15, x + 22, x + 30, x + 22, x + 30, x + 22, x + 15, x + 8, x, x + 8};
        int ypts[] = {y + 8, y, y + 8, y, y + 8, y + 15, y + 22, y + 30, y + 22, y + 30, y + 22, y + 15};
        g.fillPolygon(xpts,ypts, 12);
        
    }

    public void handleBorderCollision() {
        int x = super.getX();
        int y = super.getY();
        if ((x <= 0) | (x >= 570) | (y <= 0) | (y >= 570)) {
            super.reverseDirection();
        }
        updatePosition();
    }

    public void hunting(Tongxin t) {
        int zx = super.getX();
        int zy = super.getY();
        int tx = t.getX();
        int ty = t.getY();
        int dir = rdm.nextInt(6);
        if (dir == 0) {
            moveLeft();
        } else if (dir == 1) {
            super.moveUp();
        } else if (dir == 2) {
            super.moveRight();
        } else if (dir == 3) {
            super.moveDown();
        } else if (dir == 4) {
            if (zx < tx) {
                super.moveRight();
            } else {
                super.moveLeft();
            }
        } else if (dir == 5) {
            if (zy < ty) {
                super.moveDown();
            } else {
                super.moveUp();
            }
        }
    }

}
