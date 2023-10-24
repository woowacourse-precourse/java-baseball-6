package baseball.domain;

import java.util.List;

public class BaseBallMount {
    private static final int VALID_BASEBALL_MOUNT_SIZE = 3;
    private static final int ZERO_START_INDEX = 0;
    private static final int EXIST_NUMBER = 1;
    public static final String INVALID_BASEBALL_MOUNT_SIZE_MESSAGE = "세자리 수를 입력해주세요";
    public static final String DUPLICATE_BASEBALL_MOUNT_MESSAGE = "각각 다른 수를 입력해주세요";

    private final List<BaseBall> baseBalls;

    public BaseBallMount(List<BaseBall> baseBalls) {
        validateSize(baseBalls);
        validateDuplication(baseBalls);

        this.baseBalls = baseBalls;
    }

    private void validateSize(List<BaseBall> baseballs) {
        if (baseballs.size() != VALID_BASEBALL_MOUNT_SIZE) {
            throw new IllegalArgumentException(INVALID_BASEBALL_MOUNT_SIZE_MESSAGE);
        }
    }

    private void validateDuplication(List<BaseBall> baseballs) {
        if (baseballs.stream().distinct().count() != VALID_BASEBALL_MOUNT_SIZE) {
            throw new IllegalArgumentException(DUPLICATE_BASEBALL_MOUNT_MESSAGE);
        }
    }
}
