package baseball.controller;

import baseball.constant.Validation;
import baseball.domain.Game;
import baseball.dto.ScoreDto;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {

    public void run() {
        OutputView.printIntro();
        do {
            playGame();
            OutputView.printContinue();
        } while (InputView.getIsGameContinue().equals(Validation.CONTINUE_GAME));
    }

    private void playGame() {
        Game game = new Game();

        while (true) {
            OutputView.printInput();
            List<Integer> inputs = InputView.getInputs();
            ScoreDto scoreDto = game.compareWithTarget(inputs);
            OutputView.printScore(scoreDto);

            if (scoreDto.getStrike() == Validation.NUMBER_LENGTH) {
                OutputView.printFinish();
                return;
            }
        }
    }
}
