package baseball.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GameServiceTest {

    @Test
    @DisplayName("컴퓨터 숫자와 사용자 숫자를 비교하여, 낫싱이 나오는 케이스를 테스트한다.")
    void testNothingCase() {
        List<Integer> computerNumber = List.of(1, 2, 3);
        List<Integer> userNumber = List.of(4, 5, 6);

        GameService gameService = new GameService();
        String compareResult = gameService.getCompareResult(computerNumber, userNumber);

        Assertions.assertThat(compareResult).isEqualTo("낫싱");
    }
}
