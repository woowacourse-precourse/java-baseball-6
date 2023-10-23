package baseball.application;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.BaseBallNumberList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseBallGameTest {

    @Test
    @DisplayName("같은 수가 같은 자리에 하나 있으면 원 스트라이크 힌트 처리한다")
    public void should_returnOneStrike_when_oneSameNumberInTheSameIndex() {
        //given
        BaseBallGame baseBallGame = new BaseBallGame(new BaseBallNumberList(List.of(1, 2, 3)),
                new TestGameManager());

        //when
        BaseBallResult baseBallResult = baseBallGame.play(new BaseBallNumberList(List.of(1, 4, 5)));

        //then
        assertThat(baseBallResult.getStrike()).isEqualTo(1);
    }

    @Test
    @DisplayName("같은 수가 같은 자리에 두개 있으면 투 스트라이크 힌트 처리한다")
    public void should_returnTwoStrike_when_twoSameNumberInTheSameIndex() {
        //given
        BaseBallGame baseBallGame = new BaseBallGame(new BaseBallNumberList(List.of(1, 2, 3)),
                new TestGameManager());

        //when
        BaseBallResult baseBallResult = baseBallGame.play(new BaseBallNumberList(List.of(1, 2, 5)));

        //then
        assertThat(baseBallResult.getStrike()).isEqualTo(2);
    }

    @Test
    @DisplayName("같은 수가 같은 자리에 세개 있으면 쓰리 스트라이크 힌트 처리한다")
    public void should_returnThreeStrike_when_threeSameNumberInTheSameIndex() {
        //given
        BaseBallGame baseBallGame = new BaseBallGame(new BaseBallNumberList(List.of(1, 2, 3)),
                new TestGameManager());

        //when
        BaseBallResult baseBallResult = baseBallGame.play(new BaseBallNumberList(List.of(1, 2, 3)));

        //then
        assertThat(baseBallResult.getStrike()).isEqualTo(3);
    }

    @Test
    @DisplayName("쓰리 스트라이크가 발생하면 Exit이벤트를 발생한다.")
    public void should_OccursAnExitEvent_when_threeStrike() {
        //given
        TestGameManager gameManager = new TestGameManager();
        BaseBallGame baseBallGame = new BaseBallGame(new BaseBallNumberList(List.of(1, 2, 3)),
                gameManager);

        //when
        baseBallGame.play(new BaseBallNumberList(List.of(1, 2, 3)));

        //then
        assertThat(gameManager.isExit()).isTrue();
    }

    static class TestGameManager implements GameManager {

        private boolean exitFlag;

        @Override
        public void exit() {
            exitFlag = true;
        }

        public boolean isExit() {
            return exitFlag;
        }
    }
}
