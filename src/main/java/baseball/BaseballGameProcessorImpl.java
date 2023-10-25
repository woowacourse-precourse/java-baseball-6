package baseball;

import static baseball.BaseballConstants.*;

import java.util.HashSet;
import java.util.Set;


public class BaseballGameProcessorImpl implements BaseballGameProcessor {

    private static final int INIT_NUMBER = 0;

    @Override
    public String process(String computerNumber, String inputNumber) {
        Set<Character> box = new HashSet<>();
        Baseball baseball = Baseball.getInstance();
        for (int i = INIT_NUMBER; i < computerNumber.length(); i++) {
            box.add(computerNumber.charAt(i));
        }
        for (int i = INIT_NUMBER; i < inputNumber.length(); i++) {
            if (!box.contains(inputNumber.charAt(i))) {
                continue;
            }
            if (computerNumber.charAt(i) == inputNumber.charAt(i)) {
                baseball.incrementStrikeCount();
                continue;
            }
            baseball.incrementBallCount();
        }
        return baseball.toString();
    }
}
