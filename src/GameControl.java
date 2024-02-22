import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameControl extends KeyAdapter {

    private final SnakeGame snakeGame;

    public GameControl(SnakeGame snakeGame) {
        this.snakeGame = snakeGame;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        boolean inGame = false;
        if (!inGame && key == KeyEvent.VK_SPACE) {
            snakeGame.restartGame();
        }

        switch (key) {
            case KeyEvent.VK_LEFT:
                snakeGame.setDirection(true, false, false, false);
                break;
            case KeyEvent.VK_RIGHT:
                snakeGame.setDirection(false, true, false, false);
                break;
            case KeyEvent.VK_UP:
                snakeGame.setDirection(false, false, true, false);
                break;
            case KeyEvent.VK_DOWN:
                snakeGame.setDirection(false, false, false, true);
                break;
        }
    }
}