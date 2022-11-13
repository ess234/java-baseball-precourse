package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallTest {
    @Test
    public void 볼_숫자_범위_초과(){
        assertThatThrownBy(() -> new Ball(1, 10)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Ball(1, 0)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 볼_숫자_입력(){
        Ball ball = new Ball(1, 3);
        assertThat(ball.getNo()).isEqualTo(3);
    }

    @Test
    public void 볼_낫싱(){
        Ball ball = new Ball(1, 4);
        assertThat(ball.play(new Ball(1,5))).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    public void 볼_볼(){
        Ball ball = new Ball(1, 4);
        assertThat(ball.play(new Ball(2,4))).isEqualTo(BallStatus.BALL);
    }

    @Test
    public void 볼_스크라이크(){
        Ball ball = new Ball(1, 4);
        assertThat(ball.play(new Ball(1,4))).isEqualTo(BallStatus.STRIKE);
    }
}
