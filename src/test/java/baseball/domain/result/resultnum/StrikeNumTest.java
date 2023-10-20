package baseball.domain.result.resultnum;

import baseball.domain.result.BallResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class StrikeNumTest {

    @Test
    @DisplayName("BALL 결과를 업데이트 하면 0 스트라이크를 가진 새로운 ResultNum 반환")
    void ballNumTest1() {
        StrikeNum strikeNum = new StrikeNum();
        ResultNum updatedStrikeNum = strikeNum.update(BallResult.BALL);
        Assertions.assertThat(updatedStrikeNum.getResult()).isEqualTo(Optional.empty());
    }

    @Test
    @DisplayName("STRIKE 결과를 업데이트 하면 1 스트라이크를 가진 새로운 ResultNum 반환")
    void ballNumTest2() {
        StrikeNum strikeNum = new StrikeNum();
        ResultNum updatedStrikeNum = strikeNum.update(BallResult.STRIKE);
        Assertions.assertThat(updatedStrikeNum.getResult()).isEqualTo(Optional.of("1스트라이크"));
    }

    @Test
    @DisplayName("NOTHING 결과를 업데이트 하면 0 스트라이크를 가진 새로운 ResultNum 반환")
    void ballNumTest3() {
        StrikeNum strikeNum = new StrikeNum();
        ResultNum updatedStrikeNum = strikeNum.update(BallResult.NOTHING);
        Assertions.assertThat(updatedStrikeNum.getResult()).isEqualTo(Optional.empty());
    }

}