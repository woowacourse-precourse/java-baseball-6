package baseball;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ComputerTest {

    @Test
    void 랜덤값_테스트() {
        final List<Integer> comNum = Computer.randomNum();

        assertThat(comNum.size()).as("랜덤값 길이 테스트").isEqualTo(3);
        assertThat(comNum.size()).isEqualTo(new HashSet<>(comNum).size());
        for (int i : comNum) {
            assertThat(i).as("랜덤값이 1-9사이의 정수인지 테스트").isBetween(1, 9);
        }

    }
    

}
