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
        List<Integer> testBallNumbers = new ArrayList<>();
        testBallNumbers.add(1);
        testBallNumbers.add(1);
        testBallNumbers.add(1);

        // when & then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new BallNumberGroup(testBallNumbers);
        });
    }

    @Test
    @DisplayName("공의 개수가 3이 아니면 예외처리한다.")
    void throwException_When_BallNumberGroupSizeIsNot3() {
        // given
        List<Integer> testBallNumberGroup = new ArrayList<>();
        testBallNumberGroup.add(1);
        testBallNumberGroup.add(2);

        // when & then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new BallNumberGroup(testBallNumberGroup);
        });
    }
}