package baseball.controller;

import baseball.model.Player;
import baseball.model.Referee;
import baseball.view.Message;

public class GameController {

    public Player player;
    public Referee referee;

    public void startGame() {
        Message.getInstance().printStartMessage();
        do {
            setGame();
            playGame();
            Message.getInstance().printRestartMessage();
        } while (referee.isRestart());
    }

    private void setGame() {
        this.referee = new Referee();
        this.player = new Player();
        referee.setGame();
    }

    private void playGame() {
        while (true) {
            // 1. 공 던지기
            Message.getInstance().printInputMessage();
            String ball = player.throwBall();
            // 2. 볼 판정
            int[] ballCount = referee.callBallCount(ball);
            Message.getInstance().printBallCount(ballCount[0], ballCount[1]);
            // 3. 삼진 아웃 - 게임 종료
            if (referee.isStrikeOut(ballCount)) {
                Message.getInstance().printEndMessage();
                break;
            }
        }
    }


}