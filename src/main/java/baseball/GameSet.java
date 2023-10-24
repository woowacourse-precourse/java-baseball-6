package baseball;

import baseball.constant.GameConstant;
import baseball.constant.GameMessage;
import baseball.constant.Status;
import baseball.constant.SystemMessage;

import java.util.List;

public class GameSet {

    private Player player;
    private final List<Integer> computerNumber;
    private List<Integer> playerNumber;


    public GameSet(List<Integer> computerNumber) {
        this.computerNumber = computerNumber;
    }

    public void startSet() {
        this.player = new Player();
        SystemMessage.INPUT.printMessage(GameController.gameStatus);
        playerNumber = player.inputNumber();
        System.out.println("GameSet.startSet : " + playerNumber);
        calculateSetScore();
        if (GameController.gameStatus == Status.SET_FINISH) {
            System.out.println("=== 세트 종료됨 ===");
            askPlayerReplay();
        }
    }

    private void askPlayerReplay() {
        System.out.printf(GameMessage.ASK_REPLAY.getMessage(),
                GameConstant.REPLAY.getConstant(), GameConstant.QUIT.getConstant());
        int replayCommand = player.inputReplay();
        if (replayCommand == GameConstant.REPLAY.getConstant()) {
            System.out.println("게임 리플레이");
            GameController.gameStatus = Status.GAME;
        }
        if (replayCommand == GameConstant.QUIT.getConstant()) {
            System.out.println("게임 종료");
            GameController.gameStatus = Status.EXIT;
        }
    }

    public void calculateSetScore() {
        Judge judge = new Judge(computerNumber, playerNumber);
        judge.calculate();
    }

}
