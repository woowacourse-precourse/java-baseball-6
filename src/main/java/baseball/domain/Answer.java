package baseball.domain;
/*
기능 : 상대방 컴퓨터 숫자
기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수
 */

import baseball.utils.Range;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class Answer {
    private Set<Integer> answerNumbers;

    public void generateRandomNumbers() {
        answerNumbers = new HashSet<>(); // Initialize answerNumbers

        while (answerNumbers.size() < Range.VALID_INPUT_SIZE.getRange()) {
            int pickedNumber = Randoms.pickNumberInRange(Range.MIN.getRange(), Range.MAX.getRange());
            answerNumbers.add(pickedNumber);  // Add the number to answerNumbers
        }
    }

    public Set<Integer> getAnswerNumbers() {
        return this.answerNumbers;
    }
}

