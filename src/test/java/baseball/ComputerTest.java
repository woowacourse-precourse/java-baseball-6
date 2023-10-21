package baseball;

import baseball.model.Computer;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest extends NsTest {
    @Test
    void 컴퓨터_숫자랜덤생성() {
        Computer computer = new Computer();
        List<Integer> computerNumbers = computer.generateComputerNumbers();
        assertThat(computerNumbers.size()).isEqualTo(3);
    }

    @Test
    void 컴퓨터_숫자중복값() {
        Computer computer = new Computer();
        List<Integer> computerNumbers = computer.generateComputerNumbers();
        assertThat(computerNumbers.get(0)).isNotEqualTo(computerNumbers.get(1)).isNotEqualTo(computerNumbers.get(2));

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
