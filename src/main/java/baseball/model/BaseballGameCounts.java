package baseball.model;

import java.util.Arrays;
import java.util.List;

// 일급 컬렉션
public class BaseballGameCounts {

    private static final int BALL = 0;
    private static final int STRIKE = 1;

    // 스트라이크, 볼 카운트를 저장할 변수. 초기값 (0,0)
    private final List<Integer> counts = Arrays.asList(0, 0);

    public BaseballGameCounts(ComputerNumber computer, UserNumber user) {
        // 일급 컬렉션 객체에서 컬렉션 추출
        List<Integer> computerNum = computer.getComputerNumber();
        List<Integer> userNum = user.getUserNumber();
        this.checkStrikes(computerNum, userNum);
        this.checkBalls(computerNum, userNum);
    }

    // 입력받은 유저 번호에 따라 스트라이크를 체크하는 함수
    private void checkStrikes(List<Integer> computerNum, List<Integer> userNum) {
        for (int idx = 0; idx <userNum.size(); idx++) {
            addStrikeCounts(computerNum, userNum, idx);
        }
    }

    private void addStrikeCounts(List<Integer> computerNum, List<Integer> userNum, Integer idx) {
        if (userNum.get(idx).equals(computerNum.get(idx))) {
            counts.set(STRIKE, counts.get(STRIKE) + 1);
        }
    }

    // 입력받은 유저 번호에 따라 볼을 체크하는 함수
    private void checkBalls(List<Integer> computerNum, List<Integer> userNum) {
        Integer ballCounts = 0;
        for (Integer userNumberDigit : userNum) {
            ballCounts = addBallCounts(computerNum, userNumberDigit, ballCounts);
        }

        ballCounts -= counts.get(STRIKE);
        counts.set(BALL, ballCounts);
    }

    private Integer addBallCounts(List<Integer> computerNum, Integer userNumberDigit, Integer ballCounts) {
        if (computerNum.contains(userNumberDigit)) {
            ballCounts++;
        }
        return ballCounts;
    }

    // 카운트가 승리 조건을 만족하는 지 체크하는 함수
    public boolean isWinCondition() {
        return counts.get(STRIKE).equals(3);
    }

    // 카운트 수를 반환하는 함수. 추후에 메시지 생성에 사용
    public List<Integer> getCounts() {
        return counts;
    }

}
