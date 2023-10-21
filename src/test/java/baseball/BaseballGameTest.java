package baseball;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class BaseballGameTest {
    BaseballGame baseballGame = new BaseballGame();

    // TODO: 고민해볼 점 - 테스트를 실행할 때마다 테스트 결과가 바뀜. 즉 테스트가 성공할 수 있고, 실패할 수 있음
    @Test
    void 컴퓨터가_생성한_정답은_3자리이다() {
        // when
        baseballGame.generateAnswers();
        String ans = baseballGame.collectAnswers();
        System.out.println("generated answer = " + ans);

        // then
        assertEquals(3, ans.length());
    }

    @Test
    void 컴퓨터가_생성한_정답은_1부터_9까지의_숫자만을_포함한다() {
        // when
        baseballGame.generateAnswers();
        String ans = baseballGame.collectAnswers();
        System.out.println("generated answer = " + ans);

        // then
        for (char num : ans.toCharArray()) {
            if (!('1' <= num && num <= '9')) {
                fail();
            }
        }
    }

    @Test
    void 컴퓨터가_생성한_정답은_각_자리의_숫자가_겹치지_않는다() {
        // when
        baseballGame.generateAnswers();
        String ans = baseballGame.collectAnswers();
        System.out.println("generated answer = " + ans);

        // then
        int[] count = new int[10];
        for (int i = 0; i < baseballGame.getGeneratedAnswers().size(); i++) {
            int curNum = baseballGame.getGeneratedAnswers().get(i);
            count[curNum]++;
            if (count[curNum] > 1) {
                fail();
            }
        }
    }
}
