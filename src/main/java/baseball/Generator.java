package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Generator {

    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 9;

    public static List<Integer> generateAnswer(int listLen) {
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

    public static List<Integer> generateInputList(String input) {
        int inputLen = input.length();

        List<Integer> inputList = new ArrayList<>();
        for (int idx = 0; idx < inputLen; idx++) {
            int inputNum = input.charAt(idx) - '0';

            validateNumber(inputNum);
            validateDuplication(inputList, inputNum);

            inputList.add(inputNum);
        }

        return inputList;
    }

    private static void validateDuplication(List<Integer> inputList, int inputNum) {
        if (inputList.contains(inputNum)) {
            throw new IllegalArgumentException("중복되지 않는 숫자를 입력해야 합니다.");
        }
    }

    private static void validateNumber(int inputNum) {
        if (inputNum < MIN_NUM || inputNum > MAX_NUM) {
            throw new IllegalArgumentException("1 ~ 9 범위의 숫자만 입력해야 합니다.");
        }
    }
}
