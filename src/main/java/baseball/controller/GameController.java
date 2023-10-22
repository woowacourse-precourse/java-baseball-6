package baseball.controller;

import baseball.model.dto.Score;
import baseball.model.entity.BaseballNumber;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutView;

public class GameController {
    private final InputView inputView = new InputView();
    private final GameService gameService = new GameService();
    private final OutView outView = new OutView();
    private String restartMessage;

    public void startGame() {
        playGame();
        if(restartMessage.equals("1")) {
            restartMessage = "2";
            playGame();
        }
        if(restartMessage.equals("2")) {
            outView.printGameEnd();
        }
    }

    private void playGame() {
        gameService.startGame();
        calculateResult(getInputNumbers());
    }

    private void calculateResult(BaseballNumber inputNumbers) {
        Score score = gameService.calculateResult(inputNumbers);
        outView.printResult(score);
        if (score.isGameEnd()) {
            printEndAndAskRestart();
            return;
        }
        calculateResult(getInputNumbers());
    }
    private void printEndAndAskRestart() {
        outView.printGameEnd();
        outView.printGameRestartMessage();
        restartMessage = getInputMessage();
    }

    private BaseballNumber getInputNumbers(){
        outView.printInputNumberMessage();
        String input = getInputMessage();
        return new BaseballNumber(input);
    }

    private String getInputMessage() {
        try {
            return inputView.input();
        }
        catch (Exception e) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }
}
