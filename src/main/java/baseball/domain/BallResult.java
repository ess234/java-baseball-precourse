package baseball.domain;

public class BallResult {
    int strike = 0;
    int ball = 0;

    public void report(BallStatus ballStatus) {
        if (BallStatus.STRIKE == ballStatus){
            this.strike += 1;
        }

        if (BallStatus.BALL == ballStatus){
            this.ball += 1;
        }
    }

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    public String getHint(){
        String ballHint = (this.getBall() > 0 ? this.getBall()+"볼 " : "");
        String strikeHint = (this.getStrike() > 0 ? this.getStrike()+"스트라이크 " : "");

        return ballHint + strikeHint;
    }
}
