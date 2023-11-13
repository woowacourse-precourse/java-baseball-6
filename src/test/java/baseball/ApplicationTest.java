package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

class UtilsTest extends NsTest{
    @Test
    void 메세지출력_테스트(){
        assertEquals("숫자 야구 게임을 시작합니다.", Utils.START_MESSAGE);
        assertEquals("3개의 숫자를 모두 맞히셨습니다! 게임 종료", Utils.WIN_MESSAGE);
        assertEquals("숫자를 입력해주세요 : ", Utils.INPUT_MESSAGE);
        assertEquals("낫싱", Utils.NOTHING);
        assertEquals("볼", Utils.BALL);
        assertEquals("스트라이크", Utils.STRIKE);
        assertEquals("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.", Utils.RESTART_OR_FINISH);
        assertEquals("1", Utils.START_GAME);
        assertEquals("2", Utils.END_GAME);
    }
    @Test
    void 숫자_설정_테스트() {
        assertEquals(3, Utils.DESIGNED_NUM);
        assertEquals(1, Utils.START_NUM);
        assertEquals(9, Utils.LAST_NUM);
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
