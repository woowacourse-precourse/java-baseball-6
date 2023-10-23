package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerBaseBallTest {

    private ComputerBaseBall computerBaseBall;

    @BeforeEach
    void createComputerBaseBall() {
        computerBaseBall = new ComputerBaseBall();
    }

    @Test
    @DisplayName("랜덤 난수 3개를 생성한다.")
    void createRandomNumber() {
        int count = 3;

        assertThat(computerBaseBall.getBalls().size()).isEqualTo(count);
    }

    @Test
    @DisplayName("getBalls() 로 얻은 List는 수정이 불가능하다.")
    void getImmutableList() {
        List<Ball> immutableList = computerBaseBall.getBalls();
        Ball ball = new Ball("1");

        assertThrows(UnsupportedOperationException.class, ()
                -> immutableList.add(ball));

        assertThrows(UnsupportedOperationException.class, ()
                -> immutableList.remove(ball));
    }
}