package baseball.controller;

import baseball.model.Referee;
import baseball.model.player.ComputerPlayer;
import baseball.model.player.UserPlayer;


public class GameController {
    private UserPlayer userPlayer;
    private ComputerPlayer computerPlayer;
    private final ViewController viewController;
    private final Referee referee;

    public GameController(ViewController viewController) {
        this.viewController = viewController;
        referee = new Referee();
    }

    public void start() {
        boolean resume = true;
        while (resume) {
            this.userPlayer = new UserPlayer();
            this.computerPlayer = new ComputerPlayer();
            play();
            viewController.printFinishMessage();
            resume = viewController.getResumeOption();
        }
    }

    public void play() {
        boolean gameOver = false;
        viewController.printGameStart();
        computerPlayer.setNumberArray(viewController.getComputerNumberArray());
        while (!gameOver) {
            int[] score;
            userPlayer.setNumberArray(viewController.getUserNumberArray());
            score = referee.judgeGameScore(userPlayer.getNumberArray(), computerPlayer.getNumberArray());
            viewController.printResultMessage(score);
            gameOver = referee.judgeGameOver(score);
        }
    }
}
