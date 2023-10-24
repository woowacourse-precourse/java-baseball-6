package player;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User implements BaseballPlayer {

    private static final String ONLY_NUMBER = "숫자만 입력 가능합니다.";
    private BaseballNumbers baseballNumbers;

    @Override
    public void inputBaseballNumbers() {
        List<Integer> userInputBaseballNumbers = new ArrayList<>();
        String[] userInput = splitStringToArray();

        for (String inputNumber : userInput) {
            validateIsNumeric(inputNumber);
            userInputBaseballNumbers.add(Integer.parseInt(inputNumber));
        }

        this.baseballNumbers = new BaseballNumbers(userInputBaseballNumbers);
    }

    @Override
    public List<Integer> getBaseballNumbers() {
        return baseballNumbers.getBaseballNumbers();
    }

    private void validateIsNumeric(String baseballNumber) {
        try {
            Integer.parseInt(baseballNumber);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ONLY_NUMBER);
        }
    }

    private String[] splitStringToArray() {
        String userInput = Console.readLine();
        return userInput.split("");
    }
}
