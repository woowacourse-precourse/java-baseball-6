package baseball;

import java.util.List;

public class GameController {
    private Computer computer;
    private UserInput userInput;
    private boolean hasWon;

    GameController() {
        computer = new Computer();
        userInput = new UserInput();
    }

    public void proceedGame() {
        computer.generateRandomNum();
        while(!hasWon) {
            userInput.promptUserInput();
            checkMatch(computer.getRandomNum(), userInput.getUserNum());
        }

    }

    public void checkMatch(List<Integer> computerNum, List<Integer> userNum) {

    }

}
