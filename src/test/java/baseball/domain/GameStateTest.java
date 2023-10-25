package baseball.domain;

import baseball.BaseballResult;
import baseball.GameState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@DisplayName("GameState enum")
public class GameStateTest {

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class BaseballResult를_인자로_받는_of_메소드는 {
        @Nested
        @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
        class BaseballResult가_ALL_STRIKE으로_주어지면 {
            @Test
            void DONE을_반환한다() {
                Assertions.assertEquals(GameState.of(BaseballResult.ALL_STRIKE), GameState.DONE);
            }
        }

        @Nested
        @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
        class BaseballResult가_ALL_STRIKE_이외의_값으로_주어지면 {
            @ParameterizedTest
            @EnumSource(value = BaseballResult.class, names = {"BALL_STRIKE", "BALL", "STRIKE", "NOTHING"})
            void RUNNING을_반환한다(BaseballResult baseballResult) {
                Assertions.assertEquals(GameState.of(baseballResult), GameState.RUNNING);
            }
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class 게임_종료_또는_재시작_입력값을_인자로_받는_of_메소드는 {
        @Nested
        @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
        class 입력값으로_1이_주어지면 {
            @Test
            void RETRY을_반환한다() {
                Assertions.assertEquals(GameState.of(1), GameState.RETRY);
            }
        }

        @Nested
        @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
        class 입력값으로_2가_주어지면 {
            @Test
            void QUIT을_반환한다() {
                Assertions.assertEquals(GameState.of(2), GameState.QUIT);
            }
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class isRunable_메소드는 {
        @Nested
        @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
        class RUNNING_또는_RETRY_상태인_경우 {
            @ParameterizedTest
            @EnumSource(value = GameState.class, names = {"RUNNING", "RETRY"})
            void true를_반환한다(GameState state) {
                Assertions.assertEquals(state.isRunable(), true);
            }
        }

        @Nested
        @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
        class DONE_또는_QUIT_상태인_경우 {
            @ParameterizedTest
            @EnumSource(value = GameState.class, names = {"DONE", "QUIT"})
            void false를_반환한다(GameState state) {
                Assertions.assertEquals(state.isRunable(), false);
            }
        }
    }
}
