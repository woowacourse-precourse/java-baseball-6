package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RefereeTest extends NsTest {

  @Test
  void 볼인지_스트라이크인지_판별() {
    // given
    Player player = new Player();
    Referee referee = new Referee(player);
    List<Integer> givenNumbers = new ArrayList<>(Arrays.asList(5, 8, 9));
    referee.setGivenNumbers(givenNumbers);
    player.setInput("597");
    // when, then
    referee.determine(player);
    assertThat(output()).contains("1볼 1스트라이크");
  }

  @Test
  void 볼인지_스트라이크인지_판별1() {
    // given
    Player player = new Player();
    player.setInput("597");
    Referee referee = new Referee(player);
    List<Integer> givenNumbers = new ArrayList<>(Arrays.asList(5, 8, 9));
    referee.setGivenNumbers(givenNumbers);

//     when, then
    assertSimpleTest(
        () -> {
          referee.determine(player);
          assertThat(output()).contains("1볼 1스트라이크");
        }
    );
  }

  @Override
  protected void runMain() {
  }
}
