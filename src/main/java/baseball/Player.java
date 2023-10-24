package baseball;

import java.util.ArrayList;

public class Player {
    private ArrayList<Integer> nums = new ArrayList<>();
    private ArrayList<Integer> guessNums = new ArrayList<>();

    public Player() {
        RandomNum randomNum = new RandomNum();
        nums = randomNum.getNums();
        System.out.println("nums: " + nums);
    }

    public ArrayList<Integer> getNums() {
        return nums;
    }

    public void setGuessNums(ArrayList<Integer> guessNums) {
        this.guessNums = guessNums;
    }

    public ArrayList<Integer> getGuessNums() {
        return guessNums;
    }
}
