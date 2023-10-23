package baseball;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    public static String answer;

    int START_INCLUSIVE = Constants.START_INCLUSIVE;
    int END_INCLUSIVE = Constants.END_INCLUSIVE;
    int ANSWER_DIGIT = Constants.ANSWER_DIGIT;

    public void setAnswer() {
        List<String> randomNumberList = new ArrayList<>(ANSWER_DIGIT);
        while (randomNumberList.size() < ANSWER_DIGIT) {
            int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            if (!randomNumberList.contains(""+randomNumber)) {
                randomNumberList.add(String.valueOf(randomNumber));
            }
        }

        Computer.answer = String.join("",randomNumberList);
    }

    public int printResult(String input) {
        int strikes = 0;
        int balls = 0;

        // ball, strike 계산
        for (int i = 0; i < input.length(); i++) {
            char inputChar = input.charAt(i);
            char answerChar = Computer.answer.charAt(i);

            if (inputChar == answerChar) {
                strikes++;
            } else if (answer.contains(String.valueOf(inputChar))) {
                balls++;
            }
        }

        // 결과에 맞게 결과값 print
        String comment = (strikes == 0 && balls == 0) ? "낫싱" : ((balls > 0 ? balls + "볼 " : "") +
                (strikes > 0 ? strikes + "스트라이크" : ""));

        System.out.println(comment);
        return strikes;
    }
}
