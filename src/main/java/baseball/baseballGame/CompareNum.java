package baseball.baseballGame;

import java.util.HashMap;
import java.util.Map;

/**
 * 컴퓨터 숫자와 사용자가 입력한 숫자 비교
 */
public class CompareNum {
    public Map<String, Integer> compare(int computerNum, int inputNum) {
        Map<String, Integer> map = new HashMap<>();
        map.put("strike", 0);
        map.put("ball", 0);
        boolean[] ch = new boolean[10]; // ball 여부 확인 위한 배열
        int inputNum2 = inputNum;

        // 스트라이크 확인
        while (computerNum > 0) {
            int computerDigit = computerNum % 10;
            int inputDigit = inputNum % 10;

            if (computerDigit == inputDigit) { // 숫자 일치하면 strike
                map.put("strike", map.get("strike") + 1);
            } else { //  아니면 ball 여부 확인 위해 ch 배열에 체크
                ch[computerDigit] = true;
            }

            computerNum /= 10;
            inputNum /= 10;
        }

        // 볼 확인
        while (inputNum2 > 0) {
            int digit = inputNum2 % 10;

            if (ch[digit]) {
                map.put("ball", map.get("ball") + 1);
            }

            inputNum2 /= 10;
        }

        return map;
    }


}
