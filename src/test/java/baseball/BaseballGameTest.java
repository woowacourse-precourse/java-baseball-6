package baseball;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BaseballGameTest {

    @Test
    void readExitNumberExceptionTest() {
        final String input = "string";
        BaseballGame baseballGame = new BaseballGame();

        assertThatThrownBy(() -> baseballGame.readExitNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void readExitNumberTest(String input) {
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.readExitNumber(input);

        assertEquals(Integer.parseInt(input), baseballGame.exitNumber);
    }

    @Test
    void makeAnswerNumberDuplicationTest() {
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.makeAnswerNumber();

        assertThat(isDuplication(baseballGame.answerNumber)).isFalse();
    }

    private boolean isDuplication(List<Integer> number) {
        for (int i = 0; i < number.size(); i++) {
            int duplication = Collections.frequency(number, number.get(i));
            if (duplication > 1) {
                return true;
            }
        }
        return false;
    }

}
