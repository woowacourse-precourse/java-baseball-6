package domain;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballsTest extends NsTest  {

    @Test
    void 얘외_볼_숫자_아님() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("asd"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 얘외_볼_3자리_초과() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 얘외_볼_3자리_미만() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 얘외_볼_0_포함() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("120"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 얘외_볼_중복() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("121"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    /**
     *
     * 성공 하는 테스트1 , 하지만 PlayerService 안에 있는 convertStringToBaseballs() 는 private으로 작동해서 주석 처리.
     *
     *

     PlayerService playerService = new PlayerService(new Player());

     @Test
     void 예외_입력_볼_Empty() {
             assertThrows(IllegalArgumentException.class, () -> {
             playerService.convertStringToBaseballs("");
         });
     }

      * 성공 하는 테스트2 , 하지만 PlayerService 안에 있는 convertStringToBaseballs() 는 private 으로 작동해서 주석 처리.
      *
      * runException("")을 인식하지 못하는 거 같다. 그래서 runException() 내부에
      * if (args.length == 0 || args[0].isEmpty()) {
      *     throw new IllegalArgumentException("Argument must not be empty.");
      * }
      * 코드를 추가해야 할 거 같다.
     *
     @Test
     void 얘외_입력_볼_empty() {
     assertSimpleTest(() ->
            assertThatThrownBy(() -> playerService.convertStringToBaseballs(""))
            .isInstanceOf(IllegalArgumentException.class)
        );
     }
     */

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
