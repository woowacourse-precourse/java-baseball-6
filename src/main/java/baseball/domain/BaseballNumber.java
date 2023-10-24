package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumber {
    private List<Integer> baseballNumber;
    private final BaseballNumberGenerator baseballNumberGenerator;
    private static final int BASEBALL_NUMBER_LEN = 3;

    public BaseballNumber(BaseballNumberGenerator baseballNumberGenerator) throws IllegalArgumentException{
        this.baseballNumberGenerator = baseballNumberGenerator;
        initBaseballNumber();
    }

    public void initBaseballNumber() throws IllegalArgumentException{
        baseballNumber = baseballNumberGenerator.generateBaseballNumber(BASEBALL_NUMBER_LEN);
    }

    public List<Integer> getBaseballNumber() {
        return new ArrayList<>(baseballNumber);
    }

    public int size() {
        return baseballNumber.size();
    }
}
