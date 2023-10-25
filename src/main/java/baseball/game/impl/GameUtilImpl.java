package baseball.game.impl;

import static baseball.status.GameSetting.COUNT_NUM;
import static baseball.status.GameSetting.MAX_NUM;
import static baseball.status.GameSetting.MIN_NUM;

import baseball.game.GameUtil;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameUtilImpl implements GameUtil {

    /**
     * 컴퓨터 수 설정
     *
     * @return 컴퓨터 수
     */
    public List<Integer> setComputerNum() {
        List<Integer> computerNum = new ArrayList<>();
        while (computerNum.size() < COUNT_NUM.getValue()) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUM.getValue(), MAX_NUM.getValue());
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }

        return computerNum;
    }

    /**
     * 볼, 스트라이크 개수 계산
     *
     * @param computerNum 컴퓨터 수
     * @param inputNum    입력 수
     * @return [ball 개수, strike 개수] 형태
     */
    public int[] calculateResult(List<Integer> computerNum, List<Integer> inputNum) {
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            int num = inputNum.get(i);
            if (computerNum.contains(num)) {
                if (computerNum.indexOf(num) == i) {
                    strike++;
                } else {
                    ball++;
                }
            }
        }
        return new int[]{ball, strike};
    }
}
