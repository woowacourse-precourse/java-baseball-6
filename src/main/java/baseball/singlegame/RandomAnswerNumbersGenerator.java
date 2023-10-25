package baseball.singlegame;

import baseball.domain.AnswerNumbers;
import baseball.domain.AnswerNumbersGenerator;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class RandomAnswerNumbersGenerator implements AnswerNumbersGenerator {

    @Override
    public AnswerNumbers create() {
        final Set<Integer> randomDistinctNumbers = IntStream.generate(this::createRandomNumber)
                .distinct()
                .limit(AnswerNumbers.MAX_BASE_BALL_SIZE)
                .boxed()
                .collect(Collectors.toSet());
        return AnswerNumbers.of(randomDistinctNumbers);
    }

    private int createRandomNumber() {
        return Randoms.pickNumberInRange(AnswerNumbers.MIN_BASE_BALL_NUMBER, AnswerNumbers.MAX_BASE_BALL_NUMBER);
    }
}
