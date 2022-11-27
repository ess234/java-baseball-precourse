package baseball.controller;

import baseball.service.GameService;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameController {
    private static int NUMS_SIZE = 3;

    GameService gameService = new GameService();

    public void startGame() {
        boolean isEnd = false;

        gameService.readGame(NUMS_SIZE);

        while (!isEnd){
            isEnd = gameService.startGame();
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
