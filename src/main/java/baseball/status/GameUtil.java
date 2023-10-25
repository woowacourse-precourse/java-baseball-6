package baseball.status;

import java.util.List;

public class GameUtil {

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
