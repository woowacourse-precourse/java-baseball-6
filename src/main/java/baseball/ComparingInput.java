package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ComparingInput {

    private int strike = 0;
    private int ball = 0;

    public void Compare(int num, String input) {
        String answer = Integer.toString(num);
        char[] answerArr = answer.toCharArray();
        char[] inputArr = input.toCharArray();

        ArrayList<Character> inputList = new ArrayList<Character>();
        for (char i : inputArr) {
            inputList.add(i);
        }

        for (int i = 0; i < 3; i++) {
            if (inputList.get(i) == answerArr[i]) {
                strike += 1;
            } else if (inputList.contains(answerArr[i])) {
                ball += 1;
            }
        }
    }
    public void PrintResults() {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.println(ball+"볼");
        } else if (ball == 0) {
            System.out.println(strike+"스트라이크");
        } else {
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }
    }

    public int getStrike() {
        return strike;
    }
}
