package baseball.domain;

import java.util.List;

/**
 * 피칭 역할. 책임: 야구공들에 대한 검증, 야구공들의 스트라이크 카운트, 볼 카운트
 */
public class Pitch {
    public static final String INVALID_BASEBALL_MOUNT_SIZE_MESSAGE = "세자리 수를 입력해주세요";
    public static final String DUPLICATE_BASEBALL_MOUNT_MESSAGE = "각각 다른 수를 입력해주세요";

    private final int maxStrikeCount;
    private final List<BaseBall> baseBallList;

    public Pitch(int maxStrikeCount, List<BaseBall> baseBallList) {
        this.maxStrikeCount = maxStrikeCount;

        validateBaseBallList(baseBallList);
        this.baseBallList = baseBallList;
    }

    public int calculateStrikeCount(Pitch otherPitch) {
        int count = 0;
        for (int i = 0; i < baseBallList.size(); i++) {
            if (baseBallList.get(i).equals(otherPitch.baseBallList.get(i))) {
                count++;
            }
        }
        return count;
    }

    public int calculateBallCount(Pitch otherPitch) {
        int count = 0;
        for (int i = 0; i < baseBallList.size(); i++) {
            if (!baseBallList.get(i).equals(otherPitch.baseBallList.get(i))
                    && baseBallList.contains(otherPitch.baseBallList.get(i))) {
                count++;
            }
        }
        return count;
    }

    private void validateBaseBallList(List<BaseBall> baseBalls) {
        validateSize(baseBalls);
        validateDuplication(baseBalls);
    }

    private void validateSize(List<BaseBall> baseballs) {
        if (baseballs.size() != maxStrikeCount) {
            throw new IllegalArgumentException(INVALID_BASEBALL_MOUNT_SIZE_MESSAGE);
        }
    }

    private void validateDuplication(List<BaseBall> baseballs) {
        if (baseballs.stream().distinct().count() != maxStrikeCount) {
            throw new IllegalArgumentException(DUPLICATE_BASEBALL_MOUNT_MESSAGE);
        }
    }

}
