package baseball.controller;

import baseball.dto.Computer;
import baseball.dto.Player;
import baseball.service.ScoreService;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameController {
    private static int NUMS_SIZE = 3;

    Computer computer;
    Player player;

    private void readGame() {
        computer = new Computer(NUMS_SIZE);
        player = new Player(NUMS_SIZE);

        computer.setRandomNums();

        System.out.println(computer);
    }

    public void startGame() {
        readGame();

        boolean isEnd = false;

        while (!isEnd){
            System.out.println("숫자를 입력하세요 :  ");
            player.inputNum(readLine());

            ScoreService scoreService = ScoreService.builder().computer(computer).player(player).build();

            String hint = scoreService.getHint();
            System.out.println("hint : "+hint);

            isEnd = scoreService.check3Strike();
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        if (isRestart()){
            startGame();
        }
    }

    private boolean isRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String result = readLine();

        if ("1".equals(result)) {
            return true;
        }

        return false;
    }
}
