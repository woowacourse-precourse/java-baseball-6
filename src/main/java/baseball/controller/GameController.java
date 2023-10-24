package baseball.controller;

import baseball.model.BaseballNumber;
import baseball.service.NumbersGenerator;

import java.util.List;

public class GameController extends Controller {
    private final NumbersGenerator generator = new NumbersGenerator();

    public void startGame() {
        outputView.printStartGame();
        do {
            BaseballNumber defenseNumbers = makeDefenseNumber();
            playGame(defenseNumbers);
        } while (continueGame());
    }

    public BaseballNumber makeDefenseNumber() {
        List<Integer> generateNumbers = generator.makeNumbers();
        return BaseballNumber.create(generateNumbers);
    }


    private void playGame(BaseballNumber defenseNumbers) {

    }

    public boolean continueGame() {
        return true;
    }
}
