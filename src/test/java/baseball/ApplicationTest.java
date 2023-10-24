package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

  @Test
  @DisplayName("게임을 시작하고 정상적으로 종료한다.")
  void 게임을_시작하고_정상적으로_종료한다() {
    assertRandomNumberInRangeTest(() -> {
      run("456", "123", "2");
      assertThat(output()).contains("낫싱", "3스트라이크", "게임 종료");
    }, 1, 2, 3);
  }

  @Test
  @DisplayName("게임 종료 후 재시작을 선택한다.")
  void 게임_종료_후_재시작을_선택한다() {
    assertRandomNumberInRangeTest(() -> {
      run("246", "135", "1", "597", "589", "2");
      assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
    }, 1, 3, 5, 5, 8, 9);
  }

  @Test
  @DisplayName("볼과 스트라이크가 모두 있을 경우 볼과 스트라이크 카운트를 출력한다.")
  void 볼과_스트라이크가_모두_있을_경우_볼과_스트라이크_카운트를_출력한다() {
    assertRandomNumberInRangeTest(() -> {
      run("132", "123", "2");
      assertThat(output()).contains("2볼 1스트라이크");
    }, 1, 2, 3);
  }

  @Test
  @DisplayName("스트라이크만 있을 경우 스트라이크 카운트를 출력한다.")
  void 스트라이크만_있을_경우_스트라이크_카운트를_출력한다() {
    assertRandomNumberInRangeTest(() -> {
      run("145", "123", "2");
      assertThat(output()).contains("1스트라이크");
    }, 1, 2, 3);
  }

  @Test
  @DisplayName("볼만 있을 경우 볼 카운트를 출력한다.")
  void 볼만_있을_경우_볼_카운트를_출력한다() {
    assertRandomNumberInRangeTest(() -> {
      run("451", "123", "2");
      assertThat(output()).contains("1볼");
    }, 1, 2, 3);
  }

  @Test
  @DisplayName("볼과 스트라이크가 없을 경우 낫싱을 출력한다.")
  void 볼과_스트라이크가_없을_경우_낫싱을_출력한다() {
    assertRandomNumberInRangeTest(() -> {
      run("456", "123", "2");
      assertThat(output()).contains("낫싱");
    }, 1, 2, 3);
  }

  @Test
  @DisplayName("입력값이 숫자가 아닌 경우 예외가 발생한다.")
  void 입력값이_숫자가_아닌_경우_예외가_발생한다() {
    assertSimpleTest(() -> assertThatThrownBy(() -> runException("abc")).isInstanceOf(
        IllegalArgumentException.class));
  }

  @Test
  @DisplayName("입력값이 3자리의 수가 아닌 경우 예외가 발생한다.")
  void 입력값이_3자리의_수가_아닌_경우_예외가_발생한다() {
    assertSimpleTest(() -> assertThatThrownBy(() -> runException("1234")).isInstanceOf(
        IllegalArgumentException.class));
  }

  @Test
  @DisplayName("입력값에 중복이 있는 경우 예외가 발생한다.")
  void 입력값에_중복이_있는_경우_예외가_발생한다() {
    assertSimpleTest(() -> assertThatThrownBy(() -> runException("112")).isInstanceOf(
        IllegalArgumentException.class));
  }

  @Override
  public void runMain() {
    Application.main(new String[]{});
  }
}
