package baseball;

import java.util.List;

public class Game {

    private final GameManager gameManager;
    private final Computer computer;
    private final Player player;

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
