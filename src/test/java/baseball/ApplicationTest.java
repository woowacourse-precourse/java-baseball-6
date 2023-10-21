package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.HashSet;
import java.util.List;

import static baseball.Application.BaseBallGame;
import static baseball.Application.main;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class ApplicationTest extends NsTest {
    @Test
    void makeBaseBallGameObject() {
        BaseBallGame baseBallGame = new BaseBallGame(System.in);
        assertThat(baseBallGame).isNotNull();
    }

    @Test
    void Should_ReturnCorrectRandomNumbers_When_MakeRandomNumbers() {
        // given
        BaseBallGame baseBallGame = new BaseBallGame(System.in);
        baseBallGame.setComputerNumbers();

        // when
        List<Integer> computerNumbers = baseBallGame.getComputerNumbers();
        HashSet<Integer> computerNumbersSet = new HashSet<>(computerNumbers);

        // then
        for (Integer computerNumber : computerNumbers) {
            assertThat(computerNumber).isPositive()
                    .isLessThanOrEqualTo(9);
        }
        assertThat(computerNumbersSet).hasSameSizeAs(computerNumbers);
    }

    @Test
    void Should_ThrowIllegalArgumentException_When_EnterIncorrectUserNumbers() {
        // given
        BaseBallGame baseBallGame = new BaseBallGame(new ByteArrayInputStream("12*".getBytes()));

        // when
        Throwable thrown = catchThrowable(() -> baseBallGame.setUserNumbers());

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 수가 입력되었습니다.");
    }

    @Test
    void Should_Success_When_EnterCorrectUserNumbers() {
        // given
        BaseBallGame baseBallGame = new BaseBallGame(new ByteArrayInputStream("124".getBytes()));
        baseBallGame.setUserNumbers();

        // when
        List<Integer> userNumbers = baseBallGame.getUserNumbers();

        // then
        assertThat(userNumbers).usingRecursiveComparison().isEqualTo(List.of(1, 2, 4));
    }

    @Test
    void Should_ReturnBallOrStrikeCount_When_EnterCorrectUserNumbers() {
        // given
        BaseBallGame baseBallGame = new BaseBallGame(new ByteArrayInputStream("124".getBytes()));
        baseBallGame.setUserNumbers();

        // when
        baseBallGame.setComputerNumbers(List.of(5,6,7));
        baseBallGame.setCount();
        int[] count1 = baseBallGame.getCount();
        String count1Result = baseBallGame.getResult();

        baseBallGame.setComputerNumbers(List.of(2, 4, 1));
        baseBallGame.setCount();
        int[] count2 = baseBallGame.getCount();
        String count2Result = baseBallGame.getResult();

        baseBallGame.setComputerNumbers(List.of(1, 2, 4));
        baseBallGame.setCount();
        int[] count3 = baseBallGame.getCount();
        String count3Result = baseBallGame.getResult();

        baseBallGame.setComputerNumbers(List.of(4, 2, 1));
        baseBallGame.setCount();
        int[] count4 = baseBallGame.getCount();
        String count4Result = baseBallGame.getResult();


        // then
        assertThat(count1).isEqualTo(new int[]{0, 0});
        assertThat(count1Result).isEqualTo("낫싱");
        assertThat(count2).isEqualTo(new int[]{3, 0});
        assertThat(count2Result).isEqualTo("3볼");
        assertThat(count3).isEqualTo(new int[]{0, 3});
        assertThat(count3Result).isEqualTo("3스트라이크");
        assertThat(count4).isEqualTo(new int[]{2, 1});
        assertThat(count4Result).isEqualTo("2볼 1스트라이크");
    }

//    @Test
//    void 게임종료_후_재시작() {
//        assertRandomNumberInRangeTest(
//                () -> {
//                    run("246", "135", "1", "597", "589", "2");
//                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
//                },
//                1, 3, 5, 5, 8, 9
//        );
//    }
//
//    @Test
//    void 예외_테스트() {
//        assertSimpleTest(() ->
//                assertThatThrownBy(() -> runException("1234"))
//                        .isInstanceOf(IllegalArgumentException.class)
//        );
//    }

    @Override
    public void runMain() {
        main(new String[]{});
    }
}
