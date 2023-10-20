package baseball.controller;

import baseball.view.EndView;
import baseball.view.StartView;

public class GameController {

    private static final String GAME_RESTART_ANSWER = "1";
    private static final String GAME_END_ANSWER = "2";

    StartView startView = new StartView();
    EndView endView = new EndView();
    ComputerController computerController = new ComputerController();

    public void gameStart() {
        startView.printStartGame();
        computerController.startGame();
    }

    public void guessNumber(String inputNumber) {
        //TODO: 입력값 검증
        computerController.compareNumber(inputNumber);
    }

    public void endGame() {
        endView.printEndGame();
        endView.reStart();
    }

    public void restart (String answer) {
        if(answer.equals(GAME_RESTART_ANSWER)) {

        } else if(answer.equals(GAME_END_ANSWER)) {

        }

    }
}
