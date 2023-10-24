package baseball.model;

import static baseball.utils.BaseballConstantUtils.BASEBALL_NUMBERS_LENGTH;

/**
 * 컴퓨터 숫자야구 값과 유저 숫자야구 값으로 라운드 결과를 얻는 클래스입니다.
 */

public class BaseballGame {

    private final BaseballNumbers computerBaseballNumbers;
    private BaseballNumbers userBaseballNumbers;

    /**
     * BaseballNumbersGenerator 클래스의 정적 메서드를 활용하여 BaseballGame 객체 생성합니다.
     *
     * @param computerBaseballNumbers getComputerBaseballNumbers 메서드의 반환 값 사용
     * @param userBaseballNumbers     getUserBaseballNumbers 메서드의 반환 값 사용
     */

    public BaseballGame(BaseballNumbers computerBaseballNumbers, BaseballNumbers userBaseballNumbers) {
        this.computerBaseballNumbers = computerBaseballNumbers;
        this.userBaseballNumbers = userBaseballNumbers;
    }

    /**
     * 오답과 함께 라운드가 끝날 때마다 유저의 숫자야구 값을 새롭게 설정합니다.
     *
     * @param userBaseballNumbers getUserBaseballNumbers 메서드의 반환 값 사용
     */

    public void resetUserBaseballNumbers(BaseballNumbers userBaseballNumbers) {
        this.userBaseballNumbers = userBaseballNumbers;
    }

    /**
     * 현재 라운드의 볼 개수를 계산합니다.
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
     * 현재 라운드의 스트라이크 개수를 계산합니다.
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
     * 현재 라운드에서 유저가 정답을 맞췄는지 계산합니다.
     *
     * @return 숫자야구 게임의 정답 여부
     */

    public boolean isAnswer() {
        return getStrikeCount() == BASEBALL_NUMBERS_LENGTH;
    }
}
