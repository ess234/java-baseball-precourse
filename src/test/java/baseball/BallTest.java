package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallTest {
    @Test
    public void 볼_숫자_범위_초과(){
        assertThatThrownBy(() -> new Ball(10)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Ball(0)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 볼_숫자_입력(){
        Ball ball = new Ball(3);
        assertThat(ball.getNo()).isEqualTo(3);
    }
}
