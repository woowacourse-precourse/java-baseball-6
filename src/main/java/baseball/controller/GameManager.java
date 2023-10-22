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

        List<Integer> playerNumbers = playerIoManager.askThreeNumbers();
        JudgeResult judgeResult = baseballJudge.judge(new Ball(playerNumbers));

    }

}
