package baseball;

import baseball.model.ComputerNumber;
import baseball.model.PlayerNumber;
import baseball.model.ReplayNumber;
import baseball.util.Validator;
import camp.nextstep.edu.missionutils.test.NsTest;
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
    void 컴퓨터숫자_랜덤_생성(){
        ComputerNumber computerNumber = new ComputerNumber();
        computerNumber.setGameclearNumber();

        assertThat(computerNumber.getComputerNumber().length()).isEqualTo(3);
    }

    @Test
    void 숫자이외의_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> PlayerNumber.isDigitPlayerNumber("a23"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_길이_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> PlayerNumber.isNumberLengthCorrect("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_중복_값_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> PlayerNumber.isNumberDifferent("122"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_비교_볼_검증테스트(){
        Validator validator = new Validator();
        String ComputerNumber = "123";
        String PlayerNumber = "451";

        int[] resultBall = validator.getNumberCompare(ComputerNumber,PlayerNumber);
        assertThat(resultBall[0]).isEqualTo(1);

    }

    @Test
    void 숫자_비교_스트라이크_검증테스트(){
        Validator validator = new Validator();
        String ComputerNumber = "123";
        String PlayerNumber = "124";

        int[] resultStrike = validator.getNumberCompare(ComputerNumber,PlayerNumber);
        assertThat(resultStrike[1]).isEqualTo(2);

    }
    @Test
    void 숫자_비교_볼_스트라이크_검증테스트(){
        Validator validator = new Validator();
        String ComputerNumber = "123";
        String PlayerNumber = "243";

        int[] resultCount = validator.getNumberCompare(ComputerNumber,PlayerNumber);
        assertThat(resultCount[0]).isEqualTo(1);
        assertThat(resultCount[1]).isEqualTo(1);
    }

    @Test
    void 재시작_입력_예외테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> ReplayNumber.isReplayNumberCorrect("3"))
                        .isInstanceOf(IllegalArgumentException.class)
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
