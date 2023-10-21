package baseball.model;

import baseball.converter.IntegerInputConverter;
import baseball.converter.StringInputConverter;
import java.util.stream.IntStream;

public class StrikeRule implements GameRule {

    @Override
    public int calculate(final int hitter, final int pitcher) {
        String[] origin = StringInputConverter.toArray(IntegerInputConverter.toString(hitter));
        String[] test = StringInputConverter.toArray(IntegerInputConverter.toString(pitcher));

        return (int) IntStream.range(0, origin.length)
                .filter(i -> origin[i].equals(test[i]))
                .count();
    }
}
