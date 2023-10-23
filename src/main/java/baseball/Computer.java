package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    public static String answer;
    int START_INCLUSIVE = Constants.START_INCLUSIVE;
    int END_INCLUSIVE = Constants.END_INCLUSIVE;
    int ANSWER_DIGIT = Constants.ANSWER_DIGIT;

    public Computer() {
        answer = chooseRandomNumber();
    }

    private String chooseRandomNumber() {
        List<String> randomNumberList = new ArrayList<>(ANSWER_DIGIT);
        while (randomNumberList.size() < ANSWER_DIGIT) {
            int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            if (!randomNumberList.contains("" + randomNumber)) {
                randomNumberList.add("" + randomNumber);
            }
        }

        return String.join("", randomNumberList);
    }

    public void printResult(String input) {
        int strikes = getStrikesCount(input);
        int balls = getBallsCount(input);

        String comment = (strikes == 0 && balls == 0) ? "낫싱" : ((balls > 0 ? balls + "볼 " : "") +
                (strikes > 0 ? strikes + "스트라이크" : ""));
        System.out.println(comment);
    }

    private int getBallsCount(String input) {
        int balls = 0;
        for (int i = 0; i < input.length(); i++) {
            char inputChar = input.charAt(i);
            if (answer.contains("" + inputChar)) {
                balls++;
            }
        }
        return balls - getStrikesCount(input);
    }

    public int getStrikesCount(String input) {
        int strikes = 0;
        for (int i = 0; i < input.length(); i++) {
            char inputChar = input.charAt(i);
            char answerChar = answer.charAt(i);
            if (inputChar == answerChar) {
                strikes++;
            }
        }
        return strikes;
    }
}
