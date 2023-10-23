package baseball.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BallNumberGroupTest {
    @Test
    @DisplayName("중복된 공이 있으면 예외처리한다.")
    void throwException_When_BallNumberIsNotUnique() {
        // given
        List<BallNumber> testBallNumberGroup = new ArrayList<>();
        testBallNumberGroup.add(new BallNumber(1));
        testBallNumberGroup.add(new BallNumber(1));
        testBallNumberGroup.add(new BallNumber(1));

        // when & then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new BallNumberGroup(testBallNumberGroup);
        });
    }

    @Test
    @DisplayName("공의 개수가 3이 아니면 예외처리한다.")
    void throwException_When_BallNumberGroupSizeIsNot3() {
        // given
        List<BallNumber> testBallNumberGroup = new ArrayList<>();
        testBallNumberGroup.add(new BallNumber(1));
        testBallNumberGroup.add(new BallNumber(2));

        // when & then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new BallNumberGroup(testBallNumberGroup);
        });
    }

}