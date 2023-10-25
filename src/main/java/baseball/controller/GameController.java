package baseball.controller;

import baseball.domain.player.dto.PlayerNumbersDto;
import baseball.domain.player.dto.RetryNumberDto;
import baseball.global.view.input.InputView;
import baseball.global.view.output.OutputView;
import baseball.service.GameService;

import static baseball.global.message.BallMessage.STRIKE;
import static baseball.global.utils.NumberDefinition.DIGIT_CNT;

public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void run() {
        boolean retry;
        do {
            init();
            start();
            play();
            end();
            retry = gameService.askRetry(RetryNumberDto.of(InputView.input()));
        } while (retry);
    }


    public void start() {
        OutputView.printStartMessage();
    }

    public void init() {
        gameService.initNumbers();
    }

    public void play() {
        String playResult;
        do {
            OutputView.printInputThreeNumber();
            playResult = gameService.getResult(PlayerNumbersDto.of(InputView.input()));
            OutputView.printPlayerResult(playResult);
        } while (!playResult.equals(STRIKE.apply(DIGIT_CNT.getNumber())));
    }

    public void end() {
        OutputView.printThreeStrike();
        OutputView.printRetryMessage();
    }

}
