package baseball.controller;

import baseball.model.NumberModel;
import baseball.service.GameService;
import baseball.view.GameView;
import java.util.ArrayList;
import java.util.List;
import baseball.utils.ValidationUtil;

public class GameController {
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

        // String -> List<Integer> 형식 변환. TODO: 메소드 분리
        List<Integer> userNumbers = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++) {
            int convertedNum = Character.getNumericValue(userInput.charAt(i));
            userNumbers.add(convertedNum);
        }
        numberModel.setUserNumbers(userNumbers);
    }

    private boolean checkResult(List<Integer> result) {
        return result.get(0).equals(3);
    }

    private int askRestart() {
        String userInput = gameView.inputRestart();
        if (userInput.equals(GAME_RESTART_ANSWER)) {
            return 1;
        } else if (userInput.equals(GAME_END_ANSWER)) {
            return 2;
        }
        throw new IllegalArgumentException(WRONG_INPUT);
    }

}
