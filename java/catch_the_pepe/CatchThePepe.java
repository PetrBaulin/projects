package catch_the_pepe;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class GameWindow extends JFrame {

    private static GameWindow game_window;
    private static long last_frame_time;
    private static Image background;
    private static Image game_over;
    private static Image pepe;
    private static Image fire;
    private static float pepe_left = 200;
    private static float pepe_top = -100;
    private static float pepe_v = 100;
    private static float fire_left = 0;
    private static float fire_v = 10;
    private static int score;

    public static void main(String[] args) throws IOException {
        background = ImageIO.read(GameWindow.class.getResourceAsStream("space.gif"));
        game_over = ImageIO.read(GameWindow.class.getResourceAsStream("game.png"));
        pepe = ImageIO.read(GameWindow.class.getResourceAsStream("pepe.png"));
        fire = ImageIO.read(GameWindow.class.getResourceAsStream("fire2.png"));
        game_window = new GameWindow();
        game_window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game_window.setLocation(285,175);
        game_window.setSize(900,470);
        game_window.setResizable(false);
        last_frame_time = System.nanoTime();
        GameField game_field = new GameField();
        game_field.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                float pepe_right = pepe_left + pepe.getWidth(null);
                float pepe_bottom = pepe_top + pepe.getHeight(null);
                boolean is_pepe = x >= pepe_left && x <= pepe_right && y >= pepe_top && y <= pepe_bottom;
                if (is_pepe) {
                    pepe_top = - 100;
                    pepe_left = (int) (Math.random() * (game_field.getWidth() - pepe.getWidth(null)));
                    pepe_v = pepe_v +25;
                    score ++;
                    game_window.setTitle("Pepes saved: " + score);
                }
            }
        });

        game_window.add(game_field);
        game_window.setVisible(true);
    }

    private static void onRepaint(Graphics g) {
        long current_time = System.nanoTime();
        float delta_time = (current_time - last_frame_time) * 0.000000001f;
        last_frame_time = current_time;

        pepe_top = pepe_top + pepe_v * delta_time;




        fire_left = fire_left - fire_v * delta_time;





        g.drawImage(background, 0, 0, null);
        g.drawImage(fire,(int) fire_left,350,null);
        g.drawImage(pepe, (int) pepe_left, (int) pepe_top, null);
        if (pepe_top > game_window.getHeight()) g.drawImage(game_over, 280, 120, null);

    }

    private static class GameField extends JPanel{

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            onRepaint(g);
            repaint();
        }
    }
}
