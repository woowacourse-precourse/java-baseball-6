package baseball.game;

import static baseball.game.GameOutput.printlnEndMessage;
import static baseball.game.GameOutput.printlnStartMessage;

import baseball.computer.RandomComputerNumberGenerator;
import baseball.user.UserInput;

public class Game {

    private final UserInput userInput = new UserInput();
    private final GameLogic gameLogic = new GameLogic();

    public Game() {
        printlnStartMessage();
    }

    public void start() {
        GameStatus gameStatus = GameStatus.RESTART;
        while (gameStatus == GameStatus.RESTART) {
            playGameRound(generateComputerNumberString());
            gameStatus = determineRestart();
        }
    }

    private String generateComputerNumberString() {
        return new RandomComputerNumberGenerator().toString();
    }

    private void playGameRound(String computerNumberString) {
        GameResult gameResult = gameLogic.initializeResult();
        while (gameResult.strikeCountIsNotGameEndCondition()) {
            gameResult = gameLogic.makeResultCount(userInput.readNumberString(), computerNumberString);
            gameLogic.displayResult(gameResult);
        }

        gameResult.callStrikeThree();
    }

    private GameStatus determineRestart() {
        GameStatus gameStatus = GameStatus.chooseStatus(userInput.readOneOrTwo());
        if (gameStatus == GameStatus.EXIT) {
            printlnEndMessage();
        }

        return gameStatus;
    }

}
