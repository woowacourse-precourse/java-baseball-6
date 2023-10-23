package baseball.controller;

import baseball.model.NumberModel;
import baseball.service.GameService;
import baseball.view.GameView;
import java.util.ArrayList;
import java.util.List;
import baseball.utils.ValidationUtil;

public class GameController {
    private static final int RESTART_STATUS = 1;
    private static final int EXIT_STATUS = 2;
    private static final String GAME_RESTART_ANSWER = "1";
    private static final String GAME_END_ANSWER = "2";
    private static final String WRONG_INPUT = "잘못 입력하셨습니다.";
    NumberModel numberModel = new NumberModel();
    GameView gameView = new GameView();
    ValidationUtil validationUtil = new ValidationUtil();
    GameService gameService;

    public int startGame(List<Integer> randomNumbers) {
        saveComputerNumbers(randomNumbers);
        gameService = new GameService(numberModel);

        List<Integer> result;
        boolean correct = false;
        while (!correct) {
            setAndSaveUserNumbers();
            result = gameService.compareNumbers();
            gameView.printHint(result);
            correct = checkResult(result);
        }

        gameView.printEndMessage();
        return askRestart();
    }

    private void saveComputerNumbers(List<Integer> randomNumbers) {
        numberModel.setComputerNumbers(randomNumbers);
    }

    private void setAndSaveUserNumbers() {
        String userInput = gameView.inputUserNumber();
        validationUtil.validate(userInput);
        numberModel.setUserNumbers(makeList(userInput));
    }

    private List<Integer> makeList(String userInput) {
        List<Integer> userNumbers = new ArrayList<>();
        for (char ch : userInput.toCharArray()) {
            userNumbers.add(Character.getNumericValue(ch));
        }
        return userNumbers;
    }

    private boolean checkResult(List<Integer> result) {
        return result.get(0).equals(3);
    }

    private int askRestart() {
        String userInput = gameView.inputRestart();
        if (userInput.equals(GAME_RESTART_ANSWER)) {
            return RESTART_STATUS;
        } else if (userInput.equals(GAME_END_ANSWER)) {
            return EXIT_STATUS;
        }
        throw new IllegalArgumentException(WRONG_INPUT);
    }

}
