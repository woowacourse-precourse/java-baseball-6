package baseball.controller;

import baseball.domain.GameResult;
import baseball.view.UserInputView;
import baseball.view.UserOutputView;
import service.BaseBallService;
public class BaseBallController {
    private static final int endCount = 3;
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
            } while (result.strikeCount != endCount);
    }
}
