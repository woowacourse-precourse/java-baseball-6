package baseball.control;

import baseball.gameRule.GameRule;
import baseball.gameRule.ShowScore;
import baseball.inputProcess.UserInput;
import baseball.outputProcess.ComputerOutput;

public class GameControl {
    ComputerControl computerControl = new ComputerControl();
    private int strike = 0;
    private int ball = 0;
    private String computerNumber = computerControl.generateNumber();

    UserInput userInput = new UserInput();
    ComputerOutput computerOutput = new ComputerOutput();
    ShowScore showScore = new ShowScore();

    public void startGame() {
        computerOutput.startMessage();
        do {
            playGame();
        } while (!isFinished());
    }

    public void reStart() {
        computerNumber = computerControl.generateNumber();
    }

    public void playGame() {
        UserInput userInput = new UserInput();
        String inputNumber = userInput.getInputValue();

        UserControl userControl = new UserControl(inputNumber);

        String userNumber = userControl.decideUserNumber();
        GameRule gameRule = new GameRule(computerNumber, userNumber);

        strike = gameRule.isStrike();
        ball = gameRule.isBall();

        showScore.eachScore(strike, ball);
    }

    public boolean moreGame() {
        String newInputNumber = userInput.getChoiceValue();
        isNumber(newInputNumber);
        return isCorrectNum(newInputNumber);
    }

    public boolean isFinished() {
        if (strike == 3) {
            computerOutput.successMessage();
            return !moreGame();
        }
        return false;
    }

    public boolean isCorrectNum(String num) {
        if (num.equals("1")) {
            reStart();
            return true;
        } else if (num.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException("1또는 2를 입력해야 합니다.");
        }
    }

    public void isNumber(String num) {
        for (int i = 0; i < num.length(); i++) {
            if (!Character.isDigit(num.charAt(i))) {
                throw new IllegalArgumentException("숫자가 아닙니다.");
            }
        }
    }
}
