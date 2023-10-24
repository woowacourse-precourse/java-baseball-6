package baseball.domain;

import java.util.*;

import static baseball.constant.NumberConstant.*;

public class AnswerNumbers {

    private List<Integer> answerNumbers;

    public AnswerNumbers(List<Integer> answerNumbers) {
        validateSize(answerNumbers);
        validateDuplicate(answerNumbers);
        this.answerNumbers = answerNumbers;
    }

    private void validateSize(List<Integer> answerNumbers) {
        if (answerNumbers.size() != VALID_NUMBER_SIZE) {
            throw new IllegalArgumentException("숫자는 3개만 가능합니다.");
        }
    }

    private void validateDuplicate(List<Integer> answerNumbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(answerNumbers);

        if (nonDuplicateNumbers.size() != VALID_NUMBER_SIZE) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }

    public Map<Integer, Integer> getBallNStrkie(List<Integer> inputNumbers) {
        Map<Integer, Integer> result = new HashMap<>();

        result.put(BALL, getBall(inputNumbers));
        result.put(STRIKE, getStrike(inputNumbers));
        return result;
    }

    public int getStrike(List<Integer> inputNumbers) {
        int cnt = 0;

        for (int i = 0; i < VALID_NUMBER_SIZE; i++) {
            if (answerNumbers.get(i) == inputNumbers.get(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    public int getBall(List<Integer> inputNumbers) {
        int cnt = 0;

        for (int i = 0; i < VALID_NUMBER_SIZE; i++) {
            for (int j = 0; j < VALID_NUMBER_SIZE; j++) {
                int answerNum = answerNumbers.get(i);
                int inputNum = inputNumbers.get(j);
                cnt = getCnt(cnt, i, j, answerNum, inputNum);
            }
        }
        return cnt;
    }

    private static int getCnt(int cnt, int i, int j, int answerNum, int inputNum) {
        if (i != j && (answerNum == inputNum)) {
            cnt++;
        }
        return cnt;
    }

}
