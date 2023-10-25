package baseball.model;

import java.util.List;

public class Game {
    private final List<Integer> computerNumber;
    private List<Integer> userNumber;
    private GameResult gameResult;

    public Game() {
        this.computerNumber = new ComputerNumber().getComputerNumber();
    }

    public void userInput(String userInput) {
        this.userNumber = new UserInputNumber(userInput).getUserNumber();
    }

    public void countResult() {
        this.gameResult = new GameResult(computerNumber, userNumber);
    }

    public GameResult getGameResult(){
        return gameResult;
    }

}
