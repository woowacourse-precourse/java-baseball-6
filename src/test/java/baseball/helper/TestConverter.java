package baseball.helper;

import baseball.model.Number;
import java.util.List;

public class TestConverter {

    public static List<Number> makeNumberList(final String input) {
        return input.chars()
                .mapToObj(number -> new Number(Character.getNumericValue(number)))
                .toList();
    }
}
