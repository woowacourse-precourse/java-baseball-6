package baseball;

import exceptions.InvalidNumberException;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComputerPlayerTest {

    GameRule rule;
    ComputerPlayer computerPlayer;
    RandomNumberGenerator randomNumberGenerator;
    BaseBallNumber userGuess;

    @BeforeEach
    void init() {
        // given
        rule = new GameRule(3, 1, 9);
        computerPlayer = new ComputerPlayer(rule);
        userGuess = new BaseBallNumber(rule);
    }

    @Test
    void 입력값의_유효성_검사() {
        // when
        List<String> invalidInputs = List.of(new String[]{"13", "111", "102"});
        // then
        for (int i = 0; i < invalidInputs.size(); i++) {
            String input = invalidInputs.get(i);
            Assertions.assertThrows(InvalidNumberException.class,
                    () -> userGuess.setUserInput(input));
        }
    }

    @Test
    void 서로_다른_유효한_범위의_숫자_세_개_생성() {
        // when
        List<Integer> goalNumber = randomNumberGenerator.getNonDuplicateNumbers(rule);
        StringBuilder sb = new StringBuilder();
        for (Integer n : goalNumber) {
            sb.append(n.toString());
        }
        // then
        Assertions.assertDoesNotThrow(() -> userGuess.setUserInput(sb.toString()));

    }

}
