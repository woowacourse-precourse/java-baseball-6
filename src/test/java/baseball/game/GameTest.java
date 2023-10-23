package baseball.game;

import static baseball.constant.GameConstant.BALL;
import static baseball.constant.GameConstant.NOTHING;
import static baseball.constant.GameConstant.STRIKE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.domain.GameRestartOrExit;
import baseball.domain.GameResult;
import baseball.domain.Number;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {

    Number userNumber = new Number();
    Number computerNumber = new Number();

    @Test
    void 난수_생성_테스트() {
        computerNumber.createComputerNumber();
        String random1 = computerNumber.toString();
        computerNumber.createComputerNumber();
        String random2 = computerNumber.toString();
        assertNotEquals(random1, random2);
    }

    @Test
    void 입력_에러() {
        //given
        String input1 = "111";
        String input2 = "121";
        String input3 = "211";

        //when , then
        Assertions.assertThatThrownBy(() -> userNumber.inputUserNumber(input1))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> userNumber.inputUserNumber(input2))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> userNumber.inputUserNumber(input3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력() {
        //ginven
        String input1 = "123";
        
        //when
        userNumber.inputUserNumber(input1);

        //then
        assertEquals(userNumber.toString(), "[1, 2, 3]");

    }

    @Test
    void 통합_입력체크_테스트() {
        String compare = "124";
        입력체크_테스트_모듈(compare, "143", 1 + BALL + " " + 1 + STRIKE); // 1ball , 1strike
        입력체크_테스트_모듈(compare, "561", 1 + BALL);// 1ball
        입력체크_테스트_모듈(compare, "567", NOTHING); // nothing
        입력체크_테스트_모듈(compare, "124", 3 + STRIKE); // 3strike
    }

    private void 입력체크_테스트_모듈(String compare, String input, String resultView) {
        //given
        Number compareNumber = new Number();
        GameResult gameResult = new GameResult();

        //when
        compareNumber.inputUserNumber(compare);
        userNumber.inputUserNumber(input);
        userNumber.inputCheck(compareNumber, gameResult);

        //then
        assertEquals(gameResult.result(), resultView);
    }


    @Test
    void 게임_끝() {
        //given
        GameResult gameResult = new GameResult();
        gameResult.gameResultInit(0, 3);

        //when
        boolean gameEnd = gameResult.gameEnd();

        //then
        assertFalse(gameEnd);
    }

    @Test
    void 재시작_입력_에러() {
        //given
        String input = "3";
        GameRestartOrExit gameRestartOrExit = new GameRestartOrExit();

        //when , then
        Assertions.assertThatThrownBy(() -> gameRestartOrExit.gameRestartOrValueInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 재시작_또는_종료() {
        //given
        String restartInput = "1";
        String exitInput = "2";
        GameRestartOrExit restartResult = new GameRestartOrExit();
        GameRestartOrExit exitResult = new GameRestartOrExit();

        restartResult.gameRestartOrValueInput(restartInput);
        exitResult.gameRestartOrValueInput(exitInput);

        //when
        boolean restart = restartResult.restartOrExitCheck();
        boolean exit = exitResult.restartOrExitCheck();

        //then
        assertTrue(restart);
        assertFalse(exit);
    }
}