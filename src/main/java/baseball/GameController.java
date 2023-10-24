package baseball;

import java.util.List;

public class GameController {

    private final Game game;
    private final ComputerNumber computerNumber;
    private final Hint hint;
    private final UserInput userInput;

    GameController() {
        this.game = new Game();
        this.computerNumber = new ComputerNumber();
        this.hint = new Hint();
        this.userInput = new UserInput();
    }

    public void play() {
        game.start();
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
        List<Integer> userNum = userInput.stringToList(userInputStr);
        return userNum;
    }

    public boolean giveHint(List<Integer> computerNum, List<Integer> userNum) {
        HintCountDto hintCountDto = hint.calHint(computerNum, userNum);
        return hint.printHint(hintCountDto);
    }

    public void restartOrEnd() {
        boolean isRestart = game.restartOrEnd();
        if (isRestart) {
            this.play();
        }
    }
}
