package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Method;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BaseballTest {
    private static Baseball baseball;

    @BeforeAll
    static void init() {
        baseball = new Baseball();
    }

    @Test
    @SuppressWarnings("unchecked")
    void 랜덤_숫자_생성_길이_테스트() throws Exception {
        Method method = baseball.getClass().getDeclaredMethod("chooseRandomNumbers");
        method.setAccessible(true);

        List<Integer> computerNumbers = (List<Integer>) method.invoke(baseball);
        assertThat(computerNumbers).hasSize(3);
    }

    @Test
    @SuppressWarnings("unchecked")
    void 랜덤_숫자_생성_범위_테스트() throws Exception {
        Method method = baseball.getClass().getDeclaredMethod("chooseRandomNumbers");
        method.setAccessible(true);

        List<Integer> computerNumbers = (List<Integer>) method.invoke(baseball);
        assertThat(computerNumbers).allMatch(num -> num > 0 && num < 10);
    }

    @Test
    void 비교_결과_테스트() throws Exception {
        Method method = baseball.getClass().getDeclaredMethod("checkNumbers", List.class, int.class);
        method.setAccessible(true);

        boolean baseballResult = (boolean) method.invoke(baseball, List.of(3, 5, 7), 573);
        assertThat(baseballResult).isEqualTo(false);

        baseballResult = (boolean) method.invoke(baseball, List.of(5, 7, 3), 573);
        assertThat(baseballResult).isEqualTo(true);
    }
}
