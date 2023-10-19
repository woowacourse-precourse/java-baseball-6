package baseball.validator;

import baseball.domain.ComputerNum;
import baseball.domain.EnterNum;

import java.util.ArrayList;
import java.util.List;

public class ResultValidator {

    private List<Integer> enterNum;
    private final List<Integer> computerNum;

    public ResultValidator(ComputerNum cNum) {
        this.enterNum = new ArrayList<>();
        this.computerNum = cNum.getNum();
    }

    public void enterCheckNum(EnterNum eNum) {
        enterNum = eNum.getNum();
    }

    private int countStrike(boolean[] isChecked) {
        int strike = 0;
        for (int i = 0; i < computerNum.size(); i++) {
            if (enterNum.get(i) == computerNum.get(i)) {
                strike++;
                isChecked[i] = true;
            }
        }

        return strike;
    }

    private int countBall(boolean[] isChecked) {
        int ball = 0;
        for (int i = 0; i < enterNum.size(); i++) {
            if (!isChecked[i] && computerNum.contains(enterNum.get(i))) {
                ball++;
            }
        }
        return ball;
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
