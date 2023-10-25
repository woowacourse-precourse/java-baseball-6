package baseball.controller;

import baseball.domain.GameResult;
import service.BaseBallService;
import baseball.view.UserInputView;
import baseball.view.UserOutputView;

public class BaseBallController {
    private static final int END_COUNT = 3;
    private UserInputView userInputView;
    private UserOutputView userOutputView;
    private BaseBallService baseBallService;

    public void gameStart() {
        this.baseBallService = new BaseBallService();
        String restartNumber;
        do {
            UserOutputView.startGame();
            play();
            userOutputView.finishGame();
            restartNumber = userInputView.reStartMessage();
        } while (baseBallService.reStart(restartNumber));
    }

    private void play() {
            GameResult result;
            baseBallService.reStartGame();
            do {
                String input = userInputView.startMessage();
                result = baseBallService.compareNumber(input);
                new UserOutputView(result).printDescription();
            } while (result.strikeCount != END_COUNT);
    }
}
