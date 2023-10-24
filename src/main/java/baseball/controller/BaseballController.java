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
        boolean play = true;
        outputView.startGame();
        while (play) {
            Baseball answer = createAnswer();
            playGame(answer);
            play = willReplay();
        }
    }

    private Baseball createAnswer() {
        return baseballService.createAnswerBaseball();
    }

    private void playGame(final Baseball answer) {
        boolean isClear = false;
        while (!isClear) {
            isClear = guessAnswer(answer);
        }
        outputView.clearGame();
    }

    private boolean guessAnswer(final Baseball answer) {
        BaseballDto baseballDto = inputView.inputNumber();
        Baseball baseball = baseballDto.toBaseball();

        BaseballGameResult result = baseballService.calculateResult(answer, baseball);
        ResultMessageDto resultMessageDto = new ResultMessageDto(result);
        outputView.showGameResult(resultMessageDto.toMessage());

        return result.isClear();
    }

    private boolean willReplay() {
        ReplayDto replayDto = inputView.replayGame();
        GameStatus gameStatus = GameStatus.from(replayDto.replay());

        return gameStatus.equals(GameStatus.REPLAY);
    }
}
