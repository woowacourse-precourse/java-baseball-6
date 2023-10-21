package baseball.gameutil;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameInputConverterBaseball implements GameInputConverter {

    @Override
    public List<Integer> convertBaseballStringToList(String input) {
        return input.chars()
            .map(Character::getNumericValue)
            .boxed()
            .toList();
    }
}
