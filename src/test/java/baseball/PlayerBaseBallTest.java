package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

class PlayerBaseBallTest {

    @Test
    @DisplayName("사용자 입력으로 PlayerBaseBall을 생성한다.")
    void createPlayerBaseBall() {
        String inputNumbers = "123";
        PlayerBaseBall playerBaseBall = new PlayerBaseBall(inputNumbers);

        assertThat(playerBaseBall.getBalls().size()).isEqualTo(inputNumbers.length());
    }

    @Test
    @DisplayName("getBalls() 로 얻은 List는 수정이 불가능하다.")
    void getImmutableList() {
        String inputNumbers = "123";
        PlayerBaseBall playerBaseBall = new PlayerBaseBall(inputNumbers);
        List<Ball> immutableList = playerBaseBall.getBalls();
        Ball ball = new Ball("1");

        assertThrows(UnsupportedOperationException.class, ()
                -> immutableList.add(ball));

        assertThrows(UnsupportedOperationException.class, ()
                -> immutableList.remove(ball));
    }
}