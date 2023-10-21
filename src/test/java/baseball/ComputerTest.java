package baseball;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ComputerTest {

    @Test
    void 컴퓨터_숫자비교_Strike_테스트() {
        Computer computer = new Computer(Arrays.asList(1, 2, 3));

        List<Integer> testNumbers = new ArrayList<>(Arrays.asList(1, 2, 3));

        int[] expected = {3, 0};

        assertThat(computer.compareNumber(testNumbers)).isEqualTo(expected);
    }

    @Test
    void 컴퓨터_숫자비교_Ball_테스트() {
        Computer computer = new Computer(Arrays.asList(1, 2, 3));

        List<Integer> testNumbers = new ArrayList<>(Arrays.asList(4, 1, 2));

        int[] expected = {0, 2};

        assertThat(computer.compareNumber(testNumbers)).isEqualTo(expected);
    }

    @Test
    void 컴퓨터_숫자비교_StrikeAndBall_테스트() {
        Computer computer = new Computer(Arrays.asList(1, 2, 3));

        List<Integer> testNumbers = new ArrayList<>(Arrays.asList(1, 3, 2));

        int[] expected = {1, 2};

        assertThat(computer.compareNumber(testNumbers)).isEqualTo(expected);
    }

    @Test
    void 컴퓨터_숫자비교_낫싱_테스트() {
        Computer computer = new Computer(Arrays.asList(1, 2, 3));

        List<Integer> testNumbers = new ArrayList<>(Arrays.asList(4, 7, 9));

        int[] expected = {0, 0};

        assertThat(computer.compareNumber(testNumbers)).isEqualTo(expected);
    }

}
