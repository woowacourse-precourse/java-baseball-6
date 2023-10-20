package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest extends NsTest {


  //
  @Test
  void 볼인지_스트라이크인지_판별() {
    // given
    Referee referee = new Referee();
    List<Integer> givenNumbers = new ArrayList<>(Arrays.asList(5, 8, 9));
    referee.setGivenNumbers(givenNumbers);
    String test = "597";

    // when, then
    assertSimpleTest(
        () -> {
          referee.determine(test);
          assertThat(output()).contains("1볼 1스트라이크");
        }
    );

  }

  @Override
  protected void runMain() {

  }
}
