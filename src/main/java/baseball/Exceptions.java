package baseball;

import java.util.List;

public class Exceptions {
    // Guess input의 길이 체크
    public static void guessLengthCheck(String s) {
        if (s == null) {
            throw new IllegalArgumentException(Text.guessNullException);
        }
        if (s.length() != Variables.answerLength) {
            throw new IllegalArgumentException(Text.guessLengthException);
        }
    }

    // Guess input의 각 문자가 숫자인지 체크
    public static void guessIsNumberCheck(char c) {
        if (!Character.isDigit(c)) {
            throw new IllegalArgumentException(Text.guessIsNumberException);
        }
    }

    // Guess input의 각 숫자가 서로 다른지 체크
    public static void guessDupliNumberCheck(List<Integer> l, char c) {
        if (l.contains(Character.getNumericValue(c))) {
            throw new IllegalArgumentException(Text.guessDupliNumberException);
        }
    }

    // EndPhase restartInput이 형식에 안 맞는 경우
    public static void restartInputException() {
        throw new IllegalArgumentException(Text.restartInputException);
    }
}
