package baseball;

import java.util.ArrayList;

public class Player {
    private ArrayList<Integer> nums = new ArrayList<>();

    public Player() {
        RandomNum randomNum = new RandomNum();
        nums = randomNum.getNums();
    }
}
