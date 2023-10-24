package baseball.domain.computer;

import baseball.domain.BallsFixture;
import baseball.domain.ball.Balls;
import baseball.domain.result.Result;
import baseball.domain.role.BallPicker;
import baseball.domain.role.RandomBallPicker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ComputerTest {
    private static final int ROUNDS = 3;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 9;

    @Test
    @DisplayName("Computer은 조건이 맞으면 정상 생성 되어야 한다.")
    void Computer_정상_생성() throws IllegalAccessException {
        BallPicker ballPicker = new RandomBallPicker();
        Computer computer = Computer.generate(ballPicker, ROUNDS, MIN_RANGE, MAX_RANGE);

        assertNotNull(computer);
    }

    @Test
    @DisplayName("Compare에 일치하는 Balls를 비교하면 3스트라이크 반환")
    void Compare은_모든볼값위치동일_3스트라이크반환() throws IllegalAccessException {
        BallPicker ballPicker = mock(RandomBallPicker.class);
        when(ballPicker.pickNumberInRange(MIN_RANGE, MAX_RANGE)).thenReturn(4, 2, 5);

        Computer computer = Computer.generate(ballPicker, ROUNDS, MIN_RANGE, MAX_RANGE);

        Balls balls = BallsFixture.fixture().build(); // 4,2,5

        Result result = computer.compare(balls);

        assertEquals(3, result.getStrike());
        assertEquals(0, result.getBall());
    }

    @Test
    @DisplayName("Compare은 1개의 볼의 값과 위치가 같으면 1 스트라이크를 반환")
    void Compare은_한개의_값위치동일_1스트라이크반환() throws IllegalAccessException {
        BallPicker ballPicker = mock(RandomBallPicker.class);
        when(ballPicker.pickNumberInRange(MIN_RANGE, MAX_RANGE)).thenReturn(4,8,9);

        Computer computer = Computer.generate(ballPicker, ROUNDS, MIN_RANGE, MAX_RANGE);

        Balls balls = BallsFixture.fixture().build(); // 4,2,5

        Result result = computer.compare(balls);

        assertEquals(1, result.getStrike());
        assertEquals(0, result.getBall());
    }

    @Test
    @DisplayName("Compare은 1개의 볼의 값이 같고, 위치가 다르면 1 볼 반환")
    void Compare은_한개의_값동일_위치다름_1볼() throws IllegalAccessException {
        BallPicker ballPicker = mock(RandomBallPicker.class);
        when(ballPicker.pickNumberInRange(MIN_RANGE, MAX_RANGE)).thenReturn(5,6,7);
        Computer computer = Computer.generate(ballPicker, ROUNDS, MIN_RANGE, MAX_RANGE);

        Balls balls = BallsFixture.fixture().build(); // 4,2,5

        Result result = computer.compare(balls);

        assertEquals(0, result.getStrike());
        assertEquals(1, result.getBall());
    }

    @Test
    @DisplayName("Compare은 1개의 볼,위치가 같고, 1개의 볼만 일치하면 1 스트라이크 1 볼 반환")
    void Compare은_한개의_값위치동일_한개의_값동일_위치다름_1스트라이크_1볼() throws IllegalAccessException {
        BallPicker ballPicker = mock(RandomBallPicker.class);
        when(ballPicker.pickNumberInRange(MIN_RANGE, MAX_RANGE)).thenReturn(4,5,6);
        Computer computer = Computer.generate(ballPicker, ROUNDS, MIN_RANGE, MAX_RANGE);

        Balls balls = BallsFixture.fixture().build(); // 4,2,5

        Result result = computer.compare(balls);

        assertEquals(1, result.getStrike());
        assertEquals(1, result.getBall());
    }

    @Test
    @DisplayName("Compare은 모두 다르면 반환 없음")
    void compare은_모두_다름_반환_없음() throws IllegalAccessException {
        BallPicker ballPicker = mock(RandomBallPicker.class);
        when(ballPicker.pickNumberInRange(MIN_RANGE, MAX_RANGE)).thenReturn(7,8,9);
        Computer computer = Computer.generate(ballPicker, ROUNDS, MIN_RANGE, MAX_RANGE);

        Balls balls = BallsFixture.fixture().build(); // 4,2,5

        Result result = computer.compare(balls);

        assertEquals(0, result.getStrike());
        assertEquals(0, result.getBall());
    }
}