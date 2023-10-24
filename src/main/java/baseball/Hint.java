package baseball;

import java.util.List;

public class Hint {
    private int ballCounter = 0;
    private int strikeCounter = 0;
    private char[] threeNumbersOfPlayer;
    private List<Integer> threeRandomNumbersOfComputer;

    Hint(String threeNumbersOfPlayer, List<Integer> threeNumbersOfComputer) {
        this.threeNumbersOfPlayer = threeNumbersOfPlayer.toCharArray();
        this.threeRandomNumbersOfComputer = threeNumbersOfComputer;
    }

    public void calculateTheNumberOfBallAndStrike() {
        for (int i = 0; i< threeRandomNumbersOfComputer.size(); i++) {
            for (int j = 0; j< threeNumbersOfPlayer.length; j++) {
                if (threeRandomNumbersOfComputer.get(i) == (threeNumbersOfPlayer[j] - '0')) { // char - char = int
                    if (i == j) {
                        strikeCounter++;
                    } else {
                        ballCounter++;
                    }
                }
            }
        }
    }

    public int getStrikeCounter() {
        return strikeCounter;
    }

    public String toString() {
        String hint = "";

        if (ballCounter != 0) {
            hint = ballCounter + "볼 ";

            if (strikeCounter != 0) {
                hint += strikeCounter + "스트라이크";
            }
        } else {
            if (strikeCounter != 0) {
                hint += strikeCounter + "스트라이크";
            } else {
                hint = "낫싱";
            }
        }

        return hint;
    }
}
