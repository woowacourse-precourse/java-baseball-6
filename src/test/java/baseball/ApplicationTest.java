package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import util.RandomThreeNumber;
import java.util.*;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 서로다른숫자_3개생성_테스트() {
    	String result = RandomThreeNumber.getRandomNumber();

        // 길이 검사
        assertEquals(3, result.length(), "문자열의 길이가 3이 아님!");

        // 중복 검사
        assertTrue(AllNumUnique(result), "결과 문자열의 모든 문자가 고유하지 않음!");
    }
    private boolean AllNumUnique(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        return set.size() == s.length();
    }
    
    
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}