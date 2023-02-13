
import java.awt.Color;
import java.awt.Graphics;

public class Tongxin extends Human {

    public Tongxin(int sx, int sy, int s) {
        super(sx, sy, s);
    }

    public void drawHuman(Graphics g) {
        g.setColor(Color.PINK);
        int x = super.getX();
        int y = super.getY();
        
        
        if (super.getDir()== 0) {
            int xpts[] = {x, x + 8, x + 8, x + 15, x + 22, x + 22, x + 30, x + 22, x + 22, x + 15, x + 8, x + 8};
            int ypts[] = {y + 22, y + 15, y + 8, y, y + 8, y + 15, y + 22, y + 22, y + 30, y + 30, y + 30, y + 22};
            g.fillPolygon(xpts, ypts, 12);    
        }
        
         if (super.getDir()== 1) {
            int xpts[] = {x, x + 8, x + 8, x + 15, x + 22, x + 22, x + 30, x + 22, x + 22, x + 15, x + 8, x + 8};
            int ypts[] = {y + 8, y + 8, y, y, y, y + 8, y + 8, y + 15, y + 22, y + 30, y + 22, y + 15};
            g.fillPolygon(xpts, ypts, 12);    
        }
         
          if (super.getDir()== 2) {
            int xpts[] = {x, x + 8, x + 15, x + 22, x + 22, x + 30, x + 30, x + 30, x + 22, x + 22, x + 15, x + 8};
            int ypts[] = {y + 15, y + 8, y + 8, y, y + 8, y + 8, y + 15, y + 22, y + 22, y + 30, y + 22, y + 22};
            g.fillPolygon(xpts, ypts, 12);    
        }
          
           if (super.getDir()== 3) {
            int xpts[] = {x, x + 8, x + 8, x + 15, x + 22, x + 30, x + 22, x + 15, x + 8, x + 8, x, x };
            int ypts[] = {y + 8, y + 8, y , y + 8, y + 8, y + 15, y + 22, y + 22, y + 30, y + 22, y + 22, y + 15};
            g.fillPolygon(xpts, ypts, 12);    
        }

    }

    public boolean collideWithBorder() {
        boolean collide = false;
        int x = super.getX();
        int y = super.getY();
        if ((x <= 0) | (x >= 570) | (y <= 0) | (y >= 570)) {
            collide = true;
        }
        return collide;
    }

    public boolean CollideZombie(Zombie z) {
        boolean collide = false;
        int tx = super.getX();
        int ty = super.getY();
        int zx = z.getX();
        int zy = z.getY();
        int sz = 30;
        if ((zx >= (tx - sz)) & (zx <= (tx + sz)) & (zy >= (ty - sz)) & (zy <= (ty + sz))) {
            collide = true;
        }
        return collide;
    }
}
