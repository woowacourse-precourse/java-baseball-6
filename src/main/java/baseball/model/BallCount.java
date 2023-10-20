package baseball.model;

import java.util.List;
import java.util.ArrayList;

public class BallCount {

    public static int getNumeric(Character num) {
        return Character.getNumericValue(num);
    }

    public static List<Integer> UserInputList(String UserInput) {
        List<Integer> InputList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            InputList.add(getNumeric(UserInput.charAt(i)));
        }

        return InputList;
    }

    public static boolean isContain(List<Integer> AnswerList, int num) {
        if (AnswerList.contains(num)) {
            return true;
        }
        return false;
    }

    public static int Strike(List<Integer> AnswerList, String UserInput) {
        int strikecount = 0;
        List<Integer> InputList = UserInputList(UserInput);
        for (int i = 0; i < 3; i++) {
            if (InputList.get(i) == AnswerList.get(i)) {
                strikecount++;
            }
        }
        return strikecount;
    }

    public static int Ball(List<Integer> AnswerList, String UserInput) {
        int ballcount = 0;
        List<Integer> InputList = UserInputList(UserInput);
        for (int i = 0; i < 3; i++) {
            if (InputList.get(i) != AnswerList.get(i) && isContain(AnswerList, InputList.get(i))) {
                ballcount++;
            }
        }
        return ballcount;
    }
}