package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {


    @Test
    void 입력_성공() {
        String input1 = "789";
        if(BaseballGameNumber.validateBaseballGameNumber(input1)) {
            BaseballGameNumber number = new BaseballGameNumber(input1);
        }
    }

    @Test
    void 입력_실패() {
        String input1 = "1324";
        String input2 = "031";
        String input3 = "112";
        String input4 = "13n";

        assertThatThrownBy(()-> BaseballGameNumber.validateBaseballGameNumber(input1)
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()-> BaseballGameNumber.validateBaseballGameNumber(input2)
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()-> BaseballGameNumber.validateBaseballGameNumber(input3)
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()-> BaseballGameNumber.validateBaseballGameNumber(input4)
        ).isInstanceOf(IllegalArgumentException.class);

    }

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
