package baseball.controller;

import baseball.dto.BaseballDto;
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
        boolean start = true;
        while (start) {
            Baseball answer = baseballService.createAnswerBaseball();
            playGame(answer);
            start = isRestart();
        }
    }

    private void playGame(Baseball answer) {
        boolean isClear = false;

        while (!isClear) {
            baseballView.startGame();

            String number = baseballView.inputNumber();
            BaseballDto baseballDto = new BaseballDto(number);
            Baseball guess = baseballDto.toBaseball();

            BaseballGameResult result = baseballService.calculateResult(answer, guess);
            baseballView.showGameResult(result.getMessage());

            isClear = result.isClear();
        }
        baseballView.clearGame();
    }

    private boolean isRestart() {
        //TODO Auto-generated
        return false;
    }
}
