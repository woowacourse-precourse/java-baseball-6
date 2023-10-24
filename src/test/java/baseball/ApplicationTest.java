package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.HashSet;
import java.util.List;

import static baseball.Application.BaseBallGame;
import static baseball.Application.main;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    @DisplayName("BaseBallGame 객체 생성")
    void Should_CreateBaseBallGame() {
        BaseBallGame baseBallGame = new BaseBallGame(System.in);
        assertThat(baseBallGame).isNotNull();
    }

    @Test
    @DisplayName("컴퓨터가 랜덤한 수를 생성할 때 오류없이 진행")
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
    @DisplayName("사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 발생시킴")
    void Should_ThrowIllegalArgumentException_When_EnterIncorrectUserNumbers() {
        // given
        BaseBallGame baseBallGame1 = new BaseBallGame(new ByteArrayInputStream("12*".getBytes()));
        BaseBallGame baseBallGame2 = new BaseBallGame(new ByteArrayInputStream("12345".getBytes()));

        // when
        Throwable thrown1 = catchThrowable(baseBallGame1::setUserNumbers);
        Throwable thrown2 = catchThrowable(baseBallGame2::setUserNumbers);

        // then
        assertThat(thrown1).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 수가 입력되었습니다.");
        assertThat(thrown2).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("정해진 수의 범위를 넘었습니다.");
    }

    @Test
    @DisplayName("유저가 적절한 수 입력시, 오류 없이 진행")
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
    @DisplayName("유저가 적절한 수 입력시, 입력된 수와 컴퓨터가 정한 수와 비교 후 정상 결과 츌력")
    void Should_ReturnBallOrStrikeCount_When_EnterCorrectUserNumbers() {
        // given
        BaseBallGame baseBallGame = new BaseBallGame(new ByteArrayInputStream("124".getBytes()));
        baseBallGame.setUserNumbers();

        // when
        baseBallGame.setComputerNumbers(List.of(5, 6, 7));
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

    @Test
    @DisplayName("종료 코드 1을 입력했을 때 정상적을 재시작 진행")
    void Should_Exit_When_InputCorrectExitCode() {
        // given
        BaseBallGame baseBallGame = new BaseBallGame(new ByteArrayInputStream("123\n1\n234".getBytes()));
        baseBallGame.setComputerNumbers(List.of(1, 2, 3));

        // when
        baseBallGame.setUserNumbers();
        baseBallGame.checkExit();
        baseBallGame.setUserNumbers();

        // then
        assertThat(List.of(2, 3, 4)).usingRecursiveComparison().isEqualTo(baseBallGame.getUserNumbers());
    }

    @Test
    @DisplayName("잘못된 종료 코드 입력시, IllegalArgumentException 발생")
    void Should_Exit_When_InputIncorrectExitCode() {
        // given
        BaseBallGame baseBallGame = new BaseBallGame(new ByteArrayInputStream("123\n4\n234".getBytes()));
        baseBallGame.setComputerNumbers(List.of(1, 2, 3));

        // when
        baseBallGame.setUserNumbers();
        Throwable thrown = catchThrowable(baseBallGame::checkExit);

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("종료 코드를 잘못 입력했습니다.");
    }

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        main(new String[]{});
    }
}
