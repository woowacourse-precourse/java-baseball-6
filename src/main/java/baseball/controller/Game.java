package baseball.controller;

import baseball.constant.GameResult;
import baseball.model.Computer;
import baseball.model.Numbers;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;
import java.util.Map;

public class Game {
    private final int GAME_OVER_CONDITION = 3;
    private final OutputView outputView;
    private final InputView inputView;
    private final Computer computer;


    public Game() {
        outputView = new OutputView();
        inputView = new InputView();
        computer = createComputer();
    }

    public void play(List<Integer> inputNumbers) {
        Numbers userNumbers = new Numbers(inputNumbers);
        Map<GameResult, Long> result = computer.compare(userNumbers);
        outputView.printGameResult(result);
        if (checkGameOver(result)) {
            outputView.printGameFinish();
            return;
        }
        play(inputView.inputNumbers());
    }


    private Computer createComputer() {
        List<Integer> numbers = Computer.createNumbers();
        return new Computer(numbers);
    }


    private boolean checkGameOver(Map<GameResult, Long> result) {
        return result.containsKey(GameResult.STRIKE)
                && result.get(GameResult.STRIKE) == GAME_OVER_CONDITION;
    }

}
