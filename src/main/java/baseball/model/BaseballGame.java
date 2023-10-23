package baseball.model;

import static baseball.utils.BaseballConstantUtils.BASEBALL_NUMBERS_LENGTH;

/**
 * 컴퓨터 숫자와 유저 숫자로 진행하는 숫자야구 게임
 */

public class BaseballGame {

    private final BaseballNumbers computerBaseballNumbers;
    private BaseballNumbers userBaseballNumbers;

    /**
     * BaseballNumbersGenerator 클래스의 정적 메서드를 활용해 BaseballGame 객체 생성
     *
     * @param computerBaseballNumbers getComputerBaseballNumbers 메서드의 반환 값 사용
     * @param userBaseballNumbers     getUserBaseballNumbers 메서드의 반환 값 사용
     */

    public BaseballGame(BaseballNumbers computerBaseballNumbers, BaseballNumbers userBaseballNumbers) {
        this.computerBaseballNumbers = computerBaseballNumbers;
        this.userBaseballNumbers = userBaseballNumbers;
    }

    /**
     * 게임이 끝날 때마다 변경되어야 하는 유저숫자를 재설정
     *
     * @param userBaseballNumbers getUserBaseballNumbers 메서드의 반환 값 사용
     */

    public void resetUserBaseballNumbers(BaseballNumbers userBaseballNumbers) {
        this.userBaseballNumbers = userBaseballNumbers;
    }

    /**
     * BaseballGame 객체 내의 컴퓨터 숫자와 유저숫자로 볼 카운트 계산
     *
     * @return 계산한 볼 카운트 값
     */

    public int getBallCount() {
        int ballCount = 0;
        for (int index = 0; index < BASEBALL_NUMBERS_LENGTH; index++) {
            BaseballNumber userBaseballNumber = userBaseballNumbers.getBaseballNumber(index);
            BaseballNumber randomBaseballNumber = computerBaseballNumbers.getBaseballNumber(index);
            if (!userBaseballNumber.equals(randomBaseballNumber)
                    && computerBaseballNumbers.containsBaseballNumber(userBaseballNumber)) {
                ballCount++;
            }
        }
        return ballCount;
    }

    /**
     * BaseballGame 객체 내의 컴퓨터 숫자와 유저숫자로 스트라이크 카운트 계산
     *
     * @return 계산한 스트라이크 카운트 값
     */

    public int getStrikeCount() {
        int strikeCount = 0;
        for (int index = 0; index < BASEBALL_NUMBERS_LENGTH; index++) {
            BaseballNumber userBaseballNumber = userBaseballNumbers.getBaseballNumber(index);
            BaseballNumber randomBaseballNumber = computerBaseballNumbers.getBaseballNumber(index);
            if (userBaseballNumber.equals(randomBaseballNumber)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    /**
     * 현 상태의 userBaseballNumbers가 computerBaseballNumbers와 일치하는 지 검사
     *
     * @return 숫자야구 게임의 정답 여부
     */

    public boolean isAnswer() {
        return getStrikeCount() == BASEBALL_NUMBERS_LENGTH;
    }
}
