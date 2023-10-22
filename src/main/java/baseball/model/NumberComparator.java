package baseball.model;

public class NumberComparator {
    private int strikes = 0;
    private int balls = 0;

    /**
     * 볼, 스트라이크 개수 세기
     */
    public int[] calculateResult(String userNumber, String programNumber) {
        resetResult();
        checkBall(userNumber, programNumber);
        checkStrike(userNumber, programNumber);
        updateBall();

        return new int[]{balls, strikes};
    }

    /**
     * 새로운 게임이 시작되었을 때, 기존 게임의 결과 초기화
     */
    private void resetResult() {
        strikes = 0;
        balls = 0;
    }

    /**
     * 볼 개수 체크
     */
    private void checkBall(String userNumber, String programNumber) {
        for (int i = 0; i < userNumber.length(); i++) {
            if (programNumber.contains(String.valueOf(userNumber.charAt(i)))) {
                balls++;
            }
        }
    }

    /**
     * 스트라이크 개수 체크
     */
    private void checkStrike(String userNumber, String programNumber) {
        for (int i = 0; i < userNumber.length(); i++) {
            if (userNumber.charAt(i) == programNumber.charAt(i)) {
                strikes++;
            }
        }
    }

    /**
     * 스트라이크, 볼 개수 조정 위 로직에는 볼 개수를 셀 때, 스트라이크인 숫자를 제외하는 기능이 없다.
     */
    private void updateBall() {
        balls -= strikes;
        if (balls < 0) {
            balls = 0;
        }
    }

    /**
     * 전부 스트라이크면 true반환
     */
    public boolean isAllStrike(int numberSize) {
        return strikes == numberSize;
    }
}
