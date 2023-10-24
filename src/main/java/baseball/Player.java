package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {

    public List<Integer> makeGuess(String[] input) {
        List<Integer> guess = new ArrayList<>();
        for (String s : input) {
            guess.add(Integer.valueOf(s));
        }
        return guess;
    }
}
