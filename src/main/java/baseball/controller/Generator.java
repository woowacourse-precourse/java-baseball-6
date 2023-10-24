package baseball.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Generator {

    public static List<Integer> generateAnswer(int listLen) {
        List<Integer> answerList = new ArrayList<>();

        while (answerList.size() < listLen) {
            int num = Randoms.pickNumberInRange(1, 9);

            if (answerList.contains(num)) {
                continue;
            }

            answerList.add(num);
        }

        return answerList;
    }

    public static List<Integer> generateNumericInputList(String input) {
        int inputLen = input.length();

        List<Integer> inputList = new ArrayList<>();
        for (int idx = 0; idx < inputLen; idx++) {
            int inputNum = Character.getNumericValue(input.charAt(idx));

            inputList.add(inputNum);
        }

        return inputList;
    }
}
