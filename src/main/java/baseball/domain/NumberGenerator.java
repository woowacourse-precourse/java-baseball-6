package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberGenerator {
    public static List<BaseBall> generateAnswerNumbers() {
        List<BaseBall> randomBaseBallNumbers = new ArrayList<>();
        while(randomBaseBallNumbers.size() < BaseBalls.SIZE) {
            int number = Randoms.pickNumberInRange(BaseBall.MIN_NUMBER, BaseBall.MAX_NUMBER);
            BaseBall answerNumber = BaseBall.toAnswerBaseBall(number);
            if(!randomBaseBallNumbers.contains(answerNumber)) {
                randomBaseBallNumbers.add(answerNumber);
            }
        }
        return randomBaseBallNumbers;
    }

    public static List<BaseBall> generateUserNumbers(String input) {
        List<BaseBall> userBaseBallNumbers = Arrays.stream(input.split(""))
                .map(digit -> BaseBall.toUserBaseBall(digit))
                .collect(Collectors.toList());
        return userBaseBallNumbers;
    }
}
