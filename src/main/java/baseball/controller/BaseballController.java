package baseball.controller;

import baseball.constants.GameStatus;
import baseball.dto.BaseballDto;
import baseball.dto.ReplayDto;
import baseball.model.Baseball;
import baseball.model.BaseballGameResult;
import baseball.service.BaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BaseballService baseballService;

    public BaseballController(InputView inputView, OutputView outputView, BaseballService baseballService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.baseballService = baseballService;
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
            outputView.startGame();
            BaseballGameResult result = guessAnswer(answer);
            isClear = result.isClear();
        }
        outputView.clearGame();
    }

    private BaseballGameResult guessAnswer(Baseball answer) {
        BaseballDto baseballDto = inputView.inputNumber();

        BaseballGameResult result = baseballService.calculateResult(answer, baseballDto.toBaseball());
        outputView.showGameResult(result.getMessage());

        return result;
    }

    private boolean willReplay() {
        ReplayDto replayDto = inputView.replayGame();
        GameStatus gameStatus = GameStatus.from(replayDto.replay());

        return gameStatus.equals(GameStatus.REPLAY);
    }
}
