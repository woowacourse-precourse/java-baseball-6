package baseball.model;

import static baseball.model.Constants.INPUT_LENGTH;

public class Hint {
    private final GameNumber gameNumber;
    private final InputNumbers inputNumbers;


    public Hint(GameNumber gameNumber, InputNumbers inputNumbers) {
        this.gameNumber = gameNumber;
        this.inputNumbers = inputNumbers;
    }

    public String checkAnswer() {
        if (countStrikes() == INPUT_LENGTH) {
            return "3스트라이크";
        }
        return null;
    }

    private String checkStrikes() {
        int strikes = countStrikes();
        if (strikes == 0) {
            return "";
        }
        return strikes + "스트라이크";
    }

    private String checkBalls() {
        int balls = countBalls();
        if (balls == 0) {
            return "";
        }
        return balls + "볼";
    }

    public String createHintMessage() {
        String strikeMessage = checkStrikes();
        String ballMessage = checkBalls();
        String hintMessage;
        if (strikeMessage.isEmpty() && ballMessage.isEmpty()) {
            return "낫싱";
        }
        if (!strikeMessage.isEmpty()) {
            if (ballMessage.isEmpty()) {
                hintMessage = strikeMessage;
            } else {
                hintMessage = ballMessage + " " + strikeMessage;
            }
        } else {
            hintMessage = ballMessage;
        }
        return hintMessage;
    }

    private int countStrikes() {
        int strikes = 0;

        for (int i = 0; i < INPUT_LENGTH; i++) {
            if (isStrike(i)) {
                strikes++;
            }
        }
        return strikes;
    }

    private boolean isStrike(int index) {
        return gameNumber.getNumber(index) == inputNumbers.getNumber(index);
    }

    private int countBalls() {
        int balls = 0;

        for (int i = 0; i < INPUT_LENGTH; i++) {
            if (isBall(i)) {
                balls++;
            }
        }
        return balls;
    }

    private boolean isBall(int index) {
        int number = gameNumber.getNumber(index);

        for (int j = 0; j < INPUT_LENGTH; j++) {
            if (index != j && number == inputNumbers.getNumber(j)) {
                return true;
            }
        }
        return false;
    }
}
