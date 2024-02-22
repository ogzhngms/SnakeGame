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

    private final Snake snake;
    private Apple apple;

    boolean inGame = true;
    private Timer timer;

    public SnakeGame() {
        snake = new Snake(ALL_DOTS);
        apple = new Apple(DOT_SIZE);
        initBoard();
    }

    void initBoard() {
        setBackground(Color.black);
        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        initGame();
    }

    private void initGame() {
        int DELAY = 100;
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
            timer.stop();
        }

    private void checkApple() {
        if ((snake.getX(0) == apple.getX()) && (snake.getY(0) == apple.getY())) {
            snake.increaseLength();
            apple.locateApple();
        }
    }
    public void restartGame() {
        new Snake(ALL_DOTS);
        apple = new Apple(DOT_SIZE);
        inGame = true;
        timer.start();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            checkApple();
            inGame = !snake.checkCollision(WIDTH, HEIGHT);
            snake.move(DOT_SIZE);
        } else {
            timer.stop();
            snake.reset();
        }
        repaint();
    }

    public void setDirection(boolean left, boolean right, boolean up, boolean down) {
        snake.setDirection(left, right, up, down);
    }
}
