package baseball.service;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.domain.Score;
import baseball.view.Message;
import camp.nextstep.edu.missionutils.Console;

public class GameService {

    private Computer computer;
    private Player player;

    public void startGame() {
        Message.printGameStartMessage();
        settingGame();
        playGame();
    }

    private void playGame() {
        while (!computer.isCorrect(player.getPlayerNumbers())) {
            inputPlayerNumber();
            Score score = new Score();
            score.calculateScore(computer.getResult(), player.getPlayerNumbers());
            score.printScore();
        }

        endGame();
    }

    private void settingGame() {
        computer = new Computer();
        player = new Player();
    }

    private void inputPlayerNumber() {
        Message.printPlayerInputNumberMessage();
        player.setPlayerNumbers(Console.readLine());
    }

    private void endGame() {
        Message.printGameEndMessage();
        retryGame();
    }

    private void retryGame() {
        Message.printGameRetryMessage();
        computer.retryOrEndGame(Console.readLine());

        if (computer.isRetry()) {
            settingGame();
            playGame();
        }
    }
}
