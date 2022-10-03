package baseball.service;

import baseball.dto.Computer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GameServiceTest {
    int size = 3;
    GameService gameService = new GameService();

    @BeforeEach
    void setUp (){
        gameService.readGame(size);
    }

    @Test
    void readGame_테스트(){
        Computer computer = gameService.getComputer();
        Set<Integer> computerSet = new HashSet<>(computer.getNums());

        assertEquals(computerSet.size(), size);
    }

    @Test
    void startGame_3스트라이크_테스트(){
        Computer computer = gameService.getComputer();
        System.out.println("computer : "+computer.toString());

        String strComputer = computer.getNums().toString().replaceAll("[^0-9]","");

        String input = strComputer;
        System.out.println("input : "+input);

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        boolean actual = gameService.startGame();

        assertEquals(true, actual);
    }

    @Test
    void startGame_No_3스트라이크_테스트(){
        Computer computer = gameService.getComputer();
        System.out.println("computer : "+computer.toString());

        List<Integer> inputNum = new ArrayList<>();

        while (inputNum.size() < 3){
            int randomNum = pickNumberInRange(1,9);

            if ((!inputNum.contains(randomNum)) && (!computer.getNums().contains(randomNum))){
                inputNum.add(randomNum);
            }
        }

        String input = inputNum.toString().replaceAll("[^0-9]","");
        System.out.println("input : "+input);

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        boolean actual = gameService.startGame();

        assertEquals(false, actual);
    }
}