package baseball;

import java.util.Objects;

public class Ball {
    private int position;
    private int no;

    public Ball(int position, int no) {
        if (no < 1 || no > 9) {
            throw new IllegalArgumentException();
        }

        this.position = position;
        this.no = no;
    }

    public int getNo() {
        return this.no;
    }

    public BallStatus play(Ball answerBall) {
        if (this.equals(answerBall)){
            return BallStatus.STRIKE;
        }

        if (this.no == answerBall.getNo()){
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && no == ball.no;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, no);
    }
}
