package baseball.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

@Getter
@Setter
public class Computer {
    int numsSize = 0;
    List<Integer> nums = new ArrayList<>();

    public Computer(int size) {
        this.numsSize = size;
    }

    public List<Integer> setRandomNums(){
        while (nums.size() < numsSize){
            addNum(pickNumberInRange(1,9));
        }

        return nums;
    }

    private void addNum(int num){
        if (nums.contains(num)){
            return;
        }

        nums.add(num);
    }

    @Override
    public String toString() {
        return "Computer{" +
                "nums=" + nums +
                '}';
    }
}
