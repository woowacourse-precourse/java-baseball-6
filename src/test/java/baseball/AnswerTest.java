package baseball;

import baseball.controller.ComputerController;
import baseball.model.GameNumber;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AnswerTest {

    GameNumber gameNumber = new GameNumber();
    ComputerController computerController = new ComputerController();

    @Test
    void 유저_입력값_정답_비교_정답() {
        String userInputString = "123";
        List<Integer> userInputNumbers = Arrays.asList(1, 2, 3);

        gameNumber.saveUserInputNumbers(userInputString, userInputNumbers);
        gameNumber.setComputerGenerateNumbers(userInputNumbers);

        assertThat(computerController.checkUserInputWithAnswer(gameNumber))
                .isEqualTo(true);
    }

    @Test
    void 유저_입력값_정답_비교_오답() {
        String userInputString = "123";
        List<Integer> userInputNumbers = Arrays.asList(1, 2, 3);
        List<Integer> answerNumbers = Arrays.asList(1, 2, 4);

        gameNumber.saveUserInputNumbers(userInputString, userInputNumbers);
        gameNumber.setComputerGenerateNumbers(answerNumbers);

        assertThat(computerController.checkUserInputWithAnswer(gameNumber))
                .isEqualTo(false);
    }
}
