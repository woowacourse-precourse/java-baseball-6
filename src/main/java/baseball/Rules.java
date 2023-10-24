package baseball;

import java.util.List;

public class Rules {    // 볼, 스트라이크 개수 규칙 관련 클래스

    private int balls;
    private int strikes;

    public Rules() {
        initBallsAndStrikes();
    }

    public void countBallsAndStrikes(List<Integer> user, List<Integer> com) {
        initBallsAndStrikes();
        for (Integer userNum : user) {
            if (!com.contains(userNum)) {
                continue;
            }
            int c_idx = com.indexOf(userNum);   // 사용자의 숫자가 저장된 상대방의 인덱스
            int u_idx = user.indexOf(userNum);  // 사용자의 숫자가 저장된 사용자의 인덱스
            if (userNum.equals(com.get(c_idx)) && c_idx != u_idx) { // 숫자는 같고 자리는 다름
                balls++;
            } else if (userNum.equals(com.get(c_idx)) && c_idx == u_idx) { // 숫자와 자리 모두 동일
                strikes++;
            }
        }
    }

    // 볼, 스트라이크 개수 세기 전 항상 0으로 초기화
    private void initBallsAndStrikes() {
        this.balls = 0;
        this.strikes = 0;
    }

    public boolean isThreeStrikes() {
        return strikes == 3;
    }

    public void printIfAnswer() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printIfNotAnswer() {
        hasNothing();
        hasBallOrStrike();
        System.out.println();   // 결과 출력 후 줄바꿈용
    }

    private void hasNothing() {
        if (balls == 0 && strikes == 0) {
            System.out.print("낫싱");
        }
    }

    // 볼 또는 스트라이크 개수 출력(둘 다 1개 이상일 시 모두 출력)
    private void hasBallOrStrike() {
        if (balls > 0) {
            System.out.print(balls + "볼 ");
        }
        if (strikes > 0) {
            System.out.print(strikes + "스트라이크");
        }
    }
}
