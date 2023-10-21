package baseball.controller;

import baseball.Configuration;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Generator {

    int MIN_NUM = Configuration.MIN_NUM;
    int MAX_NUM = Configuration.MAX_NUM;
    int LIST_LEN = Configuration.LIST_LEN;

    Validation validation = new Validation();


    public List<Integer> generateAnswer(int listLen) {
        List<Integer> answerList = new ArrayList<>();

        while (answerList.size() < listLen) {
            int num = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);

            if (answerList.contains(num)) {
                continue;
            }

            answerList.add(num);
        }

        return answerList;
    }

    public List<Integer> generateInputList() {
        String input = Console.readLine();
        validation.validateInputLength(input, LIST_LEN);

        int inputLen = input.length();

        List<Integer> inputList = new ArrayList<>();
        for (int idx = 0; idx < inputLen; idx++) {
            int inputNum = input.charAt(idx) - '0';

            validation.validateNumber(inputNum);
            validation.validateDuplication(inputList, inputNum);

            inputList.add(inputNum);
        }

        return inputList;
    }
}
