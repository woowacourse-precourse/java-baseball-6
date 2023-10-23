package baseball.controller;

import baseball.constants.GameStatus;
import baseball.dto.BaseballDto;
import baseball.dto.ReplayDto;
import baseball.model.Baseball;
import baseball.model.BaseballGameResult;
import baseball.service.BaseballService;
import baseball.view.BaseballView;

public class BaseballController {

    private final BaseballService baseballService;
    private final BaseballView baseballView;

    public BaseballController(BaseballService baseballService, BaseballView baseballView) {
        this.baseballService = baseballService;
        this.baseballView = baseballView;
    }

    public void run() {
        boolean play = true;
        while (play) {
            Baseball answer = createAnswer();
            playGame(answer);
            play = willReplay();
        }
    }

    private Baseball createAnswer() {
        return baseballService.createAnswerBaseball();
    }

    private void playGame(Baseball answer) {
        boolean isClear = false;

        while (!isClear) {
            baseballView.startGame();

            String numberInput = baseballView.inputNumber();
            BaseballDto baseballDto = new BaseballDto(numberInput);
            Baseball guess = baseballDto.toBaseball();

            BaseballGameResult result = baseballService.calculateResult(answer, guess);
            baseballView.showGameResult(result.getMessage());

            isClear = result.isClear();
        }
        baseballView.clearGame();
    }

    private boolean willReplay() {
        String replayInput = baseballView.replayGame();
        ReplayDto replayDto = new ReplayDto(replayInput);

        return replayDto.replay()
                .equals(GameStatus.REPLAY.getCode());
    }
}
