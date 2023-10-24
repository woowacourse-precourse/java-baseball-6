package baseball.service;

import baseball.dto.Result;

/**
 * 게임 한 판을 진행 하기 위한 로직을 담은 클래스
 */
public class GameLogic {
    /**
     * 난수와 사용자 입력값을 비교하면서 결과를 업데이트
     *
     * @param playerNumberBall   사용자가 제시한 값의 정보를 담은 배열
     * @param computerNumberBall 난수 정보를 담은 배열
     * @param result             사용자의 추측에 대한 결과를 담아줄 객체
     */
    public void play(int[] playerNumberBall, int[] computerNumberBall, Result result) {
        for (int i = 1; i < 10; i++) {
            ballCount(playerNumberBall, computerNumberBall, result, i);
            strikeCount(playerNumberBall, computerNumberBall, result, i);
        }
        answerCheck(result);
    }

    /**
     * ball인지 확인
     *
     * @param playerNumberBall   사용자가 제시한 값의 정보를 담은 배열
     * @param computerNumberBall 난수 정보를 담은 배열
     * @param result             ball 갯수를 업데이트 하여 반환할 객체
     * @param idx                1~9까지의 숫자
     */
    public void ballCount(int[] playerNumberBall, int[] computerNumberBall, Result result, int idx) {

        if (computerNumberBall[idx] != 0 && playerNumberBall[idx] != 0
                && computerNumberBall[idx] != playerNumberBall[idx]) {
            result.setBall(result.getBall() + 1);
        }

    }

    /**
     * strike인지 확인
     *
     * @param playerNumberBall   사용자가 제시한 값의 정보를 담은 배열
     * @param computerNumberBall 난수 정보를 담은 배열
     * @param result             strike 갯수를 업데이트 하여 반환할 객체
     * @param idx                1~9까지의 숫자
     */
    public void strikeCount(int[] playerNumberBall, int[] computerNumberBall, Result result, int idx) {

        if (computerNumberBall[idx] != 0 && computerNumberBall[idx] == playerNumberBall[idx]) {
            result.setStrike(result.getStrike() + 1);

        }

    }

    /**
     * 정답 여부를 확인하고 result객체를 업데이트
     *
     * @param result 추측에 대한 결과를 담은 객체
     */
    public void answerCheck(Result result) {
        if (result.getStrike() == 3) {
            result.setStatus(Result.ANSWER);
        }
    }

    /**
     * 결과 객체의 정보를 지움.
     *
     * @param result 결과 객체
     */
    public void resultClear(Result result) {
        if (result.isStatus() == Result.WRONG) {
            result.setBall(0);
            result.setStrike(0);
        }
    }
}
