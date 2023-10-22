package baseball.game;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;

public class Numbers {
    private List<Integer> numbers;

    public Numbers() {
        RandomNumbersGenerator generator = new RandomNumbersGenerator();
        this.numbers = generator.generateRandomNumber();
    }

    public List<Integer> transformStrToInt(String userInput) {
        ArrayList<Integer> transformNumbers = new ArrayList<>();
        for (char number : userInput.toCharArray()) {
            transformNumbers.add(Character.getNumericValue(number));
        }
        return transformNumbers;
    }

    private String getInputStr() {
        return readLine();
    }
}
