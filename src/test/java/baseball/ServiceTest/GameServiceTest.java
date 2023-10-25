package baseball.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import baseball.service.GameService;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameServiceTest {
    private GameService gameService;

    @BeforeEach
    public void setUpGameService() {
        gameService = new GameService();
    }

    @Test
    @DisplayName("사용자에게 입력받은 문자열을 숫자로 파싱된 값을 검증")
    public void 사용자_입력_파싱_검증() throws Exception {
        //given
        List<Integer> parsedInputNumber = gameService.parsingInputNumber("123");
        //when
        List<Integer> expected = List.of(1, 2, 3);
        //then
        assertEquals(parsedInputNumber, expected);
    }

    @Test
    @DisplayName("입력받은 값이 유효한 범위인지 검증")
    public void 사용자_입력_유효성_검증() throws Exception {
        //given
        //when
        /*
        4자리 숫자를 입력한 경우
         */
        assertThrows(IllegalArgumentException.class, () -> {
            gameService.parsingInputNumber("1234");
        });

        /*
        0이하의 숫자를 입력한 경우
         */
        assertThrows(IllegalArgumentException.class, () -> {
            gameService.parsingInputNumber("012");
        });

        /*
        알파벳을 입력한 경우
         */
        assertThrows(IllegalArgumentException.class, () -> {
            gameService.parsingInputNumber("a12");
        });

        /*
        입력받은 숫자에 중복되는 수가 있는 경우
         */
        assertThrows(IllegalArgumentException.class, () -> {
            gameService.parsingInputNumber("111");
        });

    }

    @Test
    @DisplayName("스트라이크와 볼 갯수의 반환값 검증")
    public void 스트라이크_볼_개수_비교() throws Exception {
        //given
        List<Integer> computerNumber = List.of(1, 2, 3);
        List<Integer> userNumber = List.of(1, 3, 9);

        //when
        List<Integer> result = gameService.playGame(computerNumber, userNumber);

        //then
        assertEquals(1, result.get(0)); // strike 1
        assertEquals(1, result.get(1)); // ball 1
    }

    @Test
    @DisplayName("얻은 스트라이크 개수가 맞는 지 검증")
    public void 스트라이크_개수_세기() throws Exception {
        //given
        List<Integer> computerNumber = List.of(1, 2, 3);
        List<Integer> userNumber = List.of(1, 2, 9);
        //when
        int strikeCount = gameService.getStrikeCount(computerNumber, userNumber);
        //then
        assertEquals(2, strikeCount);
    }

    @Test
    public void 볼_개수_세기() throws Exception {
        //given
        List<Integer> computerNumber = List.of(3, 4, 1);
        List<Integer> userNumber = List.of(1, 3, 4);
        //when
        int ballCount = gameService.getBallCount(computerNumber, userNumber);
        //then
        assertEquals(3, ballCount);
    }

}
