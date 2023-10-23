package baseball.controller;

import baseball.constant.GameResult;
import baseball.model.Computer;
import baseball.model.GameNumber;
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
        computer = generateComputer();
    }

    public void play(List<Integer> userNumbers) {
        GameNumber userGameNumber = new GameNumber(userNumbers);
        Map<GameResult, Long> result = computer.compare(userGameNumber);
        outputView.printGameResult(result);
        if (!checkGameOver(result)) {
            play(inputView.inputGameNumbers());
            return ;
        }
        outputView.printGameFinish();
    }


    private Computer generateComputer() {
        List<Integer> computerNumber = Computer.createNumbers();
        return new Computer(computerNumber);
    }


    private boolean checkGameOver(Map<GameResult, Long> result) {
        if (result.containsKey(GameResult.STRIKE)
                && result.get(GameResult.STRIKE) == GAME_OVER_CONDITION) {
            return true;
        }
        return false;
    }

}
