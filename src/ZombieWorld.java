
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.*;

public class ZombieWorld extends JFrame implements ActionListener {

    private final int SWIDTH = 900;
    private final int SHEIGHT = 700;
    private JButton btnStart, btnExit, btnPause;
    private JButton btnLeft, btnRight, btnUp, btnDown;
    private GameCanvas gameC = new GameCanvas();

    public ZombieWorld() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("ZOMBIE WORLD");
        setSize(SWIDTH, SHEIGHT);
        setLayout(null);
    }

    public void init() {
        gameC.setBounds(25, 25, 600, 630);
        add(gameC);
        btnLeft = new JButton("LEFT");
        btnLeft.setBounds(650, 400, 100, 25);
        btnLeft.addActionListener(this);
        add(btnLeft);
        btnRight = new JButton("RIGHT");
        btnRight.setBounds(750, 400, 100, 25);
        btnRight.addActionListener(this);
        add(btnRight);
        btnUp = new JButton("UP");
        btnUp.setBounds(700, 375, 100, 25);
        btnUp.addActionListener(this);
        add(btnUp);
        btnDown = new JButton("DOWN");
        btnDown.setBounds(700, 425, 100, 25);
        btnDown.addActionListener(this);
        add(btnDown);
        btnStart = new JButton("START");
        btnStart.setBounds(650, 550, 100, 25);
        btnStart.addActionListener(this);
        add(btnStart);
        btnExit = new JButton("EXIT");
        btnExit.setBounds(650, 600, 100, 25);
        btnExit.addActionListener(this);
        add(btnExit);
        btnPause = new JButton("PAUSE");
        btnPause.setBounds(750, 550, 100, 25);
        btnPause.addActionListener(this);
        add(btnPause);
        setVisible(true);
        File soundFile = new File("data/tongxin.wav").getAbsoluteFile();
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
            Clip myClip = AudioSystem.getClip();
            myClip.open(ais);
            myClip.start();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnExit) {
            System.exit(0);
        } else if (e.getSource() == btnStart) {
            if (gameC.getGameStatus() == 0) {
                gameC.startTimer();
                btnStart.setText("RESTART");
            }
            if (gameC.getGameStatus() == 2) {
                gameC.setGameStatus(0);
                gameC.reset();
                btnStart.setText("START");
            }
        } if (gameC.getGameStatus() == 3) {
                gameC.setGameStatus(1);
                btnPause.setText("PAUSE");
            }
        else if (e.getSource() == btnPause) {
            if (gameC.getGameStatus() == 1) {
                gameC.setGameStatus(3);              
                btnPause.setText("RESUME");
            }
            
        } else if (e.getSource() == btnLeft) {
            gameC.moveLeft();
        } else if (e.getSource() == btnUp) {
            gameC.moveUp();
        } else if (e.getSource() == btnRight) {
            gameC.moveRight();
        } else if (e.getSource() == btnDown) {
            gameC.moveDown();
        }
    }

    public static void main(String args[]) {
        ZombieWorld pk = new ZombieWorld();
        pk.init();
    }
}
