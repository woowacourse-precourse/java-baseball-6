package baseball.controller;

import baseball.domain.player.dto.PlayerNumbersDto;
import baseball.domain.player.dto.RetryNumberDto;
import baseball.global.view.input.InputView;
import baseball.global.view.output.OutputView;
import baseball.service.GameService;

import static baseball.global.message.BallMessage.STRIKE;

public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void run() {
        boolean retry;
        do {
            gameService.createComputerNumber();
            start();
            play();
            end();
            retry = gameService.askRetry(RetryNumberDto.of(InputView.input()));
        } while (retry);
    }


    public void start() {
        OutputView.printStartMessage();
    }

    public void play() {
        String playResult;
        do {
            OutputView.printInputThreeNumber();
            playResult = gameService.getResult(PlayerNumbersDto.of(InputView.input()));
            OutputView.printPlayerResult(playResult);
        } while (!playResult.equals(STRIKE.apply(3)));
    }

    public void end() {
        OutputView.printThreeStrike();
        OutputView.printRetryMessage();
    }

}
