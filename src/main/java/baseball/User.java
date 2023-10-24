package baseball;

import java.util.ArrayList;

public class User {
    private ArrayList<Integer> guessNums = new ArrayList<>();

    public User() {
    }

    public void setGuessNums(ArrayList<Integer> guessNums) {
        this.guessNums = guessNums;
    }

    public ArrayList<Integer> getGuessNums() {
        return guessNums;
    }
}
