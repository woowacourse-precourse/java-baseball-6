package baseball.util;

import baseball.model.player.GuessNumber;
import java.util.List;
import java.util.stream.Collectors;

public class StringToGuessNumberListConverter {

    private StringToGuessNumberListConverter() {
    }

    public static List<GuessNumber> StringToGuessNumberList(String input) {
        return input.chars()
                .mapToObj(c ->
                        new GuessNumber(Character.getNumericValue(c))
                ).collect(Collectors.toList());
    }
}
