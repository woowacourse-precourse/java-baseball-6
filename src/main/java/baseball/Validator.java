package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private static final int ANSWER_SIZE = 3;

    public static void checkValidOfReply(String userReply) {
        if (!userReply.equals("1") && !userReply.equals("2")) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
    }

    public static void checkValidOfAnswerUnique(List<Integer> tempAnswer) {
        Set<Integer> uniqueNumbers = new HashSet<>(tempAnswer);
        if (uniqueNumbers.size() != ANSWER_SIZE) {
            throw new IllegalArgumentException("숫자는 중복되지 않아야합니다.");
        }
    }

    public static void checkValidOfAnswerSize(List<Integer> tempAnswer) {
        if (tempAnswer.size() > ANSWER_SIZE || tempAnswer.isEmpty()) {
            throw new IllegalArgumentException("숫자는 3자리 입력해야 합니다.");
        }
    }
}
