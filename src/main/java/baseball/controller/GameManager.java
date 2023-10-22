package baseball.controller;

import baseball.io.PlayerIoManager;
import baseball.model.BallMaker;
import baseball.model.judge.BaseballJudge;

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

    }


}
