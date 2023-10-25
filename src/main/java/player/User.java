package player;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class User implements Player {


    private List<Integer> baseballNumbers;

    private final int numberLength;
    private static final String SPLIT = "";


    public User(int numberLength) {
        this.numberLength = numberLength;
    }

    @Override
    public void inputBaseballNumbers() {
        List<Integer> inputNumbers = new ArrayList<>();

        String userInput = Console.readLine();

        NumberChecker numberChecker = new NumberChecker(numberLength);
        numberChecker.validateNumbers(userInput);

        for (String number : userInput.split(SPLIT)) {
            inputNumbers.add(Integer.parseInt(number));
        }

        this.baseballNumbers = inputNumbers;
    }

    @Override
    public List<Integer> getBaseballNumbers() {
        return this.baseballNumbers;
    }
}