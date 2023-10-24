package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest extends NsTest {

  @Test
  @DisplayName("서로 다른 3자리 예외 테스트")
  void 서로_다른_세자리_에외_테스트() {
    assertSimpleTest(() ->
        assertThatThrownBy(() -> runException("112"))
            .isInstanceOf(IllegalArgumentException.class)
    );
  }

  @Test
  @DisplayName("자리수 예외 테스트")
  void 자리수_예외_테스트() {
    assertSimpleTest(() ->
        assertThatThrownBy(() -> runException("1234"))
            .isInstanceOf(IllegalArgumentException.class)
    );
  }

  @Test
  @DisplayName("1이상 9이하 예외 테스트")
  void _1이상_9이하_예외_테스트() {
    assertSimpleTest(() ->
        assertThatThrownBy(() -> runException("102"))
            .isInstanceOf(IllegalArgumentException.class)
    );
  }

  @Test
  @DisplayName("숫자 예외 테스트")
  void 숫자_예외_테스트() {
    assertSimpleTest(() ->
        assertThatThrownBy(() -> runException("a12"))
            .isInstanceOf(IllegalArgumentException.class)
    );
  }


  @Override
  public void runMain() {
    Application.main(new String[]{});
  }
}
