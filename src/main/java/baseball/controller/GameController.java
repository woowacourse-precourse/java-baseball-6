package baseball.controller;

import baseball.model.BaseballNumber;
import baseball.model.Decision;
import baseball.service.NumbersGenerator;

import java.util.List;

public class GameController extends Controller {
    private final NumbersGenerator generator = new NumbersGenerator();
    private final Decision decision = new Decision();

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


    private void playGame(BaseballNumber defenseNumber) {
        while(true) {
            BaseballNumber offenseNumber = makeOffenseNumber();
            String judgement = decision.decide(offenseNumber, defenseNumber);
        }
    }

    private BaseballNumber makeOffenseNumber() {
        outputView.printInputNumber();
        List<Integer> inputNumbers = inputView.inputBallNumbers();
        return BaseballNumber.create(inputNumbers);
    }

    public boolean continueGame() {
        return true;
    }
}
