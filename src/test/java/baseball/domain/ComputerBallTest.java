package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ComputerBallTest {


    @Test
    void 숫자_길이_확인() {
        ComputerBalls computerBall = new ComputerBalls();
        List<Ball> result = computerBall.getBalls();

        assertEquals(3, result.size());
    }

    @Test
    void 숫자_중복_확인() {
        ComputerBalls computerBall = new ComputerBalls();
        Set<Ball> result = computerBall.getBalls()
                .stream()
                .peek(System.out::print)
                .collect(Collectors.toSet());

        assertEquals(3, result.size());

    }

}