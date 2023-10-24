package baseball;

/**
 * 게임 점수를 계산하는 클래스입니다.
 * 플레이어와 컴퓨터의 선택을 비교하여 볼과 스트라이크를 계산합니다.
 */
public class GameScore {
    private final Person person;
    private final Computer computer;

    /**
     * GameScore 객체를 생성하고, 플레이어와 컴퓨터 객체를 초기화합니다.
     *
     * @param person 플레이어 객체
     * @param computer 컴퓨터 객체
     */
    public GameScore(Person person, Computer computer) {
        this.person = person;
        this.computer = computer;
    }

    /**
     * 볼과 스트라이크의 개수를 계산합니다.
     *
     * @return 볼과 스트라이크 개수를 담은 BallStrikeCount 객체
     */
    public BallStrikeCount calculateScore() {
        BallStrikeCount ballStrikeCount = new BallStrikeCount();

        for (int i = 0; i < GameConstants.LIST_SIZE; i++) {
            int personNum = person.getNumberAt(i);

            // 컴퓨터의 숫자 목록에 사용자의 숫자가 포함되어 있는지 확인
            if (computer.containsNumber(personNum)) {
                // 볼, 스트라이크 여부를 판단하여 BallStrikeCount 객체를 업데이트
                updateBallStrikeCount(i, personNum, ballStrikeCount);
            }
        }
        return ballStrikeCount;
    }

    /**
     * 주어진 인덱스와 숫자에 따라 볼 또는 스트라이크를 판단하고,
     * BallStrikeCount 객체를 업데이트합니다.
     *
     * @param i 리스트의 인덱스
     * @param personNum 사용자의 숫자
     * @param ballStrikeCount 볼과 스트라이크 개수를 담은 객체
     */
    private void updateBallStrikeCount(int i, int personNum, BallStrikeCount ballStrikeCount) {
        // 위치와 숫자 모두 일치하면 스트라이크
        if (computer.getNumberAt(i) == personNum) {
            ballStrikeCount.increaseStrike();
            return;
        }
        // 위치는 다르지만 숫자가 일치하면 볼
        ballStrikeCount.increaseBall();
    }
}
