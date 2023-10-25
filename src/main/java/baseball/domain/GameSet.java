package baseball.domain;

import baseball.constant.GameConstant;
import baseball.constant.GameMessage;
import baseball.constant.Status;
import baseball.constant.SystemMessage;
import baseball.controller.GameController;
import java.util.List;

public class GameSet {

    private Player player;
    private final List<Integer> computerNumber;
    private List<Integer> playerNumber;


    public GameSet(List<Integer> computerNumber) {
        this.computerNumber = computerNumber;
        GameController.gameStatus = Status.SET;
    }

    public void startSet() {
        this.player = new Player();
        SystemMessage.SET.printMessage(GameController.gameStatus);
        playerNumber = player.inputNumber();
        calculateSetScore();
        if (GameController.gameStatus == Status.MATCHED) {
            askPlayerReplay();
        }
    }

    private void askPlayerReplay() {
        System.out.printf(GameMessage.ASK_REPLAY.getMessage(),
                GameConstant.REPLAY.getConstant(), GameConstant.QUIT.getConstant());
        int replayCommand = player.inputReplay();
        if (replayCommand == GameConstant.REPLAY.getConstant()) {
            GameController.gameStatus = Status.GAME;
        }
        if (replayCommand == GameConstant.QUIT.getConstant()) {
            GameController.gameStatus = Status.EXIT;
        }
    }

    public void calculateSetScore() {
        Judge judge = new Judge(computerNumber, playerNumber);
        judge.calculate();
    }

}
