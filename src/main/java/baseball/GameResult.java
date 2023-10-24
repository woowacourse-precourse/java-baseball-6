package baseball;

import baseball.enums.GameResultType;

/**
 * 게임 결과
 */
public class GameResult {

    private int ballCount;
    private int strikeCount;

    /**
     * 볼 카운트를 1 증가
     */
    public void plusBallCount() {
        ballCount++;
    }

    /**
     * 스트라이크 카운트를 1 증가
     */
    public void plusStrikeCount() {
        strikeCount++;
    }

    /**
     * 게임이 종료되었는지 여부를 반환(스트라이크 개수와 게임에서 사용할 숫자 개수가 같으면 종료)
     * @return 게임 종료 여부
     */
    public boolean isEnd() {
        return strikeCount == GameDetail.NUM_COUNT;
    }

    /**
     * 게임 결과를 문자열로 반환
     * @return 포맷에 맞춰진 게임 결과 문자열
     */
    public String returnResultToString() {
        if (ballCount == 0 && strikeCount == 0) {
            return GameResultType.NOTHING.getResultString();
        }
        if (ballCount == 0) {
            // n스트라이크
            return strikeCount + GameResultType.STRIKE.getResultString();
        }
        if (strikeCount == 0) {
            // n볼
            return ballCount + GameResultType.BALL.getResultString();
        }
        return ballCount + GameResultType.BALL.getResultString() + " " + strikeCount + GameResultType.STRIKE.getResultString();
    }

}
