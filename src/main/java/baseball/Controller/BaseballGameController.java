package baseball.Controller;
import baseball.service.GameService;
import baseball.domain.*;
import baseball.View.*;
import camp.nextstep.edu.missionutils.Console;

import static baseball.dto.GameResult.*;

public class BaseballGameController {

    final int GAME_RESTART = 1;
    final int GAME_OVER = 2;

    Game game;
    User user;
    GameService gameService = new GameService();//Service 호출

    public void run() throws IllegalAccessException {

        System.out.println(START_MESSAGE);  //게임 시작 메세지
        setGameNumber();  //게임 세팅해줌 즉 컴퓨터가 랜덤수 생성
        startGame();
        endGame();
        retry_or_not();
    }

    private void setGameNumber() {
        gameService.setGameNumbers();
    }

    private void startGame() throws IllegalAccessException {
        gameService.playGame();
    }
    private void endGame() {
        PrintScoreMessage.printGameOverMessage();
    }

    public boolean retry_or_not()  {
        RetryMessage.printRetryMessage();   //"게임을 다시 시작하려면 1, 종료하려면 2를 입력하세요."
        String userSelection = Console.readLine();
        validateUserSelection(userSelection);
        return userSelection.equals(GAME_RESTART);
    }

    private void validateUserSelection(final String userSelection) {
        if (!userSelection.equals(GAME_RESTART) && !userSelection.equals(GAME_OVER)) {
            throw new IllegalArgumentException("1 또는 2만 입력해야 합니다.");
        }
    }
}
