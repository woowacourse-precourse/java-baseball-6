package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private String number; // 컴퓨터의 서로 다른 3자리의 수

    // 서로 다른 임의의 수 3개를 선택한다.
    public void setNumber() {
        List<Integer> list = new ArrayList<>();
        while (list.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!list.contains(randomNumber)) {
                list.add(randomNumber);
            }
        }

        number = "";
        for (Integer item : list) {
            number += Integer.toString(item);
        }

    }

    // 플레이어에게 입력 받은 숫자에 대해서 힌트를 출력한다. 맞추면 true를 반환한다.
    public boolean printResult(String playerNum) {

        int strike = 0; // 스트라이크 개수
        int ball = 0; // 볼 개수

        for (int idx = 0; idx < number.length(); idx++) {
            // 스트라이크
            if (isStrike(number, playerNum, idx)) {
                strike++;
            } else {
                // 볼
                if (isBall(number, playerNum.charAt(idx))) {
                    ball++;
                }
            }
        }

        boolean result = false; // 일치 여부 결과
        String hint = ""; // 힌트 메세지 = 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱

        if (strike == 3) { // 완벽히 일치하는 경우
            hint = "3스트라이크";
            result = true;
        } else if (strike == 0 && ball == 0) { // 같은 수가 전혀 없는 경우
            hint = "낫싱";
        } else {
            if (ball > 0) {
                hint += ball + "볼 ";
            }
            if (strike > 0) {
                hint += strike + "스트라이크";
            }
        }

        System.out.println(hint);

        return result;
    }

    // 스트라이크 인지 = 두 문자열(str1, str2)의 idx 위치에 있는 문자가 같은지
    private boolean isStrike(String str1, String str2, int idx) {
        return str1.charAt(idx) == str2.charAt(idx);
    }

    // 볼 인지 = 문자열(str)이 문자(char)를 포함 하는 지
    private boolean isBall(String str, char ch) {

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                return true;
            }
        }
        return false;
    }
}
