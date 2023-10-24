package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    void 입력_테스트() {
        String inputString = "123";
        입력_받은_수의_에러_여부(inputString);
        입력_받은_문자를_숫자_배열로_변환(inputString).forEach(System.out::println);
    }

    @Test
    void 입력_받은_수의_에러_여부(String inputString) {
        char[] characters = inputString.toCharArray();
        Integer count = 0; //입력한 문자가 3자리 인지 확인하는 변수

        for (char ch : characters) {
            count+=1;
            //입력한 문자가 숫자로 이루어져 있는지
            if(!Character.isDigit(ch)) {
                throw new IllegalArgumentException("input value is not number");
            }
        }
        //입력한 문자가 3자리 인지
        if(count!=3) {
            throw new IllegalArgumentException("input number is not 3 characters long. ");
        }
    }
    @Test
    List<Integer> 입력_받은_문자를_숫자_배열로_변환(String inputString) {
        return Arrays.stream(inputString.split(" "))
                .mapToInt(Integer::parseInt)
                .boxed().toList();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
