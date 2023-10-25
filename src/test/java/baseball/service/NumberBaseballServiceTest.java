package baseball.service;

import baseball.model.NumberBaseball;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class NumberBaseballServiceTest {

    private NumberBaseball numberBaseball;
    private NumberBaseballService numberBaseballService;

    @BeforeEach
    void setUp() {
        numberBaseball = NumberBaseball.getInstance();
        numberBaseballService = NumberBaseballService.getInstance();
    }

    @Test
    @DisplayName("게임 재시작할 때 숫자 야구 인스턴스가 새로 생성되는가")
    void 게임_재시작시_숫자야구_인스턴스_체크() throws Exception {
        //given
        //when
        //then
        assertThat(numberBaseball).isNotEqualTo(NumberBaseball.getInstance());
    }

    @Test
    @DisplayName("Int를 List<Integer>로 정상변환 되는지")
    void Int를_List로_변환() throws Exception {
        //given
        int inputNum = 123;
        //when
        List<Integer> integerList = numberBaseballService.convertIntToList(inputNum);
        //then
        assertThat(integerList).isEqualTo(Arrays.asList(1, 2, 3));
    }
}