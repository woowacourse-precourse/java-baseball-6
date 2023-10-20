package baseball.service;

import java.util.Set;

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
}
