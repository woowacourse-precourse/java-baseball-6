package player;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User implements BaseballPlayer {
    
    private BaseballNumbers baseballNumbers;

    @Override
    public void inputBaseballNumbers() {
        List<BaseballNumber> userInputBaseballNumbers = new ArrayList<>();
        String[] userInput = splitStringToArray();

        for (String inputNumber : userInput) {
            BaseballNumber baseballNumber = new BaseballNumber(inputNumber);
            userInputBaseballNumbers.add(baseballNumber);
        }

        this.baseballNumbers = new BaseballNumbers(userInputBaseballNumbers);
    }

    @Override
    public List<BaseballNumber> getPlayerBaseballNumbers() {
        return baseballNumbers.getBaseballNumbers();
    }

    private String[] splitStringToArray() {
        String userInput = Console.readLine();
        return userInput.split("");
    }
}
