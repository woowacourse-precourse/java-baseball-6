package baseball.domain;

import java.util.List;
import java.util.stream.IntStream;

public class ComputerBaseballs extends AbstractBaseballs {
    private static final int FIRST_INDEX = 0;
    private static final int EXIST_NUMBER = 1;

    public ComputerBaseballs(List<Baseball> baseballs) {
        super(baseballs);
    }

    public int countStrike(UserBaseballs userBaseballs) {
        return (int) IntStream.range(FIRST_INDEX, BASEBALLS_SIZE)
                .filter(i -> isStrike(i, userBaseballs))
                .count();
    }

    public int countBall(UserBaseballs userBaseballs) {
        return (int) IntStream.range(FIRST_INDEX, BASEBALLS_SIZE)
                .filter(i -> isBall(i, userBaseballs))
                .count();
    }

    private boolean isStrike(int i, UserBaseballs userBaseballs) {
        return baseballs.get(i).equals(userBaseballs.baseballs.get(i));
    }

    private boolean isBall(int i, UserBaseballs userBaseballs) {
        if (isStrike(i, userBaseballs)) {
            return false;
        }

        long numberOfMatches = userBaseballs.baseballs.stream()
                .filter(baseball -> baseball.equals(this.baseballs.get(i)))
                .count();
        return EXIST_NUMBER == numberOfMatches;
    }
}
