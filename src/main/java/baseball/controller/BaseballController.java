package baseball.controller;

import baseball.constants.GameStatus;
import baseball.dto.input.BaseballDto;
import baseball.dto.input.ReplayDto;
import baseball.dto.output.ResultMessageDto;
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
        outputView.startGame();

        boolean play = true;
        while (play) {
            playGame();
            play = askReplayChoice();
        }
    }

    private void playGame() {
        Baseball answer = baseballService.createAnswerBaseball();

        boolean isClear = false;
        while (!isClear) {
            Baseball guess = getGuessBaseball();
            BaseballGameResult result = baseballService.calculateResult(answer, guess);
            showGameResult(result);
            isClear = result.isClear();
        }

        outputView.clearGame();
    }

    private Baseball getGuessBaseball() {
        BaseballDto baseballDto = inputView.inputNumber();
        return baseballDto.toBaseball();
    }

    private void showGameResult(BaseballGameResult result) {
        ResultMessageDto resultMessageDto = new ResultMessageDto(result);
        outputView.showGameResult(resultMessageDto);
    }

    private boolean askReplayChoice() {
        ReplayDto replayDto = inputView.replayGame();
        GameStatus gameStatus = GameStatus.from(replayDto.replay());

        return gameStatus.equals(GameStatus.REPLAY);
    }
}
