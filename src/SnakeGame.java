import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class SnakeGame extends JPanel implements ActionListener {
    private final int WIDTH = 500;
    private final int HEIGHT = 500;
    private final int DOT_SIZE = 10;
    private final int ALL_DOTS = 900;
    private final int DELAY = 100;

    private Snake snake;
    private Apple apple;

    boolean inGame = true;
    private Timer timer;

    public SnakeGame() {
        snake = new Snake(ALL_DOTS, DOT_SIZE);
        apple = new Apple(DOT_SIZE);
        initBoard();
    }

    private void initBoard() {
        setBackground(Color.black);
        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        initGame();
    }

    private void initGame() {
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (inGame) {
            g.setColor(Color.red);
            g.fillOval(apple.getX(), apple.getY(), DOT_SIZE, DOT_SIZE);

            for (int z = 0; z < snake.getLength(); z++) {
                if (z == 0) {
                    g.setColor(Color.green);
                } else {
                    g.setColor(Color.green);
                }
                g.fillRect(snake.getX(z), snake.getY(z), DOT_SIZE, DOT_SIZE);
            }

            Toolkit.getDefaultToolkit().sync();
        } else{
            gameOver(g);
        }
    }

        private void gameOver(Graphics g) {
            String msg = "Game Over";
            Font small = new Font("Helvetica", Font.BOLD, 14);
            FontMetrics metrics = getFontMetrics(small);

            g.setColor(Color.white);
            g.setFont(small);
            g.drawString(msg, (WIDTH - metrics.stringWidth(msg)) / 2, HEIGHT / 2);
        }

    private void checkApple() {
        if ((snake.getX(0) == apple.getX()) && (snake.getY(0) == apple.getY())) {
            snake.increaseLength();
            apple.locateApple();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            checkApple();
            snake.checkCollision(WIDTH, HEIGHT);
            snake.move(DOT_SIZE);
        }
        repaint();
    }

    public void setDirection(boolean left, boolean right, boolean up, boolean down) {
        snake.setDirection(left, right, up, down);
    }
}
