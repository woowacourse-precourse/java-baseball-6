package baseball.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Generator {

    Validation validation = new Validation();

    public List<Integer> generateAnswer(int listLen) {
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

    public List<Integer> generateInputList(int listLen) {
        String input = Console.readLine();
        validation.validateInputLength(input, listLen);

        int inputLen = input.length();

        List<Integer> inputList = new ArrayList<>();
        for (int idx = 0; idx < inputLen; idx++) {
            int inputNum = Integer.parseInt(input.substring(idx, idx + 1));

            validation.validateNumber(inputNum);
            validation.validateDuplication(inputList, inputNum);

            inputList.add(inputNum);
        }

        return inputList;
    }
}
