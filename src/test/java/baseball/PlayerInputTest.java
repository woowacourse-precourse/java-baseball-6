package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerInputTest {
    @Test
    @DisplayName("플레이어가 입력한 각 자리 숫자는 1부터 9까지의 정수이다.")
    void test1() {
        assertThat("123".chars()
                .filter(ch -> '1' > ch || ch > '9' ))
                .isEmpty();
    }

    @Test
    @DisplayName("실패 테스트 - 플레이어가 입력한 각 자리 숫자는 1부터 9까지의 정수가 아니다.")
    void test2() {
        assertThat("012".chars()
                .filter(ch -> '1' <= ch && ch <= '9')
                .count())
                .isNotEqualTo(3);
    }

    @Test
    @DisplayName("플레이어가 입력한 숫자는 3자리이다.")
    void test3() {
        String input = "123";

        assertThat(input.length()).isEqualTo(3);
    }

    @Test
    @DisplayName("실패 테스트 - 플레이어가 입력한 숫자는 3자리가 아니다.")
    void test4() {
        String input = "1234";

        assertThat(input.length()).isNotSameAs(3);
    }

    @Test
    @DisplayName("플레이어가 입력한 숫자는 전부 다르다.")
    void test5() {
        Set<Character> checkNumbers = new HashSet<>();
        char[] input = "123".toCharArray();
        boolean isPrime = true;

        for(Character ch : input) {
            if(checkNumbers.contains(ch)) {
                isPrime = false;
            }
            checkNumbers.add(ch);
        }

        assertThat(isPrime).isEqualTo(true);
    }
}
