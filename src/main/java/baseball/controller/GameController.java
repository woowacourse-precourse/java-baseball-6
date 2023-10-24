package baseball.controller;

import baseball.model.dto.RestartFlag;
import baseball.model.dto.Score;
import baseball.model.entity.Baseball;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private final InputView inputView = new InputView();
    private final GameService gameService = new GameService();
    private final OutputView outView = new OutputView();
    private String restartMessage;

    public void startGame() {
        outView.printGameStart();
        playGame();
        if(RestartFlag.isRestart(restartMessage)) {
            restartMessage = RestartFlag.END.getNumbertoString();
            playGame();
        }
        if(!RestartFlag.isEnd(restartMessage)) {
            outView.printGameEnd();
        }
    }

    private void playGame() {
        gameService.startGame();
        calculateResult(getInputNumbers());
    }

    private void calculateResult(Baseball inputNumbers) {
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

    private Baseball getInputNumbers(){
        outView.printInputNumberMessage();
        String BaseballNumber = getInputMessage();
        return new Baseball(BaseballNumber);
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
