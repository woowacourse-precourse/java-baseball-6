package baseball;

import java.util.ArrayList;

public class Computer {
    private final ArrayList<Integer> nums;

    public Computer() {
        RandomNum randomNum = new RandomNum();
        nums = randomNum.getNums();
        System.out.println(nums);
    }

    public ArrayList<Integer> getNums() {
        return nums;
    }
}
