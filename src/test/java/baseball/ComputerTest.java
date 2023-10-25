package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComputerTest {

    @Test
    public void 서로다른_랜점_숫자_제작() throws Exception {
        //given
        Computer computer = new Computer();

        for (int i = 0; i < 100; i++) {
            computer.makeAnswer();
            List<Integer> answer = computer.getAnswer();

            Assertions.assertThat(answer.size())
                    .isEqualTo(3);

            Set<Integer> set = new HashSet<>(answer);
            Assertions.assertThat(set.size())
                    .isEqualTo(3);
        }
    }

}
