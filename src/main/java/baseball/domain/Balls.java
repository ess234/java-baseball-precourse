package baseball.domain;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Balls {
    private List<Ball> balls;

    public Balls(List<Integer> ballNo) {
        this.balls = mapToBalls(ballNo);
    }

    private static List<Ball> mapToBalls(List<Integer> ballNo) {
        List<Ball> balls = new ArrayList<>();

        for (int i = 0; i < ballNo.size(); i++) {
            balls.add(new Ball(i + 1, ballNo.get(i)));
        }

        return balls;
    }


    public BallStatus play(Ball answerBall) {
        for (int i = 0; i < balls.size(); i++) {
            BallStatus ballStatus = balls.get(i).play(answerBall);

            if (!ballStatus.equals(BallStatus.NOTHING)) {
                return ballStatus;
            }
        }

        return BallStatus.NOTHING;
    }

    public BallResult play(Balls answerBalls) {
        BallResult ballResult = new BallResult();

        for (Ball ball : this.balls) {
            BallStatus ballStatus = answerBalls.play(ball);

            ballResult.report(ballStatus);
        }

        return ballResult;
    }
}
