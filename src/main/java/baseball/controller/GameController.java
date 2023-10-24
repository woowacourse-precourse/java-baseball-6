package baseball.controller;

import baseball.domain.GameNumber;
import baseball.service.JudgeAndCount;
import baseball.utility.GenerateRandomNumber;
import baseball.utility.Validation;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {
    private static final String WRONG_ANSWER_INPUT_MESSAGE = "1 혹은 2만 입력 가능합니다.";
    private static final String BASEBALL_GAME_RESTART_ANSWER = "1";
    private static final String BASEBALL_GAME_END_ANSWER = "2";
    boolean isUserWin;
    JudgeAndCount judgeAndCount = new JudgeAndCount();
    Validation validation = new Validation();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    GenerateRandomNumber generateRandomNumber = new GenerateRandomNumber();

    public void startGame() {
        boolean gameState = true;

        if(gameState) {
            // 시작 메세지
            outputView.gameStartMsg();

            //게임 진행
            findAnswerProcess();
        }
//            gameState = askRestartGame();
    }

    private void findAnswerProcess() {

        do  {
            //숫자 생성
            GameNumber gameNumber = new GameNumber();
            settingNumbers(gameNumber);

            //비교과정으로 정답 반환
            judgeAndCount.compareNumbers(gameNumber.getUserNumbers(), gameNumber.getComputerNumbers());
            isUserWin = judgeAndCount.isCorrectAnswer();

            //정답시 end메세지 및 리플레이
            finishGame(isUserWin);
        } while(!isUserWin);
    }

    public void finishGame(boolean isUserWin) {

            outputView.gameFinishMsg();
            if(askReplayGame()) {
                findAnswerProcess();
            }
    }

    private  void settingNumbers(GameNumber gameNumber) {
        gameNumber.setUserInputString(inputView.inputNumberMsg());

        gameNumber.setComputerNumbers(generateRandomNumber.MakeRandomNumber());
        gameNumber.setUserNumbers(validation.checkValidationNumber(gameNumber.getUserInputString()));

    }

    private boolean askReplayGame() {
        String userSelection = inputView.selectReplayMsg();
        return isWantRestartGame(userSelection);
    }

    public boolean isWantRestartGame(String userSelection) {
        if (userSelection.equals(BASEBALL_GAME_RESTART_ANSWER)) {
            return true;
        } else if (userSelection.equals(BASEBALL_GAME_END_ANSWER)) {
            return false;
        }
        throw new IllegalArgumentException(WRONG_ANSWER_INPUT_MESSAGE);
    }
}