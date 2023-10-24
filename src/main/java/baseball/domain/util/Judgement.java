package baseball.domain.util;

import java.util.List;

public class Judgement {

    public Boolean isGuessNumberContainsAnswer(List<String> numbers, String guessNumber) {
        return numbers.contains(guessNumber);
    }
}
