package baseball;

import java.util.List;

public class Game {

    Computer computer;
    GameManager gameManager;
    Player player;

    public Game(GameManager gameManager) {
        this.gameManager = gameManager;
        computer = new Computer();
        player = new Player();

        computer.createAnswer();
    }

    public void play() {
        while (true) {
            List<Integer> guess = gameManager.askGuess(player);
            Result result = computer.judgeAnswer(guess, computer.answer);
            gameManager.printResult(result);

            if (result.isCorrect()) {
                gameManager.printCorrectMessage();
                break;
            }
        }
    }
}
