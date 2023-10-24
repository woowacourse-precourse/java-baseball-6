package baseball.controller;

import baseball.domain.GameNumberDTO;
import baseball.service.ComputerService;
import baseball.service.GameService;
import baseball.service.ValidateService;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {

    private static final String RESTART_NUM = "1";
    private static final String END_NUM = "2";
    private static final String WRONG_INPUT = "잘못 입력하셨습니다.";

    OutputView outputView = new OutputView();
    ComputerService computerService = new ComputerService();
    GameNumberDTO gameNumber = new GameNumberDTO();
    InputView inputView = new InputView();
    ValidateService validateService = new ValidateService();
    GameService gameService = new GameService();

    /**
     * 게임 시작
     */
    public void gameStart() {
        boolean gameState = true;
        while (gameState) {
            outputView.startInfo(); // 게임 시작 메세지
            computerService.comNumber(gameNumber); //난수 저장
            repeatGuess();
            gameState = isRestart();
        }
    }


    private void repeatGuess() { // 정답이 나오기 전까지 반복되는 난수 추측하기
        boolean isAnswer = false;
        while (!isAnswer) {
            gameNumber.setUserInput(inputView.inputNumberMsg());
            List<Integer> userNum = validateService.validateNumber(gameNumber.getUserInput());
            gameNumber.setUserNum(userNum);

            isAnswer = gameService.gameToDo(gameNumber);
            gameEnd(isAnswer);
        }
    }

    /**
     * 게임 끝
     */

    public void gameEnd(boolean isAnswer) {
        if (isAnswer) {
            outputView.answerMsg();
        }
    }

    /**
     * 게임 재시작
     */

    private boolean isRestart() {
        String result = inputView.inputEndMsg();

        if (result.equals(RESTART_NUM)) {
            return true;
        }
        if (result.equals(END_NUM)) {
            return false;
        }
        throw new IllegalArgumentException(WRONG_INPUT);
    }
}

