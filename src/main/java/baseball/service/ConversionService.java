package baseball.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ConversionService {

    private ConversionService() {
    }

    public static String convertSetToString(Set<Integer> numbers) {
        StringBuilder sb = new StringBuilder();
        for (Integer number : numbers) {
            sb.append(number);
        }
        return sb.toString();
    }

    public static List<Integer> stringToListOfInteger(String number) {
        return number.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
    }
}
