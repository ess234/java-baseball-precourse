package baseball;

public class Ball {
    private int no;

    public Ball(int no) {
        if (no < 1 || no > 9) {
            throw new IllegalArgumentException();
        }
        this.no = no;
    }

    public int getNo() {
        return this.no;
    }
}
