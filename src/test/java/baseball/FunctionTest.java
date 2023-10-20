package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    void 정답_리스트의_크기는_3이어야_한다() {
        List<Integer> answerList = Application.makeRandomAnswer();

        assertEquals(answerList.size(), 3);
    }

    @Test
    void 정답_리스트의_숫자는_1에서_9사이여야_한다() {
        List<Integer> answerList = Application.makeRandomAnswer();

        assertTrue(answerList.stream().allMatch(num -> num >= 1 && num <= 9));
    }

    @Test
    void 정답_리스트의_모든_숫자는_중복되지_않아야_한다() {
        List<Integer> answerList = Application.makeRandomAnswer();

        assertEquals(answerList.stream().distinct().count(), answerList.size());
    }

    @Test
    void 사용자의_올바른_입력이_잘_받아져야_한다() {
        String input1 = "123";
        InputStream in1 = new ByteArrayInputStream(input1.getBytes());
        System.setIn(in1);

        List<Integer> userInputList1 = Application.getUserTrialInput();

        assertEquals(List.of(1, 2, 3), userInputList1);

        String input2 = "608";
        InputStream in2 = new ByteArrayInputStream(input2.getBytes());
        System.setIn(in2);

        List<Integer> userInputList2 = Application.getUserTrialInput();

        assertEquals(List.of(6, 0, 8), userInputList2);
    }
}
