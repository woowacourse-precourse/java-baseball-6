package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;


public class ComputerTest {


  @Test
  void 컴퓨터생성_후_서로_다른지() {
    Computer computer1 = new Computer();
    Computer computer2 = new Computer();
    assertThat(computer1.equals(computer2)).isEqualTo(false);
  }
}
