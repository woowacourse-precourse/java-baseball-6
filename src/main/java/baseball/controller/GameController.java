package baseball.controller;

import baseball.model.NumberModel;
import baseball.view.GameView;
import java.util.List;

public class GameController {
    NumberModel numberModel = new NumberModel();
    GameView gameView = new GameView();
    public int startGame(List<Integer> randomNumbers) {
        numberModel.setComputerNumbers(randomNumbers);

        String userInput = gameView.inputUserNumber();


        return 0;
    }

}
