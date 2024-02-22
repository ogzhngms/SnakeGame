class Apple {
    private int x, y;
    private final int DOT_SIZE;

    public Apple(int dotSize) {
        this.DOT_SIZE = dotSize;
        locateApple();
    }

    public void locateApple() {
        int r = (int) (Math.random() * 29);
        x = (r * DOT_SIZE);
        r = (int) (Math.random() * 29);
        y = (r * DOT_SIZE);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
