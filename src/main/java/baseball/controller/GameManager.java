package baseball.controller;

import baseball.io.PlayerIoManager;
import baseball.model.ball.Ball;
import baseball.model.ball.BallMaker;
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

        baseballJudge = initializeBaseBallJudgeWithComputerBall();

        while (true) {
            Ball playerBall = playRound();

            if (baseballJudge.isPlayerWon(playerBall)) {
                playerIoManager.congratulate();

                if (!playerIoManager.isPlayerWantToReplay()) {
                    return;
                }

                baseballJudge = initializeBaseBallJudgeWithComputerBall();
            }
        }
    }

    private Ball playRound() {
        List<Integer> playerNumbers = playerIoManager.askThreeNumbers();
        Ball playerBall = new Ball(playerNumbers);

        JudgeResult judgeResult = baseballJudge.judge(playerBall);
        playerIoManager.notifyJudgeResult(judgeResult);

        return playerBall;
    }

    private BaseballJudge initializeBaseBallJudgeWithComputerBall() {
        return BaseballJudge.computerBallOf(ballMaker.createBall());
    }

}
