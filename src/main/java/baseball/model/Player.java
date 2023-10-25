package baseball.model;

import baseball.controller.Validator;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> nums;

    public void initNums(String init) {
        nums = new ArrayList<>();
        String[] split = init.split("");
        Validator.checkInitNums(split);
        for (int i = 0; i < 3; i++)
            nums.add(Integer.parseInt(split[i]));
    }

    public List<Integer> getNums() {
        return this.nums;
    }
}
