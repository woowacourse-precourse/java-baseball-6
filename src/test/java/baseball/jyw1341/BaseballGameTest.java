package baseball.jyw1341;

import baseball.BallCount;
import baseball.BaseballGame;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class BaseballGameTest {

    @Test
    void testChangeStringToDigit(){
        String num = "13582";

        List<Integer> digitList = changeStringToDigit(num);

        Assertions.assertEquals(digitList.get(0), 1);
        Assertions.assertEquals(digitList.get(1), 3);
        Assertions.assertEquals(digitList.get(2), 5);
        Assertions.assertEquals(digitList.get(3), 8);
        Assertions.assertEquals(digitList.get(4), 2);
    }

    List<Integer> changeStringToDigit(String numberFromPlayer) {
        ArrayList<Integer> digitList = new ArrayList<>();

        for (int i = 0; i < numberFromPlayer.length(); i++) {
            char digitChar = numberFromPlayer.charAt(i); // 각 자리의 문자를 가져옴
            int digit = Character.getNumericValue(digitChar); // 문자를 정수로 변환
            digitList.add(digit); // 정수를 리스트에 추가
        }

        return digitList;
    }

}