package baseball.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import baseball.service.GameService;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameServiceTest {

    @Test
    @DisplayName("사용자에게 입력받은 문자열을 숫자로 파싱된 값을 검증")
    public void 사용자_입력_파싱_검증() throws Exception {
        //given
        List<Integer> parsedInputNumber = GameService.parsingInputNumber("123");
        //when
        List<Integer> expected = List.of(1, 2, 3);
        //then
        assertEquals(parsedInputNumber, expected);
    }

    @Test
    @DisplayName("입력받은 값이 유효한 범위인지 검증")
    public void 사용자_입력_유효성_검증() throws Exception {
        /*
        4자리 숫자를 입력한 경우
         */
        assertThrows(IllegalArgumentException.class, () -> {
            GameService.parsingInputNumber("1234");
        });

        /*
        0이하의 숫자를 입력한 경우
         */
        assertThrows(IllegalArgumentException.class, () -> {
            GameService.parsingInputNumber("012");
        });

        /*
        알파벳을 입력한 경우
         */
        assertThrows(IllegalArgumentException.class, () -> {
            GameService.parsingInputNumber("a12");
        });
    }

    @Test
    @DisplayName("스트라이크와 볼 갯수의 반환값 검증")
    public void 스트라이크_볼_갯수_비교() throws Exception {
        //given
        List<Integer> computerNumber = List.of(1, 2, 3);
        List<Integer> userNumber = List.of(1, 3, 9);

        //when
        List<Integer> result = GameService.playGame(computerNumber, userNumber);

        //then
        assertEquals(1, result.get(0)); // strike 1
        assertEquals(1, result.get(1)); // ball 1
    }
}
