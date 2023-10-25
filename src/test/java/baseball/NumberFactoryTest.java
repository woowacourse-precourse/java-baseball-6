package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class NumberFactoryTest {

    @Test
    @DisplayName("생성된 숫자의 자릿수가 파라미터에 따라 올바르게 나오는지 테스트")
    void createNumberDigitSizeTest() {
        int digitSize = 3;

        int number = NumberFactory.createNumber(digitSize);
        int numberLength = String.valueOf(number).length();

        assertThat(numberLength).isEqualTo(digitSize);
    }

    @Test
    @DisplayName("생성된 숫자가 자릿수 별로 중복이 없는지 테스트")
    @RepeatedTest(100)
    void createNumberDuplicationTest() {
        int digitSize = Randoms.pickNumberInRange(1,9);
        int number = NumberFactory.createNumber(digitSize);

        String num = String.valueOf(number);
        Set<Character> set = new HashSet<>();

        for (char c : num.toCharArray()) {
            set.add(c);
        }

        assertThat(set.size()).isEqualTo(num.length());
    }
}