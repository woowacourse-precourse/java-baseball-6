package baseball;

import java.util.List;

public class GameController {

    private final GameStartController gameStartController;
    private final ComputerNumber computerNumber;
    private final Hint hint;
    private final UserInput userInput;

    GameController() {
        this.gameStartController = new GameStartController();
        this.computerNumber = new ComputerNumber();
        this.hint = new Hint();
        this.userInput = new UserInput();
    }

    public void play() {
        gameStartController.start();
        List<Integer> computerNum = this.makeComputerNum();
        List<Integer> userNum;
        boolean isGameDone;

        do {
            userNum = this.getUserNum();
            isGameDone = this.giveHint(computerNum, userNum);
        } while (!isGameDone);
        this.restartOrEnd();
    }

    public List<Integer> makeComputerNum() {
        return computerNumber.makeThreeUniqueNums();
    }

    public List<Integer> getUserNum() {
        String userInputStr = userInput.readUserInput();
        userInput.checkUserInput(userInputStr);
        return userInput.stringToList(userInputStr);
    }

    public boolean giveHint(List<Integer> computerNum, List<Integer> userNum) {
        HintDto hintDto = hint.calHint(computerNum, userNum);
        return hint.printHint(hintDto);
    }

    public void restartOrEnd() {
        boolean isRestart = gameStartController.restartOrEnd();
        if (isRestart) {
            this.play();
        }
    }
}
