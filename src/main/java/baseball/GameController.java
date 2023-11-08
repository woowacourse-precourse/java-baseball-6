package baseball;

import java.util.List;

public class GameController {

    private final GameStarter gameStarter;
    private final ComputerNumber computerNumber;
    private final Hint hint;
    private final UserInput userInput;

    GameController() {
        this.gameStarter = new GameStarter();
        this.computerNumber = new ComputerNumber();
        this.hint = new Hint();
        this.userInput = new UserInput();
    }

    public void play() {
        gameStarter.start();
        List<Integer> computerNum = this.makeComputerNum();
        List<Integer> userNum;
        boolean isGameDone;

        do {
            userNum = this.getUserNum();
            isGameDone = this.giveHint(computerNum, userNum);
        } while (!isGameDone);
        this.restartOrEnd();
    }

    private List<Integer> makeComputerNum() {
        return computerNumber.makeThreeUniqueNums();
    }

    private List<Integer> getUserNum() {
        String userInputStr = userInput.readUserInput();
        userInput.checkUserInput(userInputStr);
        return userInput.stringToList(userInputStr);
    }

    private boolean giveHint(List<Integer> computerNum, List<Integer> userNum) {
        HintDto hintDto = hint.calHint(computerNum, userNum);
        return hint.printHint(hintDto);
    }

    private void restartOrEnd() {
        boolean isRestart = gameStarter.restartOrEnd();
        if (isRestart) {
            this.play();
        }
    }
}
