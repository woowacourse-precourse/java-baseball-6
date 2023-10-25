package baseball.model;

import static baseball.model.Rule.LENGTH;
import static baseball.util.CheckValidUtil.checkContinueGameInput;
import static baseball.util.CheckValidUtil.validateAndConvertInput;
import static baseball.util.RandomUtil.generateComputer;

import java.util.List;

public class GameModel {

    private List<Integer> computerNumber;
    private List<Integer> userGuess;
    private boolean gameEndFlag;
    private boolean guessEndFlag;

    public GameModel() {
        gameEndFlag = false;
        guessEndFlag = false;
        computerNumber = generateComputer();
    }

    public void checkValidGuess(String guess) {
        userGuess = validateAndConvertInput(guess);
    }

    public void checkValidContinueInput(String continueGameInput) {
        checkContinueGameInput(continueGameInput);
    }

    public String checkGuess() {
        int strikes = 0;
        int balls = 0;
        for (int i = 0; i < LENGTH; i++) {
            if (userGuess.get(i).equals(computerNumber.get(i))) {
                strikes++;
            } else {
                for (int j = 0; j < LENGTH; j++) {
                    if (userGuess.get(i).equals(computerNumber.get(j))) {
                        balls++;
                    }
                }
            }
        }
        if (strikes != 0 && balls != 0) {
            return balls + "볼 " + strikes + "스트라이크";
        } else if (strikes == 0 && balls != 0) {
            return balls + "볼";
        } else if (strikes != 0) {
            if (strikes == LENGTH) {
                guessEndFlag = true;
            }
            return strikes + "스트라이크";
        }
        return "낫싱";
    }

    public boolean getGameEndFlag() {
        return gameEndFlag;
    }

    public boolean getGuessEndFlag() {
        return guessEndFlag;
    }

    public void setNewGame() {
        guessEndFlag = false;
        computerNumber = generateComputer();
    }

    public void setGameEndFlag(boolean flag) {
        this.gameEndFlag = flag;
    }

}
