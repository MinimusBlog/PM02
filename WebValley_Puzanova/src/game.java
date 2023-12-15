/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class game extends JFrame {
    private static game game;
    private static long lastFrameTime;
    private static Image fon;
    private static Image logo;
    private static Image end;
    private static float dropLeft = 200;
    private static float dropTop = -100;
    private static float dropV = 200;
    private static int score = 0;

    //Пузанова
    
    public static void main(String[] args) throws IOException {
        game = new game();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setLocation(200, 50);
        game.setSize(1200, 800);
        game.setResizable(false);

        lastFrameTime = System.nanoTime();

        gameField gameField = new gameField();
        game.add(gameField);

        try {
            fon = ImageIO.read(game.class.getResourceAsStream("fon.jpg"));
            logo = ImageIO.read(game.class.getResourceAsStream("logo.png"));
            end = ImageIO.read(game.class.getResourceAsStream("end.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        game.setVisible(true);
    }

    //Пузанова
    
    static class gameField extends JPanel {
        public gameField() {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    int x = e.getX();
                    int y = e.getY();
                    float dropRight = dropLeft + end.getWidth(null);
                    float dropBottom = dropTop + end.getHeight(null);
                    boolean isDrop = x >= dropLeft && x <= dropRight && y >= dropTop && y <= dropBottom;

                    if (isDrop) {
                        dropTop = -100;
                        dropLeft = (int) (Math.random() * (getWidth() - end.getWidth(null)));
                        dropV = dropV + 10;
                        score++;
                        game.setTitle("Score: " + score);
                    }
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            onRepaint(g);
            repaint();
        }
    }

    //Пузанова
    
    private static void onRepaint(Graphics g) {
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        lastFrameTime = currentTime;

        //Логика обновления позиции объектов
        dropTop += dropV * deltaTime;

        g.drawImage(fon, 0, 0, null);
        g.drawImage(logo, (int) dropLeft, (int) dropTop, null);
        if (dropTop > game.getHeight()) {
            g.drawImage(end, (int) dropLeft, (int) dropTop, null);
        }
    }
}


