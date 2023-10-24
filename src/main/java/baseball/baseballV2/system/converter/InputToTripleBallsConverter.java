package baseball.baseballV2.system.converter;

import static baseball.baseballV2.system.util.Util.StringToCharList;

import baseball.baseballV2.model.Ball;
import baseball.baseballV2.model.TripleBalls;
import baseball.baseballV2.system.validator.TripleBallsValidator;
import java.util.Arrays;
import java.util.List;

public class InputToTripleBallsConverter {
    public static TripleBalls convert(String input) throws IllegalArgumentException {
        new TripleBallsValidator(input);
        List<Character> charList = StringToCharList(input);

        return new TripleBalls(
                Arrays.asList(
                        new Ball(0, charToInteger(charList.get(0))),
                        new Ball(1, charToInteger(charList.get(1))),
                        new Ball(2, charToInteger(charList.get(2)))
                )
        );
    }

    private static int charToInteger(Character character) {
        return Integer.parseInt(String.valueOf(character));
    }
}
