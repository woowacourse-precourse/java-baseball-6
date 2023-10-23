package baseball.domain;

import baseball.domain.computer.Computer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {

    private final Computer computer = new Computer();

    @DisplayName("Computer가 1-9 사이 서로 다른 임의의 숫자 세 개를 만드는지 확인")
    @Test
    void generateThreeRandomNumbersTest() {
        List<Integer> computerThreeNumbers = computer.getComputerThreeNumbers();

        int matchNumberCount = 0;
        for(int i = 0; i < computerThreeNumbers.size(); i++) {
            for(int j = 0; j < computerThreeNumbers.size(); j++) {
                if(i == j) continue;
                if(Objects.equals(computerThreeNumbers.get(i), computerThreeNumbers.get(j))) {
                    matchNumberCount += 1;
                }
            }
        }
        assertThat(matchNumberCount).isEqualTo(0);
    }
}
