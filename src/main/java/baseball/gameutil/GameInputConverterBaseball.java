package baseball.gameutil;

import java.util.List;
import java.util.stream.Stream;

public class GameInputConverterBaseball implements GameInputConverter {

    @Override
    public List<Integer> convertBaseballStringToList(String input) {
        return Stream.of(input.toCharArray())
            .map((ch) -> {
                return Integer.parseInt(String.valueOf(ch));
            }).toList();
    }
}
