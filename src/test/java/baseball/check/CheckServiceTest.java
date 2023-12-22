package baseball.check;

import baseball.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CheckServiceTest {

    private CheckService checkService;

    @BeforeEach
    void beforeEach(){
        AppConfig appConfig = new AppConfig();
        checkService = appConfig.checkService();
    }

    @Test
    @DisplayName("사용자가 준 값이 컴퓨터의 값과 순서가 일치할때 STRIKE가 카운트 되는지 확인한다.")
    void checkStrike() {
        // given
        List<Integer> computer = Arrays.asList(1,2,3);
        List<Integer> numbers = Arrays.asList(1,2,3);
        // when
        Hint hint =  checkService.checkNumber(computer, numbers);
        // then
        assertEquals(hint.getStrike(), 3);
    }

    @Test
    @DisplayName("사용자가 준 값이 컴퓨터의 존재 할때 BALL이 카운트 되는지 확인한다.")
    void checkBall() {
        // given
        List<Integer> computer = Arrays.asList(2,3,1);
        List<Integer> numbers = Arrays.asList(1,2,3);
        // when
        Hint hint =  checkService.checkNumber(computer, numbers);
        // then
        assertEquals(hint.getBall(), 3);
    }

    @Test
    @DisplayName("사용자가 준 값이 컴퓨터의 없을때 카운트 안되는지 확인한다.")
    void checkNothing() {
        // given
        List<Integer> computer = Arrays.asList(1,2,3);
        List<Integer> numbers = Arrays.asList(4,5,6);
        // when
        Hint hint =  checkService.checkNumber(computer, numbers);
        // then
        assertEquals(hint.getStrike(), 0);
        assertEquals(hint.getBall(), 0);
    }

    @Test
    @DisplayName("모든 값이 스트라이크라면 게임을 끝낸다.")
    void checkGameOver() {
        // given
        Hint hint = new Hint();
        hint.setStrike(3);
        // when then
        assertTrue(checkService.checkGameOver(hint));
    }

    @Test
    @DisplayName("모든 값이 스트라이크아니라면 게임을 계속한다.")
    void checkGameAgain() {
        // given
        Hint hint = new Hint();
        // when then
        assertFalse(checkService.checkGameOver(hint));
    }

}