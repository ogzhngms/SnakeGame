import javax.swing.JFrame;
import java.awt.EventQueue;


public class main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame("Simple Snake Game");
            SnakeGame snakeGame = new SnakeGame();
            frame.add(snakeGame);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            snakeGame.addKeyListener(new GameControl(snakeGame));
            snakeGame.requestFocusInWindow();
        });
    }
}
