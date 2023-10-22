package baseball.controller;

import baseball.io.PlayerIoManager;
import baseball.model.Ball;
import baseball.model.BallMaker;
import baseball.model.judge.BaseballJudge;
import baseball.model.judge.JudgeResult;
import java.util.List;

public class GameManager {

    private PlayerIoManager playerIoManager;
    private BallMaker ballMaker;
    private BaseballJudge baseballJudge;

    private GameManager() {
    }

    public static GameManager create() {
        GameManager gameManager = new GameManager();

        gameManager.playerIoManager = PlayerIoManager.create();
        gameManager.ballMaker = new BallMaker();

        return gameManager;
    }

    public void startGame() {
        playerIoManager.welcomePlayer();

        baseballJudge = BaseballJudge.computerBallOf(ballMaker.createBall());

        while (true) {
            List<Integer> playerNumbers = playerIoManager.askThreeNumbers();
            Ball playerBall = new Ball(playerNumbers);
            JudgeResult judgeResult = baseballJudge.judge(playerBall);

            playerIoManager.notifyJudgeResult(judgeResult);

            if (baseballJudge.isPlayerWon(playerBall)) {

                playerIoManager.congratulate();
//
//            if (playerIoManager.isPlayerWantToReplay()) {
//
//            }
            }
        }

    }

}
