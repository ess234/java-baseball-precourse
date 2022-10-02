package baseball.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Player {
    int numsSize = 0;
    List<Integer> nums = new ArrayList<>();

    public Player(int size) {
        this.numsSize = size;
    }

    public void inputNum(String input) {
        nums.clear();

        if (numsSize != input.length()){
            throw new IllegalArgumentException("input length error (input length : "+input.length()+")");
        }

        for (int i = 0; i < input.length(); i++) {
            nums.add(checkValidation(String.valueOf(input.charAt(i))));
        }
    }

    private int checkValidation(String num) {
        int tempNum = 0;

        try {
            tempNum = Integer.parseInt(num);
        } catch (Exception e){
            throw new IllegalArgumentException("input num type error (input num : " + num + ")");
        }

        if (!(tempNum > 0 && tempNum < 10)) {
            throw new IllegalArgumentException("input 1 ~ 9 range error (input num : " + num + ")");
        }

        if (nums.contains(tempNum)){
            throw new IllegalArgumentException("input num duplicate error (input num : " + num + ")");
        }

        return tempNum;
    }

    @Override
    public String toString() {
        return "Player{" +
                "nums=" + nums +
                '}';
    }
}
