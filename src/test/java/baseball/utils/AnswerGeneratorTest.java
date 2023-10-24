package baseball.utils;

import baseball.constants.Constants;
import baseball.utils.AnswerGenerator;
import org.junit.jupiter.api.*;

import java.util.List;

public class AnswerGeneratorTest {
    @Test
    void 컴퓨터가_생성한_정답은_3자리이다() {
        // when
        List<Integer> ans = AnswerGenerator.generateAnswers();

        // then
        Assertions.assertEquals(Constants.ANS_LEN, ans.size());
    }

    @Test
    void 컴퓨터가_생성한_정답은_1부터_9까지의_숫자만을_포함한다() {
        // when
        List<Integer> ans = AnswerGenerator.generateAnswers();

        // then
        ans.stream().forEach(
                num -> {
                    if (!(1 <= num && num <= 9)) {
                        Assertions.fail();
                    }
                }
        );
    }

    @Test
    void 컴퓨터가_생성한_정답은_각_자리의_숫자가_겹치지_않는다() {
        // when
        List<Integer> ans = AnswerGenerator.generateAnswers();

        // then
        int[] count = new int[10];
        ans.stream().forEach(
                curNum -> {
                    count[curNum]++;
                    if (count[curNum] > 1) {
                        Assertions.fail();
                    }
                }
        );
    }
}
