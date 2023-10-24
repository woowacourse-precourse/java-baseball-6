package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> computerRandNum; // computer의 랜덤한 수

    public void setComputerRandNum() { // computer의 랜덤수 세팅
        computerRandNum = new ArrayList<>();
        while (computerRandNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
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
