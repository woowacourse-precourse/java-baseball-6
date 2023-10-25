package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.Baseball;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Baseball 클래스")
public class BaseballTest {


    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class isBallAndStrike_메소드는 {
        @Nested
        @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
        class ball_개수가_0보다_크고_strike_개수가_0보다_크면 {
            @Test
            void true를_반환한다() {
                Baseball baseball = new Baseball(1, 1);
                assertEquals(baseball.isBallAndStrike(), true);
            }
        }

        @Nested
        @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
        class ball_또는_strike_개수가_0이면 {
            @Test
            void false를_반환한다() {
                Baseball ballZero = new Baseball(1, 0);
                assertEquals(ballZero.isBallAndStrike(), false);

                Baseball strikeZero = new Baseball(2, 0);
                assertEquals(strikeZero.isBallAndStrike(), false);
            }
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class isBall_메소드는 {
        @Nested
        @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
        class ball_개수가_0보다_크고_strike_개수가_0이면 {
            @Test
            void true를_반환한다() {
                Baseball baseball = new Baseball(2, 0);
                assertEquals(baseball.isBall(), true);
            }
        }

        @Nested
        @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
        class ball_개수가_0이면 {
            @Test
            void false를_반환한다() {
                Baseball ballZero = new Baseball(0, 3);
                assertEquals(ballZero.isBall(), false);
            }
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class isAllStrike_메소드는 {
        @Nested
        @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
        class ball_개수가_0이고_strike_개수가_숫자길이와_일치하면 {
            @Test
            void true를_반환한다() {
                Baseball baseball = new Baseball(0, 3);
                assertEquals(baseball.isAllStrike(), true);
            }
        }

        @Nested
        @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
        class ball_개수가_0이고_strike_개수가_숫자길이보다_적으면 {
            @Test
            void false를_반환한다() {
                Baseball baseball = new Baseball(0, 2);
                assertEquals(baseball.isAllStrike(), false);
            }
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class isStrike_메소드는 {
        @Nested
        @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
        class ball_개수가_0이고_strike_개수가_숫자길이보다_적으면 {
            @Test
            void true를_반환한다() {
                Baseball baseball = new Baseball(0, 2);
                assertEquals(baseball.isStrike(), true);
            }
        }

        @Nested
        @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
        class strike_개수가_0이면 {
            @Test
            void false를_반환한다() {
                Baseball baseball = new Baseball(0, 0);
                assertEquals(baseball.isStrike(), false);
            }
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class isNothing_메소드는 {
        @Nested
        @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
        class ball_strike_개수가_모두_0이면 {
            @Test
            void true를_반환한다() {
                Baseball baseball = new Baseball(0, 0);
                assertEquals(baseball.isNothing(), true);
            }
        }
    }
}
