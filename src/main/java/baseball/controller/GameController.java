package baseball.controller;

import baseball.model.NumberModel;
import baseball.view.GameView;
import java.util.ArrayList;
import java.util.List;
import baseball.utils.ValidationUtil;

public class GameController {
    NumberModel numberModel = new NumberModel();
    GameView gameView = new GameView();
    ValidationUtil validationUtil = new ValidationUtil();

    public int startGame(List<Integer> randomNumbers) {
        numberModel.setComputerNumbers(randomNumbers);

        String userInput = gameView.inputUserNumber();
        validationUtil.validate(userInput);

        // String -> List<Integer> 형식 변환. TODO: 메소드 분리
        List <Integer> userNumbers = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++) {
            int convertedNum = Character.getNumericValue(userInput.charAt(i));
            userNumbers.add(convertedNum);
        }
        numberModel.setUserNumbers(userNumbers);


        return askRestart();
    }

    public int askRestart() {
        String userInput = gameView.inputRestart();
        if (userInput.equals("1")) {
            return 1;
        } else if (userInput.equals("2")) {
            return 2;
        }
        throw new IllegalArgumentException("잘못 입력하셨습니다.");
    }

}
