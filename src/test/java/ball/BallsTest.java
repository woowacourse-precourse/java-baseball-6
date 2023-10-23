package ball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallsTest {
    private Balls balls;
    private static final String INPUT_123 = "123";
    @BeforeEach
    void initBalls(){
        balls = new Balls(INPUT_123);
    }
    @Test
    @DisplayName("사용자의 입력으로 balls 컬렉션을 생성하는 로직 테스트")
    void init_by_string_test(){
        assertThat(balls.getBallList()).isEqualTo(new Balls(INPUT_123).getBallList());
    }
    
    @Test
    @DisplayName("불변 컬렉션임을 테스트")
    void balls_init_test() {
        List<Ball> ballList = balls.getBallList();
        ballList.add(new Ball(0,1));
        assertThat(balls.getBallList()).hasSize(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {""," ", "1", "12", "111", "112", "0", "012", "1234"})
    @DisplayName("balls 컬렉션의 생성 시 유저의 input 을 검증하는 테스트")
    void input_validation_test(String invalidInput) {
        assertThatThrownBy(() -> new Balls(invalidInput)).isInstanceOf(IllegalArgumentException.class);
    }

}
