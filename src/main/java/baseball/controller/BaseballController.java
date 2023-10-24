package baseball.controller;

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

    public void start() {
        outputView.notifyStart();
        baseballService.turnOnComputer();
    }

    public void play() {
        while(!baseballService.isGameOver()) {
            String playersAnswer = inputView.readPlayersAnswer();
            baseballService.inputAnswer(playersAnswer);
            String outputMessage = baseballService.palyGame();
            outputView.notifyGameResult(outputMessage);
        }
    }

    public boolean replay() {
        String playersContinue = inputView.readPlayersContinue();
        return baseballService.replay(playersContinue);
    }

    public void end() {
        outputView.notifyEnd();
    }
}