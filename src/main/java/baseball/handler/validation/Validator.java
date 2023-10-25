package baseball.handler.validation;

import baseball.config.GameProperty;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {


    private Validator() {
    }

    public static void answerValidate(List<Integer> userAnswer) {
        dupleNumValidate(userAnswer);
        lengthValidate(userAnswer);
        typeValidate(userAnswer);
    }

    private static void dupleNumValidate(List<Integer> userAnswer) {
        Set<Integer> answerSet = new HashSet<>(userAnswer);
        if (answerSet.size() != userAnswer.size()) {
            throw new IllegalArgumentException();
        }
    }

    private static void lengthValidate(List<Integer> userAnswer) {
        if (userAnswer.size() > GameProperty.getAnswerlength()) {
            throw new IllegalArgumentException();
        }
    }

    private static void typeValidate(List<Integer> userAnswer) {
        for (int num : userAnswer) {
            throw new IllegalArgumentException();
        }
    }
}
