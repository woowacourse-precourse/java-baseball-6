package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BaseBallGameServiceTest {

    private BaseBallGameService baseBallGameService;
    private ComputerRandomNumbers computerNumbers;

    @BeforeEach
    void setUp() {
        baseBallGameService = new BaseBallGameService();
        List<Integer> computerNumberList = List.of(1, 2, 3);

        // 테스트를 위한 익명 클래스
        computerNumbers = new ComputerRandomNumbers() {
            @Override
            public int get(int idx) {
                return computerNumberList.get(idx);
            }

            @Override
            public int indexOf(int value) {
                return computerNumberList.indexOf(value);
            }

            @Override
            public int size() {
                return computerNumberList.size();
            }
        };
    }

    @Test
    void 낫싱_테스트() throws Exception {
        //given
        List<Integer> userNumbers = List.of(4, 5, 6);

        //when
        String result = baseBallGameService.startGame(computerNumbers, userNumbers);

        //then
        assertThat("낫싱").isEqualTo(result);
    }

    @Test
    void 볼_테스트() throws Exception {
        //given
        List<Integer> userNumbers = List.of(3, 1, 9);

        //when
        String result = baseBallGameService.startGame(computerNumbers, userNumbers);

        //then
        assertThat("2볼").isEqualTo(result);
    }

    @Test
    void 스트라이크_테스트() throws Exception {
        //given
        List<Integer> userNumbers = List.of(1, 2, 4);

        //when
        String result = baseBallGameService.startGame(computerNumbers, userNumbers);

        //then
        assertThat("2스트라이크").isEqualTo(result);
    }

    @Test
    void 볼_스트라이크_테스트() throws Exception {
        //given
        List<Integer> userNumbers = List.of(3, 2, 1);

        //when
        String result = baseBallGameService.startGame(computerNumbers, userNumbers);

        //then
        assertThat("2볼 1스트라이크").isEqualTo(result);
    }

}