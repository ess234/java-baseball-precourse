package baseball.service;

import baseball.dto.Computer;
import baseball.dto.Player;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ScoreService {
    Computer computer;
    Player player;

    int ball = 0;
    int strike = 0;

    public String getHint(){
        for (int i = 0; i < computer.getNums().size(); i++) {
            int checkNum = computer.getNums().get(i);

            checkBall(i, checkNum);
            checkStrike(i, checkNum);
        }

        return getResultString();
    }

    private void checkBall(int checkIndex, int checkNum){
        if (player.getNums().contains(checkNum) && checkIndex != player.getNums().indexOf(checkNum)){
            ball++;
        }
    }

    private void checkStrike(int checkIndex, int checkNum){
        if (checkNum == player.getNums().get(checkIndex)){
            strike++;
        }
    }

    private String getResultString(){
        String result = "";

        if (ball <= 0 && strike <= 0){
            return "낫싱";
        }

        if (ball > 0){
            result += ball + "볼 ";
        }

        if (strike > 0){
            result += strike + "스트라이크 ";
        }

        return result;
    }

    public boolean check3Strike(){
        if (3 == strike){
            return true;
        }

        return false;
    }

}
