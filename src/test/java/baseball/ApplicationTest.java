package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

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


    //3개의 중복되지 않은 랜덤 숫자들을 잘 만드는 지
    @Test
    public void generateNumbers_ThreeUniqueNumbers() {
        List<Integer> numbers = Application.generateNumbers();
        assertEquals(3, numbers.size());
        assertEquals(3, new HashSet<>(numbers).size());
    }


    //랜덤 숫자를 고정 후, 스트라이크와 볼, 낫싱을 잘 계산하는 지
    @Test
    public void calResultTest(){
        List<Integer> computerNumber = new ArrayList<>(Arrays.asList(1, 2, 3));
        int[] userInput = {1,2,3};
        List<String> result = Application.calResult(userInput, computerNumber);
        assertTrue(result.contains("3스트라이크"));

    }

    @Test
    public void isDuplicateTest(){
        assertThrows(IllegalArgumentException.class, ()->Application.isDuplicate("112"));
    }

    @Test
    public void isThreeTest(){
        assertThrows(IllegalArgumentException.class, ()->Application.isThree("1234"));
    }

    @Test
    public void isNumber(){
        assertThrows(IllegalArgumentException.class, ()->Application.isNumber("abc"));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
