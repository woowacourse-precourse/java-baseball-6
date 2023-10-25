package baseball;

import baseball.service.GameResultReturnService;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class GameResultReturnTest extends NsTest {
    private GameResultReturnService gameResultReturnService = new GameResultReturnService();

    @Test
    void 결과_테스트1(){
        assertThat(gameResultReturnService.gameResult(List.of(1,2,3),List.of(2,3,4))).isEqualTo("2볼 ");
    }

    @Test
    void 결과_테스트2(){
        assertThat(gameResultReturnService.gameResult(List.of(1,2,3),List.of(1,2,3))).isEqualTo("3스트라이크");
    }

    @Test
    void 결과_테스트3(){
        assertThat(gameResultReturnService.gameResult(List.of(1,2,3),List.of(1,3,4))).isEqualTo("1볼 1스트라이크");
    }

    @Test
    void 결과_테스트4(){
        assertThat(gameResultReturnService.gameResult(List.of(1,2,3),List.of(4,5,6))).isEqualTo("낫싱");
    }






    @Override
    protected void runMain() {

    }
}
