package baseball.controller;

import baseball.domain.GameNumber;
import baseball.service.JudgeAndCount;
import baseball.utility.RandomNumberGeneration;
import baseball.utility.InputValidation;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private static final String GAME_RESTART_ANSWER = "1";
    private static final String GAME_END_ANSWER = "2";
    private static final String ERROR_MSG_ANSWER = "1 또는 2 이외에 값이 입력되었습니다.";
    boolean isUserWin;
    RandomNumberGeneration randomNumberGeneration = new RandomNumberGeneration();
    InputView inputView = new InputView();
    JudgeAndCount judgeAndCount = new JudgeAndCount();
    OutputView outputView = new OutputView();
    InputValidation inputValidation = new InputValidation();


    public void gameStart() {
        outputView.gameStartMsg();
        GameInProgress();
    }
    private void GameInProgress() {
        GameNumber gameNumber = new GameNumber();
        gameNumber.setComputerNumbers(randomNumberGeneration.GenerateRandomNumber());
        do {
            gameNumber.setUserInputString(inputView.inputNumberMsg());
            gameNumber.setUserNumbers(inputValidation.ValidateNumber(gameNumber.getUserInputString()));

            judgeAndCount.compareNumbers(gameNumber.getUserNumbers(), gameNumber.getComputerNumbers());
            isUserWin = judgeAndCount.isCorrectAnswer();
        } while (!isUserWin);
        GameFinish();
    }
    public void GameFinish() {
        outputView.gameFinishMsg();
        if (askReplayGame()) {
            GameInProgress();
        }
    }
    private boolean askReplayGame() {
        String userChoice = inputView.askReplayMsg();
        return isRestartGame(userChoice);
    }
    public boolean isRestartGame(String userChoice) {
        if (userChoice.equals(GAME_RESTART_ANSWER)) {
            return true;
        } else if (userChoice.equals(GAME_END_ANSWER)) {
            return false;
        }
        throw new IllegalArgumentException(ERROR_MSG_ANSWER);
    }
}