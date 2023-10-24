package baseball.service;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.vo.Score;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballServiceTest {

    BaseballService baseballService;

    @BeforeEach
    void beforeEach() {
        baseballService = new BaseballService();
    }

    @Test
    @DisplayName("상대방의 수와 일치하는 수가 존재하지 않을 경우 점수가 증가하지 않는다.")
    void notIncreaseScoreNumbersNotContain() {
        //given
        List<Integer> computerNumbers = List.of(1, 2, 3);
        String inputNumber = "456";
        //when
        Score score = baseballService.calculateGameScore(inputNumber, computerNumbers);
        //then
        assertThat(score.getBall()).isZero();
        assertThat(score.getStrike()).isZero();
    }

    @Test
    @DisplayName("상대방의 수와 일치하는 수는 존재하지만 위치가 다를 경우 볼의 점수만 오른다.")
    void increaseScoreBallNumbersContainAndLocationNotEquals() {
        //given
        List<Integer> computerNumbers = List.of(1, 2, 3);
        String inputNumber = "231";
        //when
        Score score = baseballService.calculateGameScore(inputNumber, computerNumbers);
        //then
        assertThat(score.getBall()).isEqualTo(3);
        assertThat(score.getStrike()).isZero();
    }

    @Test
    @DisplayName("상대방의 수와 일치하는 수는 존재하고, 위치가 동일한 스트라이크의 점수만 오른다.")
    void increaseScoreStrikeNumbersContainAndLocationEquals() {
        //given
        List<Integer> computerNumbers = List.of(1, 2, 3);
        String inputNumber = "123";
        //when
        Score score = baseballService.calculateGameScore(inputNumber, computerNumbers);
        //then
        assertThat(score.getBall()).isZero();
        assertThat(score.getStrike()).isEqualTo(3);
    }
}