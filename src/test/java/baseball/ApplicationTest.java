package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.constant.GameConstant;
import baseball.model.Answer;
import baseball.model.Referee;
import baseball.model.dto.PlayerDto;
import baseball.model.dto.ResultDto;
import baseball.util.StringToIntegerListParser;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
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

    @Test
    void 영문자_포함_입력값_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("4f3"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 숫자_0_포함_입력값_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("032"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 세자리수_아닌_입력값_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 중복_숫자_입력값_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("662"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 사용자_게임_재시작_입력값_예외_숫자_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("279", "7"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                2, 7, 9
        );
    }

    @Test
    void 랜덤_세자리수_생성_후_자리수_3인지_테스트() {
        List<Integer> answer = Answer.generate();

        assertThat(answer.size()).isEqualTo(GameConstant.GAME_NUMBER_LENGTH);
    }

    @Test
    void 랜덤_세자리수_생성_후_중복_검사_테스트() {
        List<Integer> answerList = Answer.generate();
        Set<Integer> answerSet = new HashSet<>(answerList);

        Integer expectedUniqueness = answerSet.size();

        assertThat(expectedUniqueness).isEqualTo(GameConstant.GAME_NUMBER_LENGTH);
    }

    @Test
    void 쓰리_스트라이크_채점_테스트() {
        PlayerDto playerDto = new PlayerDto(List.of(5, 2, 4));
        Referee referee = new Referee(List.of(5, 2, 4));
        ResultDto expectedResult = new ResultDto(3, 0);
        ResultDto actualResult = referee.decidesResult(playerDto);

        Integer expectedStrike = expectedResult.getStrike();
        Integer actualStrike = actualResult.getStrike();

        assertThat(actualStrike).isEqualTo(expectedStrike);
    }

    @Test
    void 쓰리_볼_채점_테스트() {
        PlayerDto playerDto = new PlayerDto(List.of(5, 2, 4));
        Referee referee = new Referee(List.of(2, 4, 5));
        ResultDto expectedResult = new ResultDto(0, 3);
        ResultDto actualResult = referee.decidesResult(playerDto);

        Integer expectedBall = expectedResult.getBall();
        Integer actualBall = actualResult.getBall();

        assertThat(actualBall).isEqualTo(expectedBall);
    }

    @Test
    void 사용자_스트링_입력값_인티저_리스트로_변환_테스트() {
        String input = "524";
        List<Integer> playerGameNumber = StringToIntegerListParser.parse(input);

        List<Integer> expectedGameNumber = List.of(5, 2, 4);

        assertThat(playerGameNumber).isNotNull()
                .hasSize(3)
                .containsExactlyElementsOf(expectedGameNumber);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
