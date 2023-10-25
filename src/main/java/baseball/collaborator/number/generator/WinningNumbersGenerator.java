package baseball.collaborator.number.generator;

import baseball.io.Randoms;
import java.util.List;
import java.util.stream.Stream;

public class WinningNumbersGenerator implements NumbersGenerator {

    @Override
    public List<Integer> generate() {
        return Stream.generate(Randoms::getSingleNumber)
                .distinct()
                .limit(NUMBERS_SIZE)
                .toList();
    }

}
