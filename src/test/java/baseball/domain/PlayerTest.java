package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PlayerTest {

    @Test
    void 사용자_입력_초기화() {
        List<Integer> inputNumbers = List.of(1, 2, 3);

        Player player = new Player(inputNumbers);

        List<Integer> playersInputAnswer = player.getInputAnswer();
        Assertions.assertEquals(inputNumbers,playersInputAnswer);
    }
}
