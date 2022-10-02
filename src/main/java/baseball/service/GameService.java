package baseball.service;

import baseball.dto.Computer;
import baseball.dto.Player;
import lombok.Getter;

import static camp.nextstep.edu.missionutils.Console.readLine;

@Getter
public class GameService {
    Computer computer;
    Player player;

    int ball = 0;
    int strike = 0;

    public void readGame(int size) {
        computer = new Computer(size);
        player = new Player(size);

        computer.setRandomNums();
    }

    public boolean startGame(){
        System.out.println("숫자를 입력하세요 :  ");
        player.inputNum(readLine());

        String hint = getHint();
        System.out.println("hint : "+hint);

        return check3Strike();
    }

    private String getHint(){
        ball = 0;
        strike = 0;

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

    private boolean check3Strike(){
        if (3 == strike){
            return true;
        }

        return false;
    }

}
