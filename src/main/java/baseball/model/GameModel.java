package baseball.model;

import baseball.util.CalculationResult;
import baseball.util.GameChoiceInputValid;
import baseball.util.GameInputValid;
import java.util.ArrayList;
import java.util.List;

public class GameModel {

    private Computer computer;
    private GameInputValid gameInputValid;
    private GameChoiceInputValid gameChoiceInputValid;


    public GameModel(GameInputValid gameInputValid, GameChoiceInputValid gameChoiceInputValid) {
        computer = new Computer();
        computer.generateRandomNumber();
        this.gameInputValid = gameInputValid;
        this.gameChoiceInputValid = gameChoiceInputValid;
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

    public void validateUserChoice(String input) throws IllegalArgumentException {
        gameChoiceInputValid.inputValid(input);
    }

    public void reset() {
        computer.generateRandomNumber();
    }

}
