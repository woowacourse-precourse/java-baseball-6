package baseball.controller;

import baseball.model.BaseBallGame;
import baseball.model.TryAgain;
import baseball.model.Computer;
import baseball.valid.InputValidator;
import baseball.view.ConsoleView;

import java.util.List;

public class BaseBallGameController {
    private final ConsoleView consoleView;
    private final BaseBallGame baseBallGame;
    private Computer computer = new Computer();
    private final InputValidator validator;
    private final TryAgain tryAgain;

    public BaseBallGameController(ConsoleView consoleView, BaseBallGame baseBallGame, InputValidator validator, TryAgain tryAgain) {
        this.consoleView = consoleView;
        this.baseBallGame = baseBallGame;
        this.validator = validator;
        this.tryAgain = tryAgain;
    }

    public void startGame() {
        consoleView.printGameStart();
        List<Integer> computerNum = computer.makeRandomNumbers();
        while(tryAgain.getIsStatus()){
            String userNum = consoleView.getUserInput();
            List<Integer> userNumList = checkUserNum(userNum);

            int[] result = baseBallGame.ismatch(computerNum, userNumList);
            if (result[1] == 3) {
                consoleView.printGameEnd();
                userNum = consoleView.printAskAgain();
                checkAgainInput(userNum);

                if (tryAgain.reStart(userNum)) {
                    computerNum = computer.makeRandomNumbers();
                }
                continue;
            }
            consoleView.printResult(result);
        }
    }

    private List<Integer> checkUserNum(String userNum) {
        validator.isMatch3Size(userNum);
        validator.isMatchNumber(userNum);
        validator.isDifferentNum(userNum);

        return userNum.chars()
                .map(Character::getNumericValue)
                .boxed()
                .toList();
    }

    private void checkAgainInput(String userNum) {
        validator.isMatch1Size(userNum);
        validator.isMatchAgainNumber(userNum);
    }
}
