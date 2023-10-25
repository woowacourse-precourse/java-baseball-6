package baseball;

import baseball.controller.ComputerController;
import baseball.model.GameNumber;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class HintTest extends NsTest {

    OutputView outputView = new OutputView();
    GameNumber gameNumber = new GameNumber();
    ComputerController computerController = new ComputerController();

    @Test
    void 힌트_낫싱() {
        String userInputString = "123";
        List<Integer> userInputNumbers = Arrays.asList(1, 2, 3);
        List<Integer> answerNumbers = Arrays.asList(4, 5, 6);

        gameNumber.saveUserInputNumbers(userInputString, userInputNumbers);
        gameNumber.setComputerGenerateNumbers(answerNumbers);
        computerController.checkUserInputWithAnswer(gameNumber);
        String hintMessage = computerController.createHintMessage();
        outputView.printHint(hintMessage);

        assertThat(output()).isEqualTo("낫싱");
    }

    @Test
    void 힌트_3스트라이크() {
        String userInputString = "123";
        List<Integer> userInputNumbers = Arrays.asList(1, 2, 3);

        gameNumber.saveUserInputNumbers(userInputString, userInputNumbers);
        gameNumber.setComputerGenerateNumbers(userInputNumbers);
        computerController.checkUserInputWithAnswer(gameNumber);
        String hintMessage = computerController.createHintMessage();
        outputView.printHint(hintMessage);

        assertThat(output()).isEqualTo("3스트라이크");
    }

    @Test
    void 힌트_3볼() {
        String userInputString = "123";
        List<Integer> userInputNumbers = Arrays.asList(1, 2, 3);
        List<Integer> answerNumbers = Arrays.asList(3, 1, 2);

        gameNumber.saveUserInputNumbers(userInputString, userInputNumbers);
        gameNumber.setComputerGenerateNumbers(answerNumbers);
        computerController.checkUserInputWithAnswer(gameNumber);
        String hintMessage = computerController.createHintMessage();
        outputView.printHint(hintMessage);

        assertThat(output()).isEqualTo("3볼");
    }

    @Test
    void 힌트_2볼_1스트라이크() {
        String userInputString = "123";
        List<Integer> userInputNumbers = Arrays.asList(1, 2, 3);
        List<Integer> answerNumbers = Arrays.asList(3, 2, 1);

        gameNumber.saveUserInputNumbers(userInputString, userInputNumbers);
        gameNumber.setComputerGenerateNumbers(answerNumbers);
        computerController.checkUserInputWithAnswer(gameNumber);
        String hintMessage = computerController.createHintMessage();
        outputView.printHint(hintMessage);

        assertThat(output()).isEqualTo("2볼 1스트라이크");
    }

    @Test
    void 힌트_1볼_1스트라이크() {
        String userInputString = "123";
        List<Integer> userInputNumbers = Arrays.asList(1, 2, 3);
        List<Integer> answerNumbers = Arrays.asList(4, 2, 1);

        gameNumber.saveUserInputNumbers(userInputString, userInputNumbers);
        gameNumber.setComputerGenerateNumbers(answerNumbers);
        computerController.checkUserInputWithAnswer(gameNumber);
        String hintMessage = computerController.createHintMessage();
        outputView.printHint(hintMessage);

        assertThat(output()).isEqualTo("1볼 1스트라이크");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
