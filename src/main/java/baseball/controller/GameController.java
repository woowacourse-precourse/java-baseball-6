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
        referee = new Referee(viewController);
    }

    public void start() {
        boolean resume = true;
        while (resume) {
            this.userPlayer = new UserPlayer();
            this.computerPlayer = new ComputerPlayer();
            play();
            resume = viewController.getResumeOption();
        }
    }

    public void play() {
        boolean gameOver = false;
        viewController.printGameStart();
        computerPlayer.setNumberArray(viewController.getComputerNumberArray());
        while (!gameOver) {
            userPlayer.setNumberArray(viewController.getUserNumberArray());
            gameOver = referee.judgeGameOver(userPlayer.getNumberArray(), computerPlayer.getNumberArray());
        }
    }
}
