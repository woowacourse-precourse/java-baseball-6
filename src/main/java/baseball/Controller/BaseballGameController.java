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

    public void run() throws IllegalAccessException {  //예외처리

        System.out.println(START_MESSAGE);  //게임 시작 메세지
        setGame();  //게임 세팅해줌 즉 컴퓨터가 랜덤수 생성
        startGame();
        endGame();
        retry_or_not();
    }

    private void setGame() {
        gameService.setGame();
    }

    private void startGame() throws IllegalAccessException {
        gameService.playGame();
    }
    private void endGame() {
        PrintScoreMessage.printGameOverMessage();
    }

    private void retry_or_not() throws IllegalAccessException {
        RetryMessage.printRetryMessage();
        if (getInputNum() == GAME_RESTART)
            startGame();
    }

    private int getInputNum() throws IllegalAccessException { //게임 재시작 여부. 숫자를 입력
        int inputNumber = Integer.parseInt(Console.readLine());

        if (inputNumber == 0 || inputNumber > GAME_OVER){
            throw new IllegalAccessException();
        }
        return inputNumber;
    }

}