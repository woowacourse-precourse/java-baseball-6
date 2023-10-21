package domain;


import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumbersGenerator {

    private final int MAX_VALUE = 9;
    private final int MIN_VALUE = 1;
    private final int BALL_SIZE = 3;

    public List<Integer> generateNumbers() {
        List<Integer> numberList = IntStream.generate(() ->
                        Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE))
                .distinct()
                .limit(BALL_SIZE)
                .boxed()
                .collect(Collectors.toList());
        return numberList;
    }

}
