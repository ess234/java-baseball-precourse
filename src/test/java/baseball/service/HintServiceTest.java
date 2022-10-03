package baseball.service;

import baseball.dto.Computer;
import baseball.dto.Player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HintServiceTest {
    static int SIZE = 3;
    Computer computer = new Computer(SIZE);

    HintService hintService = new HintService();

    @BeforeEach
    void setUp (){
        List<Integer> computerNums = new ArrayList<>();
        computerNums.add(1);
        computerNums.add(2);
        computerNums.add(3);

        computer.setNums(computerNums);
    }

    @ParameterizedTest
    @CsvSource(value = {"123:3스트라이크", "124:2스트라이크", "145:1스트라이크", "451:1볼","431:2볼","231:3볼", "132:2볼 1스트라이크","324:1볼 1스트라이크","456:낫싱"}, delimiter = ':')
    void getHint_테스트(String input, String expected) {
        List<Integer> playerNums = new ArrayList<>();

        for(char temp : input.toCharArray()){
            playerNums.add(Integer.parseInt(String.valueOf(temp)));
        }

        Player player = new Player(SIZE);
        player.setNums(playerNums);

        String hint = hintService.getHint(computer, player);
        assertEquals(expected, hint.trim());
    }

    @ParameterizedTest
    @CsvSource(value = {"3스트라이크:true", "1볼2스트라이크:false"}, delimiter = ':')
    void check3Strike(String input, boolean expected) {
        boolean result = hintService.check3Strike(input);

        assertEquals(expected, result);
    }
}