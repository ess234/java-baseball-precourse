package baseball.service;

import baseball.dto.Computer;
import baseball.dto.Hint;
import baseball.dto.Player;

public class HintService {
    Hint hint = new Hint();

    public String getHint(Computer computer, Player player){
        hint.setBall(0);
        hint.setStrike(0);

        for (int i = 0; i < computer.getNums().size(); i++) {
            int checkNum = computer.getNums().get(i);

            checkBall(i, checkNum, player);
            checkStrike(i, checkNum, player);
        }

        return getResultString();
    }

    private void checkBall(int checkIndex, int checkNum, Player player){
        if (player.getNums().contains(checkNum) && checkIndex != player.getNums().indexOf(checkNum)){
            hint.setBall(hint.getBall()+1);
        }
    }

    private void checkStrike(int checkIndex, int checkNum, Player player){
        if (checkNum == player.getNums().get(checkIndex)){
            hint.setStrike(hint.getStrike()+1);
        }
    }

    private String getResultString(){
        String result = "";

        if (hint.getBall() <= 0 && hint.getStrike() <= 0){
            return "낫싱";
        }

        if (hint.getBall() > 0){
            result += hint.getBall() + "볼 ";
        }

        if (hint.getStrike() > 0){
            result += hint.getStrike() + "스트라이크 ";
        }

        return result;
    }

    public boolean check3Strike(String hint){
        int cnt = 0;

        int index = hint.indexOf("스트라이크");

        if (index > 0) {
            cnt = Integer.parseInt(hint.substring(index - 1, index));
        }

        if (3 == cnt){
            return true;
        }

        return false;
    }
}
