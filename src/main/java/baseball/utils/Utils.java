package baseball.utils;

import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static List<Integer> stringToIntList(String userInput) {
        List<Integer> userInputs = userInput.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
        return userInputs;
    }
}
