package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    public static final int LENGTH = 3;
    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 9;
    private List<Integer> computerRandNum; // computer의 랜덤한 수

    public void setComputerRandNum() { // computer의 랜덤수 세팅
        computerRandNum = new ArrayList<>();
        while (computerRandNum.size() < LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
            if (!computerRandNum.contains(randomNumber)) {
                computerRandNum.add(randomNumber);
            }
        }
    }

    public GameResult calculateResult(List<Integer> userRandNum) {
        int ballCnt = 0, strikeCnt = 0;
        for (int i = 0; i < computerRandNum.size(); i++) {
            if (computerRandNum.get(i) == userRandNum.get(i)) {
                strikeCnt++;
                continue;
            }

            if (computerRandNum.contains(userRandNum.get(i))) {
                ballCnt++;
            }
        }
        return new GameResult(strikeCnt, ballCnt);
    }
}
