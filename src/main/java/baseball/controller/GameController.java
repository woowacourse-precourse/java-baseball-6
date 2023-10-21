package baseball.controller;

import baseball.model.NumberModel;
import baseball.view.GameView;
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


        return 0;
    }

}
