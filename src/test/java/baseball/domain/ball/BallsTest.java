package baseball.domain.ball;

import baseball.domain.BallsFixture;
import baseball.domain.result.Result;
import baseball.exception.DuplicateException;
import baseball.exception.OutOfRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BallsTest {

    @Test
    @DisplayName("Balls은 조건이 맞으면 정상 생성 되어야 한다.")
    void Balls_정상_생성() {
        Ball one = new Ball(1);
        Ball two = new Ball(2);
        Ball tree = new Ball(3);

        List<Ball> values = new ArrayList<>();
        values.add(one);
        values.add(two);
        values.add(tree);

        Balls balls = new Balls(values);

        assertNotNull(balls);
    }

    @Test
    @DisplayName("Balls의 Size는 rounds 미만으로 설정될 수 없다.")
    void Balls의_Size가_rounds_미만일경우_익셉션_발생() {
        Ball one = new Ball(1);
        Ball two = new Ball(2);

        List<Ball> values = new ArrayList<>();
        values.add(one);
        values.add(two);

        assertThrows(OutOfRangeException.class, () -> new Balls(values));
    }

    @Test
    @DisplayName("Balls의 Size는 rounds 초과로 설정될 수 없다.")
    void Balls의_Size가_rounds_초과일경우_익셉션_발생() {
        Ball one = new Ball(1);
        Ball two = new Ball(2);
        Ball three = new Ball(3);
        Ball four = new Ball(4);

        List<Ball> values = new ArrayList<>();
        values.add(one);
        values.add(two);
        values.add(three);
        values.add(four);

        assertThrows(OutOfRangeException.class, () -> new Balls(values));
    }

    @Test
    @DisplayName("중복된 값 존재 시 익셉션이 발생한다.")
    void 중복된_값_존재시_익셉션_발생() {
        Ball one = new Ball(1);
        Ball two = new Ball(1);
        Ball three = new Ball(1);

        List<Ball> values = new ArrayList<>();
        values.add(one);
        values.add(two);
        values.add(three);

        assertThrows(DuplicateException.class, () -> new Balls(values));
    }

    @Test
    @DisplayName("Balls의 compare은 모든 볼의 값과 위치가 같으면 3 스트라이크를 반환")
    void Balls의_compare은_모든볼값위치동일_3스트라이크반환() {
        Balls origin = BallsFixture.fixture().build();  // 4,2,5

        Ball one = new Ball(4);
        Ball two = new Ball(2);
        Ball three = new Ball(5);

        List<Ball> values = new ArrayList<>();
        values.add(one);
        values.add(two);
        values.add(three);

        Balls target = new Balls(values);

        Result result = origin.compare(target);

        assertEquals(3, result.strike());
        assertEquals(0, result.ball());
    }

    @Test
    @DisplayName("Balls의 compare은 1개의 볼의 값과 위치가 같으면 1 스트라이크를 반환")
    void Balls의_compare은_한개의_값위치동일_1스트라이크반환() {
        Balls origin = BallsFixture.fixture().build();  // 4,2,5

        Ball one = new Ball(4);
        Ball two = new Ball(8);
        Ball three = new Ball(9);

        List<Ball> values = new ArrayList<>();
        values.add(one);
        values.add(two);
        values.add(three);

        Balls target = new Balls(values);

        Result result = origin.compare(target);

        assertEquals(1, result.strike());
        assertEquals(0, result.ball());
    }

    @Test
    @DisplayName("Balls의 compare은 1개의 볼의 값이 같고, 위치가 다르면 1 볼 반환")
    void Balls의_compare은_한개의_값동일_위치다름_1볼() {
        Balls origin = BallsFixture.fixture().build(); // 4,2,5

        Ball one = new Ball(5);
        Ball two = new Ball(6);
        Ball three = new Ball(7);

        List<Ball> values = new ArrayList<>();
        values.add(one);
        values.add(two);
        values.add(three);

        Balls target = new Balls(values);

        Result result = origin.compare(target);

        assertEquals(0, result.strike());
        assertEquals(1, result.ball());
    }

    @Test
    @DisplayName("Balls의 compare은 1개의 볼,위치가 같고, 1개의 볼만 일치하면 1 스트라이크 1 볼 반환")
    void Balls의_compare은_한개의_값위치동일_한개의_값동일_위치다름_1스트라이크_1볼() {
        Balls origin = BallsFixture.fixture().build(); // 4,2,5

        Ball one = new Ball(4);
        Ball two = new Ball(5);
        Ball three = new Ball(6);

        List<Ball> values = new ArrayList<>();
        values.add(one);
        values.add(two);
        values.add(three);

        Balls target = new Balls(values);

        Result result = origin.compare(target);

        assertEquals(1, result.strike());
        assertEquals(1, result.ball());
    }

    @Test
    @DisplayName("Balls의 compare은 모두 다르면 반환 없음")
    void Balls의_compare은_모두_다름_반환_없음() {
        Balls origin = BallsFixture.fixture().build(); // 4,2,5

        Ball one = new Ball(7);
        Ball two = new Ball(8);
        Ball three = new Ball(9);

        List<Ball> values = new ArrayList<>();
        values.add(one);
        values.add(two);
        values.add(three);

        Balls target = new Balls(values);

        Result result = origin.compare(target);

        assertEquals(0, result.strike());
        assertEquals(0, result.ball());
    }
}