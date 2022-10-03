package baseball.service;

import baseball.dto.Computer;
import baseball.dto.Player;
import lombok.Getter;

import static camp.nextstep.edu.missionutils.Console.readLine;

@Getter
public class GameService {
    Computer computer;
    Player player;
    HintService hintService = new HintService();

    public void readGame(int size) {
        computer = new Computer(size);
        player = new Player(size);

        computer.setRandomNums();
    }

    public boolean startGame(){
        System.out.println("숫자를 입력하세요 :  ");
        player.inputNum(readLine());

        String hint = hintService.getHint(computer, player);
        System.out.println(hint);

        return hintService.check3Strike(hint);
    }

}
