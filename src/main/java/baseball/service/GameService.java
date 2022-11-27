package baseball.service;

import baseball.domain.BallResult;
import baseball.domain.Balls;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameService {
    private static final int MIN_RANDOMNUM = 1;
    private static final int MAX_RANDOMNUM = 9;
    Balls computer;

    public void readGame(int numsSize) {
        computer = new Balls(this.setRandomNum(numsSize));
    }

    private List<Integer> setRandomNum(int numsSize) {
        List<Integer> randomNumList = new ArrayList<>();

        while (randomNumList.size() < numsSize) {
            int randomNum = Randoms.pickNumberInRange(MIN_RANDOMNUM, MAX_RANDOMNUM);

            if (randomNumList.contains(randomNum)) {
                continue;
            }

            randomNumList.add(randomNum);
        }

        return randomNumList;
    }

    public boolean startGame() {
        System.out.println("숫자를 입력하세요 :  ");
        List<Integer> inputNum = Arrays.stream(readLine().split(",")).map(Integer::parseInt).collect(Collectors.toList());

        Balls player = new Balls(inputNum);

        BallResult ballResult = player.play(computer);

        System.out.println(ballResult.getHint());

        return (ballResult.getStrike() == 3 ? true : false);
    }
}
