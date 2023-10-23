package baseball;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomNumberFactory {

    private static final Random RANDOM = new Random();

    public static BaseballNumbers createRandomNumbers() {
        List<BaseballNumber> randomNumbers = RANDOM.ints(1, 10)
                .distinct()
                .limit(3)
                .mapToObj(BaseballNumber::new)
                .collect(Collectors.toList());
        return new BaseballNumbers(randomNumbers);
    }
}
