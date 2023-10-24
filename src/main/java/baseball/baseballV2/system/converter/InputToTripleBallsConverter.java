package baseball.baseballV2.system.converter;

import static baseball.baseballV2.system.util.Util.StringToCharList;

import baseball.baseballV2.model.Ball;
import baseball.baseballV2.model.TripleBalls;
import baseball.baseballV2.system.util.Util;
import baseball.baseballV2.system.validator.TripleBallsValidator;
import java.util.Arrays;
import java.util.List;

public class InputToTripleBallsConverter {
    public static TripleBalls convert(String input) throws IllegalArgumentException {
        new TripleBallsValidator(input);
        List<Character> charList = StringToCharList(input);

        return new TripleBalls(
                getTripleBallsWithConverter(charList, Util.FIRST_DIGIT)
        );
    }

    private static List<Ball> getTripleBallsWithConverter(List<Character> charList, int digit) {
        return Arrays.asList(
                new Ball(digit, charToInteger(charList.get(digit++))),
                new Ball(digit, charToInteger(charList.get(digit++))),
                new Ball(digit, charToInteger(charList.get(digit)))
        );
    }

    private static int charToInteger(Character character) {
        return Integer.parseInt(String.valueOf(character));
    }
}
