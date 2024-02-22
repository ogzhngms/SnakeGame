class Snake {
    private final int[] x;
    private final int[] y;
    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private int dots;
    
    public Snake(int allDots) {
        x = new int[allDots];
        y = new int[allDots];
        dots = 3;
        for (int z = 0; z < dots; z++) {
            x[z] = 50 - z * 10;
            y[z] = 50;
        }
    }

    public void move(int DOT_SIZE) {
        for (int z = dots; z > 0; z--) {
            x[z] = x[z - 1];
            y[z] = y[z - 1];
        }
        if (leftDirection) {
            x[0] -= DOT_SIZE;
        }
        if (rightDirection) {
            x[0] += DOT_SIZE;
        }
        if (upDirection) {
            y[0] -= DOT_SIZE;
        }
        if (downDirection) {
            y[0] += DOT_SIZE;
        }
    }


    public boolean checkCollision(int width, int height) {
        if (x[0] < 0 || x[0] >= width || y[0] < 0 || y[0] >= height) {
            return true;
        }

        for (int z = getLength(); z > 0; z--) {
            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                return true;
            }
        }
        return false;
    }
    public void reset() {
        dots = 3;
        leftDirection = false;
        rightDirection = true;
        upDirection = false;
        downDirection = false;


        for (int z = 0; z < dots; z++) {
            x[z] = 50 - z * 10;
            y[z] = 50;
        }


        for (int z = dots; z < dots; z++) {
            x[z] = 0;
            y[z] = 0;
        }
    }

    public void setDirection(boolean left, boolean right, boolean up, boolean down) {
        leftDirection = left;
        rightDirection = right;
        upDirection = up;
        downDirection = down;
    }

    public int getX(int index) {
        return x[index];
    }

    public int getY(int index) {
        return y[index];
    }

    public int getLength() {
        return dots;
    }

    public void increaseLength() {
        dots++;
    }

}
