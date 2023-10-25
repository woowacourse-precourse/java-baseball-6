package baseball.application;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.manager.GameManager;
import baseball.domain.BaseBallNumberList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseBallGameTest {

    private TestGameManager testGameManager;

    @BeforeEach
    public void initGameManager() {
        testGameManager = new TestGameManager();
    }

    @Test
    @DisplayName("같은 수가 같은 자리에 하나 있으면 원 스트라이크 힌트 처리한다")
    public void should_returnOneStrike_when_oneSameNumberInTheSameIndex() {
        //given
        BaseBallGame baseBallGame = new BaseBallGame(new BaseBallNumberList(List.of(1, 2, 3)),
                testGameManager);

        //when
        BaseBallResult baseBallResult = baseBallGame.umpire(new NumericString("145"));

        //then
        assertThat(baseBallResult.getStrike()).isEqualTo(1);
        assertThat(testGameManager.isExit()).isFalse();
    }

    @Test
    @DisplayName("같은 수가 같은 자리에 두개 있으면 투 스트라이크 힌트 처리한다")
    public void should_returnTwoStrike_when_twoSameNumberInTheSameIndex() {
        //given
        BaseBallGame baseBallGame = new BaseBallGame(new BaseBallNumberList(List.of(1, 2, 3)),
                testGameManager);

        //when
        BaseBallResult baseBallResult = baseBallGame.umpire(new NumericString("125"));

        //then
        assertThat(baseBallResult.getStrike()).isEqualTo(2);
        assertThat(testGameManager.isExit()).isFalse();
    }

    @Test
    @DisplayName("같은 수가 같은 자리에 세개 있으면 쓰리 스트라이크 힌트 처리한다")
    public void should_returnThreeStrike_when_threeSameNumberInTheSameIndex() {
        //given
        BaseBallGame baseBallGame = new BaseBallGame(new BaseBallNumberList(List.of(1, 2, 3)),
                testGameManager);

        //when
        BaseBallResult baseBallResult = baseBallGame.umpire(new NumericString("123"));

        //then
        assertThat(baseBallResult.getStrike()).isEqualTo(3);
    }

    @Test
    @DisplayName("쓰리 스트라이크가 발생하면 Exit이벤트를 발생한다.")
    public void should_OccursAnExitEvent_when_threeStrike() {
        //given
        BaseBallGame baseBallGame = new BaseBallGame(new BaseBallNumberList(List.of(1, 2, 3)),
                testGameManager);

        //when
        baseBallGame.umpire(new NumericString("123"));

        //then
        assertThat(testGameManager.isExit()).isTrue();
    }

    @Test
    @DisplayName("같은 수가 다른 자리에 한개 있다면 원볼 힌트를 처리한다")
    public void should_returnOneBall_when_oneSameNumberInTheOtherIndex() {
        //given
        BaseBallGame baseBallGame = new BaseBallGame(new BaseBallNumberList(List.of(1, 2, 3)),
                testGameManager);

        //when
        BaseBallResult result = baseBallGame.umpire(new NumericString("451"));

        //then
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(1);
        assertThat(testGameManager.isExit()).isFalse();
    }

    @Test
    @DisplayName("같은 수가 다른 자리에 두개 있다면 투볼 힌트를 처리한다")
    public void should_returnTwoBall_when_twoSameNumberInTheOtherIndex() {
        //given
        BaseBallGame baseBallGame = new BaseBallGame(new BaseBallNumberList(List.of(1, 2, 3)),
                testGameManager);

        //when
        BaseBallResult result = baseBallGame.umpire(new NumericString("251"));

        //then
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(2);
        assertThat(testGameManager.isExit()).isFalse();
    }

    @Test
    @DisplayName("같은 수가 다른 자리에 두개 있다면 투볼 힌트를 처리한다")
    public void should_returnThreeBall_when_threeSameNumberInTheOtherIndex() {
        //given
        BaseBallGame baseBallGame = new BaseBallGame(new BaseBallNumberList(List.of(1, 2, 3)),
                testGameManager);

        //when
        BaseBallResult result = baseBallGame.umpire(new NumericString(("231")));

        //then
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(3);
        assertThat(testGameManager.isExit()).isFalse();
    }

    @Test
    @DisplayName("같은 수가 없다면 result에 0만을 반환한다")
    public void should_returnResultJustZero_when_sameNumberNotIncluded() {
        //given
        BaseBallGame baseBallGame = new BaseBallGame(new BaseBallNumberList(List.of(1, 2, 3)),
                testGameManager);

        //when
        BaseBallResult result = baseBallGame.umpire(new NumericString("456"));

        //then
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(testGameManager.isExit()).isFalse();
    }

    static class TestGameManager implements GameManager {

        private boolean exitFlag;

        @Override
        public void execute() {

        }

        @Override
        public void exit() {
            exitFlag = true;
        }

        public boolean isExit() {
            return exitFlag;
        }
    }
}
