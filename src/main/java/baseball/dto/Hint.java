package baseball.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Hint {
    int ball = 0;
    int strike = 0;

    @Override
    public String toString() {
        return "Hint{" +
                "ball=" + ball +
                ", strike=" + strike +
                '}';
    }
}
