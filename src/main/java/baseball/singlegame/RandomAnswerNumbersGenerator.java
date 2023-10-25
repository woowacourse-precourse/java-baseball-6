package baseball.singlegame;

import baseball.domain.AnswerNumbers;
import baseball.domain.AnswerNumbersGenerator;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;

public final class RandomAnswerNumbersGenerator implements AnswerNumbersGenerator {

    @Override
    public AnswerNumbers create() {
        final List<Integer> randomDistinctNumbers = IntStream.generate(this::createRandomNumber)
                .distinct()
                .limit(AnswerNumbers.MAX_BASE_BALL_SIZE)
                .boxed()
                .toList();
        return AnswerNumbers.of(randomDistinctNumbers);
    }

    private int createRandomNumber() {
        return Randoms.pickNumberInRange(AnswerNumbers.MIN_BASE_BALL_NUMBER, AnswerNumbers.MAX_BASE_BALL_NUMBER);
    }
}
