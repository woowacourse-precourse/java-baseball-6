package baseball.global.converter;

import baseball.domain.player.dto.PlayerNumbersDto;

import java.util.ArrayList;
import java.util.List;

public class NumbersConverter {

    public static List<Integer> convertNumbers(String playerNumbers) {
        List<String> inputNumbers = List.of(playerNumbers.split(""));

        List<Integer> numbers = new ArrayList<>();
        for (String num : inputNumbers) {
            Integer parsedNumber = Integer.parseInt(num);
            numbers.add(parsedNumber);
        }
        return numbers;
    }
}
