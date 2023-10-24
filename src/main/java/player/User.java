package player;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User implements BaseballPlayer {

    private BaseballNumbers baseballNumbers;

    @Override
    public void inputBaseballNumbers() {
        List<Integer> userInputBaseballNumbers = new ArrayList<>();
        String[] userInput = splitStringToArray();

        for (String inputNumber : userInput) {
            userInputBaseballNumbers.add(Integer.parseInt(inputNumber));
        }

        this.baseballNumbers = new BaseballNumbers(userInputBaseballNumbers);
    }

    @Override
    public List<Integer> getBaseballNumbers() {
        return baseballNumbers.getBaseballNumbers();
    }

    private String[] splitStringToArray() {
        String userInput = Console.readLine();
        return userInput.split("");
    }
}
