package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JudgementTest {
    Judgement judgement = new Judgement();

    @Test
    @DisplayName("[성공 테스트] 3스트라이크")
    void getHintSuccessTest1() {
        // given
        List<Integer> computerBalls = List.of(1, 3, 7);
        List<Integer> playerBalls = List.of(1, 3, 7);
        // when
        String hint = judgement.getHint(computerBalls, playerBalls);
        // then
        assertThat(hint).isEqualTo("3스트라이크");
    }

    @Test
    @DisplayName("[성공 테스트] 1볼 1스트라이크")
    void getHintSuccessTest2() {
        // given
        List<Integer> computerBalls = List.of(4, 9, 8);
        List<Integer> playerBalls = List.of(8, 9, 3);
        // when
        String hint = judgement.getHint(computerBalls, playerBalls);
        // then
        assertThat(hint).isEqualTo("1볼 1스트라이크");
    }

    @Test
    @DisplayName("[성공 테스트] 1볼")
    void getHintSuccessTest3() {
        // given
        List<Integer> computerBalls = List.of(3, 2, 5);
        List<Integer> playerBalls = List.of(2, 4, 7);
        // when
        String hint = judgement.getHint(computerBalls, playerBalls);
        // then
        assertThat(hint).isEqualTo("1볼");
    }

    @Test
    @DisplayName("[성공 테스트] 2볼")
    void getHintSuccessTest4() {
        // given
        List<Integer> computerBalls = List.of(5, 3, 8);
        List<Integer> playerBalls = List.of(3, 8, 1);
        // when
        String hint = judgement.getHint(computerBalls, playerBalls);
        // then
        assertThat(hint).isEqualTo("2볼");
    }

    @Test
    @DisplayName("[성공 테스트] 2볼 1스트라이크")
    void getHintSuccessTest5() {
        // given
        List<Integer> computerBalls = List.of(9, 2, 4);
        List<Integer> playerBalls = List.of(9, 4, 2);
        // when
        String hint = judgement.getHint(computerBalls, playerBalls);
        // then
        assertThat(hint).isEqualTo("2볼 1스트라이크");
    }

    @Test
    @DisplayName("[성공 테스트] 3볼")
    void getHintSuccessTest6() {
        // given
        List<Integer> computerBalls = List.of(9, 2, 4);
        List<Integer> playerBalls = List.of(4, 9, 2);
        // when
        String hint = judgement.getHint(computerBalls, playerBalls);
        // then
        assertThat(hint).isEqualTo("3볼");
    }

    @Test
    @DisplayName("[성공 테스트] 낫싱")
    void getHintSuccessTest7() {
        // given
        List<Integer> computerBalls = List.of(2, 5, 4);
        List<Integer> playerBalls = List.of(3, 6, 9);
        // when
        String hint = judgement.getHint(computerBalls, playerBalls);
        // then
        assertThat(hint).isEqualTo("낫싱");
    }

    @Test
    @DisplayName("[실패 테스트] 1볼 2스트라이크는 없는 경우의 수이다")
    void getHintFailTest1() {
        for (int testCase = 0; testCase < 10000; testCase++) {
            // given
            List<Integer> computerBalls = createThreeRandomNumber();
            List<Integer> playerBalls = createThreeRandomNumber();
            // when
            String hint = judgement.getHint(computerBalls, playerBalls);
            // then
            assertThat(hint).isNotEqualTo("1볼 2스트라이크");
        }
    }

    private List<Integer> createThreeRandomNumber() {
        List<Integer> threeRandomNumber = new ArrayList<>();
        while (threeRandomNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!threeRandomNumber.contains(randomNumber)) {
                threeRandomNumber.add(randomNumber);
            }
        }
        return threeRandomNumber;
    }
}