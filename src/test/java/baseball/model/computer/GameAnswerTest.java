package baseball.model.computer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameAnswerTest {

    private static final Integer BALL_SIZE = 3;
    private static final Integer FIRST_NUMBER = 1;
    private static final Integer LAST_NUMBER = 9;

    private GameAnswer gameAnswer;

    @BeforeEach
    void init() {
        gameAnswer = new GameAnswer();
    }

    @Test
    @DisplayName("컴퓨터는 1에서 9사이의 중복 없는 숫자 3개를 생성한다.")
    void makeAnswer_Test() {
        // when
        gameAnswer.makeAnswer();
        List<Integer> answer = gameAnswer.getAnswer();

        // then
        assertEquals(BALL_SIZE, answer.size());
        for (Integer number : answer) {
            assertTrue(number >= FIRST_NUMBER && number <= LAST_NUMBER);
        }
        assertTrue(answer.stream().distinct().count() == answer.size());
    }
}

