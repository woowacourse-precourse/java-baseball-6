package baseball;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("함수별 기능 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class FunctionTest {

    @Test
    void 정답_리스트의_크기는_3이다() {
        List<Integer> answerList = Application.makeRandomAnswer();

        assertEquals(3, answerList.size());
    }

    @Test
    void 정답_리스트의_숫자는_1에서_9사이다() {
        List<Integer> answerList = Application.makeRandomAnswer();

        assertTrue(answerList.stream().allMatch(num -> num >= 1 && num <= 9));
    }

    @Test
    void 정답_리스트의_모든_숫자는_중복되면_안된다() {
        List<Integer> answerList = Application.makeRandomAnswer();

        assertEquals(answerList.size(), answerList.stream().distinct().count());
    }

    @Test
    void 사용자의_올바른_입력을_받는다() {
        String input1 = "123";
        InputStream in1 = new ByteArrayInputStream(input1.getBytes());
        System.setIn(in1);

        List<Integer> userInputList1 = Application.getUserTrialInput();
        camp.nextstep.edu.missionutils.Console.close();

        assertEquals(List.of(1, 2, 3), userInputList1);

        String input2 = "618";
        InputStream in2 = new ByteArrayInputStream(input2.getBytes());
        System.setIn(in2);

        List<Integer> userInputList2 = Application.getUserTrialInput();
        camp.nextstep.edu.missionutils.Console.close();

        assertEquals(List.of(6, 1, 8), userInputList2);
    }

    @Test
    void 사용자의_잘못된_입력을_검사한다() {
        assertThrows(IllegalArgumentException.class, () -> Application.vaildUserTrialInput("12"));
        assertThrows(IllegalArgumentException.class, () -> Application.vaildUserTrialInput("1a1"));
        assertThrows(IllegalArgumentException.class, () -> Application.vaildUserTrialInput("101"));
        assertThrows(IllegalArgumentException.class, () -> Application.vaildUserTrialInput("121"));
        assertDoesNotThrow(() -> {
            Application.vaildUserTrialInput("123");
            Application.vaildUserTrialInput("456");
            Application.vaildUserTrialInput("789");
        });
    }

    @Test
    void 사용자의_입력과_정답을_비교하여_결과를_반환한다() {
        List<Integer> answerList = List.of(4, 0, 9);

        List<Integer> userInputList1 = List.of(1, 2, 3);
        GameResult gameResult1 = Application.playGame(answerList, userInputList1);
        assertEquals(new GameResult(0, 0), gameResult1);

        List<Integer> userInputList2 = List.of(6, 0, 8);
        GameResult gameResult2 = Application.playGame(answerList, userInputList2);
        assertEquals(new GameResult(1, 0), gameResult2);

        List<Integer> userInputList3 = List.of(0, 4, 9);
        GameResult gameResult3 = Application.playGame(answerList, userInputList3);
        assertEquals(new GameResult(1, 2), gameResult3);

        List<Integer> userInputList4 = List.of(4, 0, 9);
        GameResult gameResult4 = Application.playGame(answerList, userInputList4);
        assertEquals(new GameResult(3, 0), gameResult4);
    }

    @Test
    void 사용자의_올바른_재시작_입력을_받는다() {
        String input1 = "1";
        InputStream in1 = new ByteArrayInputStream(input1.getBytes());
        System.setIn(in1);

        int userInputNumber1 = Application.getUserRestartInput();
        camp.nextstep.edu.missionutils.Console.close();

        assertEquals(1, userInputNumber1);

        String input2 = "2";
        InputStream in2 = new ByteArrayInputStream(input2.getBytes());
        System.setIn(in2);

        int userInputNumber2 = Application.getUserRestartInput();
        camp.nextstep.edu.missionutils.Console.close();

        assertEquals(2, userInputNumber2);
    }
}
