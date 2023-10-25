package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class PlayerNumbersTest {

    @Test
    @DisplayName("사용자가 입력한 숫자들이 중복되면 예외가 발생한다.")
    void playerNumbersTest1() {
        List<Integer> input = Arrays.asList(1, 1, 2);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new PlayerNumbers(input);
        });
    }

    @Test
    @DisplayName("사용자가 입력한 숫자들이 두자리 이하면 예외가 발생한다.")
    void playerNumbersTest2() {
        List<Integer> input = List.of(1, 3);

        Assertions.assertThrows(IllegalArgumentException.class, () -> new PlayerNumbers(input));
    }

    @Test
    @DisplayName("사용자가 입력한 숫자들이 네자리 이상이면 예외가 발생한다.")
    void playerNumbersTest3() {
        List<Integer> input = List.of(1, 2, 3, 4);

        Assertions.assertThrows(IllegalArgumentException.class, () -> new PlayerNumbers(input));
    }

    @Test
    @DisplayName("사용자가 입력한 숫자가 없으면 예외가 발생한다.")
    void playerNumbersTest4() {
        List<Integer> input = List.of();

        Assertions.assertThrows(IllegalArgumentException.class, () -> new PlayerNumbers(input));
    }

    @Test
    @DisplayName("사용자가 중복되지 않은 세자리 숫자를 읿력하면 리스트에 저장된다.")
    void playerNumbersTest5() {
        List<Integer> input = List.of(1, 2, 3);
        PlayerNumbers playerNumbers = new PlayerNumbers(input);

        for(int index = 0; index < input.size(); index++) {
            Assertions.assertEquals(playerNumbers.get(index), (int) input.get(index));
        }
    }
}