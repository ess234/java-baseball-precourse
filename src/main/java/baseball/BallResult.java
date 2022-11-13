package baseball;

public class BallResult {
    int strike = 0;
    int ball = 0;

    public void report(BallStatus ballStatus) {
        if (BallStatus.STRIKE == ballStatus){
            strike += 1;
        }

        if (BallStatus.BALL == ballStatus){
            ball += 1;
        }
    }

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }
}
