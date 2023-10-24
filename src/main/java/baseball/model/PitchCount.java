package baseball.model;

import java.util.ArrayList;
import java.util.List;

import static baseball.type.MessageType.*;

/**
 * @Class : 볼, 스트라이크, 아웃 카운트 클래스
 * @auther : SYB
 * @since : 2023/10/21
 */
public class PitchCount {

    private static final int MAX_STRIKES = 3;
    private int ballCnt;
    private int strikeCnt;
    private boolean isOut;


    public PitchCount() {
        ballCnt = 0;
        strikeCnt = 0;
        isOut = false;
    }

    /**
     * @Method : 스트라이크, 볼 카운트 계산
     * @auther : SYB
     * @since : 2023/10/21
     */
    public void evaluateStrikeAndBall(List<Integer> computerNumber, List<Integer> userNumber) {
        List<Integer> reBuildComputerNumber = new ArrayList<>();
        for (int i = 0; i < computerNumber.size(); i++) {
            if (computerNumber.get(i).equals(userNumber.get(i))) {
                strikeCnt++;
            } else {
                reBuildComputerNumber.add(computerNumber.get(i));
            }
        }

        ballCnt = (int) userNumber.stream()
                .filter(u -> reBuildComputerNumber.contains(u))
                .count();

        checkIfOut();
    }


    /**
     * @Method : 힌트 조합
     * @auther : SYB
     * @since : 2023/10/21
     */
    public String getHint() {
        StringBuilder sb = new StringBuilder();
        if (ballCnt != 0) {
            sb.append(ballCnt);
            sb.append(BALL.getMessage());
        }
        if (strikeCnt != 0) {
            if (!sb.isEmpty()) {
                sb.append(" ");
            }
            sb.append(strikeCnt);
            sb.append(STRIKE.getMessage());
        }
        if (sb.isEmpty()) {
            sb.append(NOTHING.getMessage());
        }
        return sb.toString();
    }


    /**
     * @Method : 정답 여부
     * @auther : SYB
     * @since : 2023/10/21
     */
    public boolean isAnswer() {
        return isOut;
    }


    /**
     * @Method : max strike 체크
     * @auther : SYB
     * @since : 2023/10/21
     */
    private void checkIfOut() {
        if (strikeCnt == MAX_STRIKES) {
            isOut = true;
        }
    }

    public int getBallCnt() {
        return ballCnt;
    }

    public int getStrikeCnt() {
        return strikeCnt;
    }
}