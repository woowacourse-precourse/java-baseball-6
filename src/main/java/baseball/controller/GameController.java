package baseball.controller;

import baseball.model.NumberModel;
import java.util.List;

public class GameController {
    NumberModel numberModel = new NumberModel();
    public int startGame(List<Integer> randomNumbers) {
        numberModel.setComputerNumbers(randomNumbers);

        System.out.println(numberModel.getComputerNumbers());
        return 0;
    }

}
