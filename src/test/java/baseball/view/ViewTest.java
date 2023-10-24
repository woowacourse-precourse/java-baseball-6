package baseball.view;

import baseball.model.Score;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ViewTest {
    BaseballGameView baseballGameView = new BaseballGameView();
    @Test
    @DisplayName("게임 결과 테스트")
    public void testShowResult() {
        //given
        Score score1;
        Score score2;
        Score score3;

        //when
        score1 = new Score(1, 2);
        score2 = new Score(0, 0);
        score3 = new Score(3, 3);

        //then
        Assertions.assertThat(baseballGameView.showResult(score1)).isFalse();
        Assertions.assertThat(baseballGameView.showResult(score2)).isFalse();
        Assertions.assertThat(baseballGameView.showResult(score3)).isTrue();
    }

}
