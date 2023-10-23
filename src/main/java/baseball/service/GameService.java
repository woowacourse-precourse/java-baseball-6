package baseball.service;

import baseball.domain.ComputerNum;
import baseball.domain.UserNum;

public class GameService {

    private final UserNum userNum;
    private final ComputerNum computerNum;
    private int strike;
    private int ball;

    public GameService(UserNum userNum) {
        this.userNum = userNum;
        this.computerNum = new ComputerNum();
        this.strike = 0;
        this.ball = 0;
    }

    private void countStrike(boolean[] isChecked) {
        for (int i = 0; i < 3; i++) {
            if (userNum.getNum().get(i) == computerNum.get(i)) {
                this.strike++;
                isChecked[i] = true;
            }
        }
    }

    private void countBall(boolean[] isChecked) {
        for (int i = 0; i < enterNum.size(); i++) {
            if (!isChecked[i] && computerNum.contains(enterNum.get(i))) {
                ball++;
            }
        }
    }

    public boolean checkResult() {
        boolean[] checkedBall = new boolean[computerNum.size()];
        int strikeCnt = countStrike(checkedBall);
        int ballCnt = countBall(checkedBall);

        if (strikeCnt == 0 && ballCnt == 0) {
            System.out.println("낫싱");
        } else if (strikeCnt == 0 && ballCnt > 0) {
            System.out.printf("%d볼\n", ballCnt);
        } else if (ballCnt == 0 && strikeCnt > 0) {
            System.out.printf("%d스트라이크\n", strikeCnt);
        } else {
            System.out.printf("%d볼 %d스트라이크\n", ballCnt, strikeCnt);
        }

        return checkGameOver(strikeCnt);
    }

    private boolean checkGameOver(int strikeCount) {
        if (strikeCount == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }
}
