package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.game.ComputerGame;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    /**
     * UserInput에 대한 예외테스트
     */
    @DisplayName("사용자의 Input 테스트")
    @Test
    void 입력값_예외_테스트() {
        moreSimpleInputExceptionTest("acb");
        moreSimpleInputExceptionTest("000");
        moreSimpleInputExceptionTest("310");
        moreSimpleInputExceptionTest("acb");
        moreSimpleInputExceptionTest("acb");
        moreSimpleInputExceptionTest("acb");
        moreSimpleInputExceptionTest("acb");
    }

    void moreSimpleInputExceptionTest(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    /**
     * 컴퓨터 Random 값 생성 테스트
     */
    @DisplayName("컴퓨터(상대방)의 랜덤값 정상 생성 테스트 ")
    @Test
    void 컴퓨터_랜덤값_테스트() {
        ComputerGame game = new ComputerGame();
        String random = game.getComputerRandomNumber();

        랜덤값_길이_테스트(random);
        랜덤값_중복_테스트(random);
    }

    void 랜덤값_길이_테스트(String random) {
        assertThat(random.length()).isEqualTo(3);
    }

    void 랜덤값_중복_테스트(String random) {
        boolean chk1 = !random.substring(0, 1).equals(random.substring(1, 2));
        boolean chk2 = !random.substring(0, 1).equals(random.substring(2, 3));
        boolean chk3 = !random.substring(1, 2).equals(random.substring(2, 3));
        assertTrue(chk1 && chk2 && chk3);
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