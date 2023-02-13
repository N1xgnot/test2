
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameCanvas extends Canvas implements ActionListener, KeyListener {

    private Timer aTimer;
    private int gameStatus = 0;   // 0 = waiting for start game
                                  // 1 = game running
                                  // 2 = game over
                                  // 3 = pause
    private Tongxin tx;
    private Zombie zombie1, zombie2, zombie3;
    private int score = 0;

    public GameCanvas() {
        aTimer = new Timer(50, this); // 50 ms 0.05 sec or 20x per second
        reset();
        addKeyListener(this);
    }

    public void reset() {
        tx = new Tongxin(300, 500, 10);
        zombie1 = new Zombie(100, 100, 8);
        zombie2 = new Zombie(300, 100, 8);
        zombie3 = new Zombie(500, 100, 8);
        score = 0;
    }

    public int getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(int gs) {
        gameStatus = gs;
    }

    public void startTimer() {
        if (gameStatus == 0) {
            aTimer.start();
            gameStatus = 1;
        }
    }

   

    public void paint(Graphics g) {
        if (tx.collideWithBorder()) {
            gameStatus = 2;
        }
        if (gameStatus == 1) {
            score++;
            zombie1.hunting(tx);
            zombie2.hunting(tx);
            zombie3.hunting(tx);
            tx.updatePosition();
            zombie1.updatePosition();
            zombie2.updatePosition();
            zombie3.updatePosition();
            zombie1.handleBorderCollision();
            zombie2.handleBorderCollision();
            zombie3.handleBorderCollision();
            if (tx.CollideZombie(zombie1)) {
                gameStatus = 2;
            }
            if (tx.CollideZombie(zombie2)) {
                gameStatus = 2;
            }
            if (tx.CollideZombie(zombie3)) {
                gameStatus = 2;
            }
        }
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, 600, 600);
        g.setColor(Color.MAGENTA);
        g.fillRect(0, 600, 600, 30);
        tx.drawHuman(g);
        zombie1.drawZombie(g);
        zombie2.drawZombie(g);
        zombie3.drawZombie(g);
        if (gameStatus == 0) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Serif", Font.BOLD, 25));
            g.drawString("PRESS START TO BEGIN..", 160, 300);
        }
        if (gameStatus == 2) {
            g.setColor(Color.RED);
            g.setFont(new Font("Serif", Font.ITALIC, 25));
            g.drawString("G A M E   O V E R", 210, 300);
        }
        if (gameStatus == 3) {
            g.setColor(Color.YELLOW);
            g.setFont(new Font("Serif", Font.BOLD, 30));
            g.drawString("P A U S E", 250, 300);
        }
        g.setColor(Color.WHITE);
        g.setFont(new Font("San Serif", Font.BOLD, 20));
        g.drawString("S C O R E: " + score, 220, 620);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aTimer) {
            repaint(0, 0, 600, 630);
            requestFocus();
        }
    }

    public void moveLeft() {
        tx.moveLeft();
    }

    public void moveRight() {
        tx.moveRight();
    }

    public void moveUp() {
        tx.moveUp();
    }

    public void moveDown() {
        tx.moveDown();
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == 37) {
            tx.moveLeft();
        } else if (keyCode == 38) {
            tx.moveUp();
        } else if (keyCode == 39) {
            tx.moveRight();
        } else if (keyCode == 40) {
            tx.moveDown();
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }
}
