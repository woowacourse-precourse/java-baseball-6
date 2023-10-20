package baseball.controller;

import baseball.domain.GameNumber;
import baseball.domain.GuessResult;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberBaseBallController {

    static GameNumber pickComputerNumber() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return new GameNumber(computerNumbers);
    }

    static GuessResult createGuessResult(GameNumber computer, GameNumber user) {
        int ballCount = 0;
        int strikeCount = 0;
        List<Integer> userNumbers = user.numbers();
        List<Integer> computerNumbers = computer.numbers();

        for (int i = 0; i < 3; i++) {
            int userNumber = userNumbers.get(i);
            int computerNumber = computerNumbers.get(i);

            if (userNumber == computerNumber) {
                strikeCount++;
                continue;
            }

            if (computerNumbers.contains(userNumber)) {
                ballCount++;
            }
        }

        return new GuessResult(ballCount, strikeCount);
    }

    static void play() {
        GameNumber computer = pickComputerNumber();
        boolean isGameProceed = true;
        while (isGameProceed) {
            GameNumber user = InputView.readUserNumber();
            GuessResult guessResult = createGuessResult(computer, user);
            OutputView.printGuessResult(guessResult);
            if (guessResult.isAllStrike()) {
                isGameProceed = false;
            }
        }
        OutputView.printEndMessage();
    }

    public void startGame() {
        OutputView.printStartMessage();
        boolean shouldPlay = true;
        while (shouldPlay) {
            play();
            shouldPlay = InputView.readShouldReplay();
        }
    }

}
