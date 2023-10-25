package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import model.NumberGenerator;
import model.NumberInput;
import org.junit.jupiter.api.Test;
import player.Computer;

import java.util.HashSet;
import java.util.Set;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 컴퓨터_랜덤생성_볼_테스트() {
        Computer computer = new Computer();
        int ball = computer.ballCount("123", "435");
        assertThat(ball).isEqualTo(1);
    }

    @Test
    void 컴퓨터_랜덤생성_스트라이크_테스트() {
        Computer computer = new Computer();
        int strike = computer.strikeCount("123", "125");
        assertThat(strike).isEqualTo(2);
    }

    @Test
    void 스트라이크_3개_테스트() {
        Computer computer = new Computer();
        computer.strikeCount("123", "123");
        assertThat(computer.getIsThreeStrike()).isEqualTo(true);
    }

    @Test
    void 컴퓨터_랜덤생성_길이테스트() {
        NumberGenerator computerNumber = new NumberGenerator();
        String generatedNumber = computerNumber.getGeneratedNumber();

        assertThat(generatedNumber.length()).isEqualTo(3);
    }
    @Test
    void 컴퓨터_랜덤생성_중복테스트() {
        NumberGenerator computerNumber = new NumberGenerator();
        Set<Integer> computerNumberSet = new HashSet<>();

        for(int i = 0; i < computerNumber.getGeneratedNumber().length(); i++) {
            computerNumberSet.add(computerNumber.getGeneratedNumber().charAt(i) - '0');
        }
        assertThat(computerNumberSet.size()).isEqualTo(3);
    }

    @Test
    void 입력_숫자_길이_테스트() {
        assertThatThrownBy(() -> NumberInput.checkLength("1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력_숫자_Digit_테스트() {
        assertThatThrownBy(() -> NumberInput.checkDigit("ABC"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력_숫자_중복_테스트() {
        assertThatThrownBy(() -> NumberInput.checkDuplication("112"))
                .isInstanceOf(IllegalArgumentException.class);
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
