package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by huynq on 7/9/17.
 */
public class GameWindow extends JFrame {

    private BufferedImage background;
    private BufferedImage player;
    private int playerX;

    BufferedImage backBufferImage;
    Graphics2D backBufferGraphics2D;

    public GameWindow() {
        setupWindow();
        loadImages();

        playerX = background.getWidth() / 2;

        backBufferImage = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
        backBufferGraphics2D = (Graphics2D) backBufferImage.getGraphics();

        setupInputs();
        this.setVisible(true);
    }

    private void setupInputs() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_RIGHT:
                        playerX += 5;
                        repaint();
                        break;

                    default:
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    public void run() {
        while(true) {
            try {
                Thread.sleep(17);

                backBufferGraphics2D.setColor(Color.BLACK);
                backBufferGraphics2D.fillRect(0, 0, this.getWidth(), this.getHeight());

                backBufferGraphics2D.drawImage(background, 0, this.getHeight() - background.getHeight(), null);

                backBufferGraphics2D.drawImage(player, playerX, this.getHeight() - player.getHeight(), null);

                Graphics2D g2d = (Graphics2D)this.getGraphics();

                g2d.drawImage(backBufferImage, 0, 0, null);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void loadImages() {
        try {
            background = ImageIO.read(new File("assets/images/background/0.png"));
            player = ImageIO.read(new File("assets/images/players/straight/0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setupWindow() {
        this.setSize(600, 600);
        this.setResizable(false);
        this.setTitle("Touhou - Remade by QHuyDTVT");

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
//                super.windowClosing(e);
            }
        });
    }
}
