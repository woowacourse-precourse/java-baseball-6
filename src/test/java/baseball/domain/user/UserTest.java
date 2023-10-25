package baseball.domain.user;

import baseball.domain.BallsFixture;
import baseball.domain.ball.Ball;
import baseball.domain.ball.Balls;
import baseball.domain.computer.Computer;
import baseball.domain.result.Result;
import baseball.domain.picker.BallPicker;
import baseball.domain.picker.RandomBallPicker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserTest {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 9;

    @Test
    @DisplayName("User은 조건이 맞으면 정상 생성 되어야 한다.")
    void Computer_정상_생성() {
        Balls balls = BallsFixture.fixture().build();
        User user = new User(balls);

        assertNotNull(user);
    }

    @Test
    @DisplayName("compare에 일치하는 Balls를 비교하면 3스트라이크 반환")
    void Compare은_모든볼값위치동일_3스트라이크반환() {
        BallPicker ballPicker = mock(RandomBallPicker.class);
        when(ballPicker.pickNumberInRange(MIN_RANGE, MAX_RANGE)).thenReturn(new Ball(4), new Ball(2), new Ball(5));

        Computer computer = Computer.generate(ballPicker);
        Balls balls = BallsFixture.fixture().build(); // 4,2,5
        User user = new User(balls);

        Result result = user.compare(computer);

        assertEquals(3, result.strike());
        assertEquals(0, result.ball());
    }

    @Test
    @DisplayName("compare은 1개의 볼의 값과 위치가 같으면 1 스트라이크를 반환")
    void Compare은_한개의_값위치동일_1스트라이크반환() {
        BallPicker ballPicker = mock(RandomBallPicker.class);
        when(ballPicker.pickNumberInRange(MIN_RANGE, MAX_RANGE)).thenReturn(new Ball(4), new Ball(8), new Ball(9));

        Computer computer = Computer.generate(ballPicker);
        Balls balls = BallsFixture.fixture().build(); // 4,2,5
        User user = new User(balls);

        Result result = user.compare(computer);

        assertEquals(1, result.strike());
        assertEquals(0, result.ball());
    }

    @Test
    @DisplayName("compare은 1개의 볼의 값이 같고, 위치가 다르면 1 볼 반환")
    void compare은_한개의_값동일_위치다름_1볼() {
        BallPicker ballPicker = mock(RandomBallPicker.class);
        when(ballPicker.pickNumberInRange(MIN_RANGE, MAX_RANGE)).thenReturn(new Ball(5), new Ball(6), new Ball(7));

        Computer computer = Computer.generate(ballPicker);
        Balls balls = BallsFixture.fixture().build(); // 4,2,5
        User user = new User(balls);

        Result result = user.compare(computer);

        assertEquals(0, result.strike());
        assertEquals(1, result.ball());
    }

    @Test
    @DisplayName("Balls의 compare은 1개의 볼,위치가 같고, 1개의 볼만 일치하면 1 스트라이크 1 볼 반환")
    void Compare은_한개의_값위치동일_한개의_값동일_위치다름_1스트라이크_1볼() {
        BallPicker ballPicker = mock(RandomBallPicker.class);
        when(ballPicker.pickNumberInRange(MIN_RANGE, MAX_RANGE)).thenReturn(new Ball(4), new Ball(5), new Ball(6));

        Computer computer = Computer.generate(ballPicker);
        Balls balls = BallsFixture.fixture().build(); // 4,2,5
        User user = new User(balls);

        Result result = user.compare(computer);

        assertEquals(1, result.strike());
        assertEquals(1, result.ball());
    }

    @Test
    @DisplayName("Balls의 compare은 모두 다르면 반환 없음")
    void Compare은_모두_다름_반환_없음() {
        BallPicker ballPicker = mock(RandomBallPicker.class);
        when(ballPicker.pickNumberInRange(MIN_RANGE, MAX_RANGE)).thenReturn(new Ball(7), new Ball(8), new Ball(9));

        Computer computer = Computer.generate(ballPicker);
        Balls balls = BallsFixture.fixture().build(); // 4,2,5
        User user = new User(balls);

        Result result = user.compare(computer);

        assertEquals(0, result.strike());
        assertEquals(0, result.ball());
    }
}