package baseball.model;

import baseball.util.CalculationResult;
import baseball.util.GameInputValid;
import java.util.ArrayList;
import java.util.List;

public class GameModel {

    private Computer computer;
    private GameInputValid gameInputValid;

    public GameModel(GameInputValid gameInputValid) {
        computer = new Computer();
        computer.generateRandomNumber();
        this.gameInputValid = gameInputValid;
    }

    public void validateUserInput(String input) throws IllegalArgumentException {
        gameInputValid.inputValid(input);
    }

    private List<Integer> getUserNumber(String input) {
        List<Integer> userNumberList = new ArrayList<>();
        for (char c : input.toCharArray()) {
            int digit = Character.getNumericValue(c);
            userNumberList.add(digit);
        }
        return userNumberList;
    }

    public CalculationResult checkGameResult(String input) {
        List<Integer> comNumberList = computer.getRandomNumberList();
        List<Integer> userNumberList = getUserNumber(input);

        CalculationResult result = new CalculationResult();
        result.calStrikeAndBall(comNumberList, userNumberList);

        return result;
    }

}
