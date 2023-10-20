package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ComputerTest extends NsTest {


  @Test
  void 컴퓨터생성_후_서로_다른지() {
    Computer computer1 = new Computer();
    Computer computer2 = new Computer();
    assertThat(computer1.equals(computer2)).isEqualTo(false);
  }
  @Override
  public void runMain() {
    Application.main(new String[]{});
  }
}
