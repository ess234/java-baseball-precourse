package baseball.domain;

import baseball.domain.Ball;
import baseball.domain.BallResult;
import baseball.domain.BallStatus;
import baseball.domain.Balls;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    @Test
    void 낫싱() {
        Balls balls = new Balls(Arrays.asList(4,5,6));
        BallStatus ballStatus = balls.play(new Ball(1,7));
        assertThat(ballStatus).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void 볼() {
        Balls balls = new Balls(Arrays.asList(4,5,6));
        BallStatus ballStatus = balls.play(new Ball(2,4));
        assertThat(ballStatus).isEqualTo(BallStatus.BALL);
    }

    @Test
    void 스트라이크() {
        Balls balls = new Balls(Arrays.asList(4,5,6));
        BallStatus ballStatus = balls.play(new Ball(1,4));
        assertThat(ballStatus).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void BallResult_낫싱() {
        Balls computerBalls = new Balls(Arrays.asList(4,5,6));
        BallResult ballResult = computerBalls.play(new Balls(Arrays.asList(1,2,3)));
        assertThat(ballResult.getStrike()).isEqualTo(0);
        assertThat(ballResult.getBall()).isEqualTo(0);
    }

    @Test
    void BallResult_1스크라이크_1볼() {
        Balls computerBalls = new Balls(Arrays.asList(4,5,6));
        BallResult ballResult = computerBalls.play(new Balls(Arrays.asList(4,6,7)));
        assertThat(ballResult.getStrike()).isEqualTo(1);
        assertThat(ballResult.getBall()).isEqualTo(1);
    }

    @Test
    void BallResult_3스크라이크() {
        Balls computerBalls = new Balls(Arrays.asList(4,5,6));
        BallResult ballResult = computerBalls.play(new Balls(Arrays.asList(4,5,6)));
        assertThat(ballResult.getStrike()).isEqualTo(3);
        assertThat(ballResult.getBall()).isEqualTo(0);
    }
}
