package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {

    Validator validator = new Validator();

    public List<Integer> makeGuess(String[] input) {
        List<Integer> guess = new ArrayList<>();
        validator.validateGuess(input);
        for (String s : input) {
            guess.add(Integer.valueOf(s));
        }
        return guess;
    }
}
