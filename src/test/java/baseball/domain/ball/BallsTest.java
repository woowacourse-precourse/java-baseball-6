package baseball.domain.ball;

import baseball.domain.BallsFixture;
import baseball.domain.result.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BallsTest {
    private static final int ROUNDS = 3;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 9;

    @Test
    @DisplayName("Balls은 조건이 맞으면 정상 생성 되어야 한다.")
    void Balls_정상_생성() {
        Ball one = new Ball(1, MIN_RANGE, MAX_RANGE);
        Ball two = new Ball(2, MIN_RANGE, MAX_RANGE);
        Ball tree = new Ball(3, MIN_RANGE, MAX_RANGE);

        List<Ball> values = new ArrayList<>();
        values.add(one);
        values.add(two);
        values.add(tree);

        Balls balls = new Balls(values, ROUNDS);

        assertNotNull(balls);
    }

    @Test
    @DisplayName("Balls의 Size는 rounds 미만으로 설정될 수 없다.")
    void Balls의_Size가_rounds_미만일경우_익셉션_발생() {
        Ball one = new Ball(1, MIN_RANGE, MAX_RANGE);
        Ball two = new Ball(2, MIN_RANGE, MAX_RANGE);

        List<Ball> values = new ArrayList<>();
        values.add(one);
        values.add(two);

        assertThrows(IllegalArgumentException.class, () -> new Balls(values, ROUNDS));
    }

    @Test
    @DisplayName("Balls의 Size는 rounds 초과로 설정될 수 없다.")
    void Balls의_Size가_rounds_초과일경우_익셉션_발생() {
        Ball one = new Ball(1, MIN_RANGE, MAX_RANGE);
        Ball two = new Ball(2, MIN_RANGE, MAX_RANGE);
        Ball three = new Ball(3, MIN_RANGE, MAX_RANGE);
        Ball four = new Ball(4, MIN_RANGE, MAX_RANGE);

        List<Ball> values = new ArrayList<>();
        values.add(one);
        values.add(two);
        values.add(three);
        values.add(four);

        assertThrows(IllegalArgumentException.class, () -> new Balls(values, ROUNDS));
    }

    @Test
    @DisplayName("Balls의 compare은 모든 볼의 값과 위치가 같으면 3 스트라이크를 반환")
    void Balls의_compare은_모든볼값위치동일_3스트라이크반환() {
        Balls origin = BallsFixture.fixture().build();  // 4,2,5

        Ball one = new Ball(4, MIN_RANGE, MAX_RANGE);
        Ball two = new Ball(2, MIN_RANGE, MAX_RANGE);
        Ball three = new Ball(5, MIN_RANGE, MAX_RANGE);

        List<Ball> values = new ArrayList<>();
        values.add(one);
        values.add(two);
        values.add(three);

        Balls target = new Balls(values, ROUNDS);

        Result result = origin.compare(target);

        assertEquals(3, result.getStrike());
        assertEquals(0, result.getBall());
    }

    @Test
    @DisplayName("Balls의 compare은 1개의 볼의 값과 위치가 같으면 1 스트라이크를 반환")
    void Balls의_compare은_한개의_값위치동일_1스트라이크반환() {
        Balls origin = BallsFixture.fixture().build();  // 4,2,5

        Ball one = new Ball(4, MIN_RANGE, MAX_RANGE);
        Ball two = new Ball(8, MIN_RANGE, MAX_RANGE);
        Ball three = new Ball(9, MIN_RANGE, MAX_RANGE);

        List<Ball> values = new ArrayList<>();
        values.add(one);
        values.add(two);
        values.add(three);

        Balls target = new Balls(values, ROUNDS);

        Result result = origin.compare(target);

        assertEquals(1, result.getStrike());
        assertEquals(0, result.getBall());
    }

    @Test
    @DisplayName("Balls의 compare은 1개의 볼의 값이 같고, 위치가 다르면 1 볼 반환")
    void Balls의_compare은_한개의_값동일_위치다름_1볼() {
        Balls origin = BallsFixture.fixture().build(); // 4,2,5

        Ball one = new Ball(5, MIN_RANGE, MAX_RANGE);
        Ball two = new Ball(6, MIN_RANGE, MAX_RANGE);
        Ball three = new Ball(7, MIN_RANGE, MAX_RANGE);

        List<Ball> values = new ArrayList<>();
        values.add(one);
        values.add(two);
        values.add(three);

        Balls target = new Balls(values, ROUNDS);

        Result result = origin.compare(target);

        assertEquals(0, result.getStrike());
        assertEquals(1, result.getBall());
    }

    @Test
    @DisplayName("Balls의 compare은 1개의 볼,위치가 같고, 1개의 볼만 일치하면 1 스트라이크 1 볼 반환")
    void Balls의_compare은_한개의_값위치동일_한개의_값동일_위치다름_1스트라이크_1볼() {
        Balls origin = BallsFixture.fixture().build(); // 4,2,5

        Ball one = new Ball(4, MIN_RANGE, MAX_RANGE);
        Ball two = new Ball(5, MIN_RANGE, MAX_RANGE);
        Ball three = new Ball(6, MIN_RANGE, MAX_RANGE);

        List<Ball> values = new ArrayList<>();
        values.add(one);
        values.add(two);
        values.add(three);

        Balls target = new Balls(values, ROUNDS);

        Result result = origin.compare(target);

        assertEquals(1, result.getStrike());
        assertEquals(1, result.getBall());
    }

    @Test
    @DisplayName("Balls의 compare은 모두 다르면 반환 없음")
    void Balls의_compare은_모두_다름_반환_없음() {
        Balls origin = BallsFixture.fixture().build(); // 4,2,5

        Ball one = new Ball(7, MIN_RANGE, MAX_RANGE);
        Ball two = new Ball(8, MIN_RANGE, MAX_RANGE);
        Ball three = new Ball(9, MIN_RANGE, MAX_RANGE);

        List<Ball> values = new ArrayList<>();
        values.add(one);
        values.add(two);
        values.add(three);

        Balls target = new Balls(values, ROUNDS);

        Result result = origin.compare(target);

        assertEquals(0, result.getStrike());
        assertEquals(0, result.getBall());
    }
}