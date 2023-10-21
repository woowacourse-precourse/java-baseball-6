package baseball.utils;

import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public List<Integer> convertStringToList(String input) {
        List<Integer> integerList = input.chars()
            .mapToObj(Character::getNumericValue)
            .collect(Collectors.toList());

        return integerList;
    }
}
