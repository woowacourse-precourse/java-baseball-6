package baseball;

import java.util.List;

public class Baseballs {
    public static final int ZERO_INDEX = 0;
    public static final int BASEBALLS_SIZE = 3;

    private final List<Baseball> baseballs;

    public Baseballs(List<Baseball> baseballs) {
        validateSize(baseballs);
        validateDuplicate(baseballs);
        this.baseballs = baseballs;
    }

    private void validateSize(List<Baseball> baseballs) {
        if (baseballs.size() != BASEBALLS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 숫자의 개수가 올바르지 않습니다.(세 자리 숫자만 입력 가능합니다");
        }
    }

    private void validateDuplicate(List<Baseball> baseballs) {
        if (baseballs.stream().distinct().count() != BASEBALLS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 중복되는 숫자가 존재합니다.(1-9까지 서로 다른 숫자 3개를 입력해주세요)");
        }
    }

    public int countStrike(Baseballs userBaseballs) {
        int strikeCount = 0;
        for (int index = ZERO_INDEX; index < BASEBALLS_SIZE; index++) {
            if (baseballs.get(index).equals(userBaseballs.baseballs.get(index))) {
                strikeCount += 1;
            }
        }
        return strikeCount;
    }

    public int countBall(Baseballs userBaseballs) {
        int ballCount = 0;
        for (int index = ZERO_INDEX; index < BASEBALLS_SIZE; index++) {
            if (!baseballs.get(index).equals(userBaseballs.baseballs.get(index)) && baseballs.contains(userBaseballs.baseballs.get(index))) {
                ballCount += 1;
            }
        }
        return ballCount;
    }
}
