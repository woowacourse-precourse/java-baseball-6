package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import controller.GameController;
import controller.ValidationController;
import model.GameNumber;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

/**
 * packageName    : baseball
 * fileName       : ValidationControllerTest
 * author         : qkrtn_ulqpbq2
 * date           : 2023-10-21
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-10-21        qkrtn_ulqpbq2       최초 생성
 */
public class ValidationControllerTest {

    GameController gameController = new GameController();
    GameNumber gameNumber = new GameNumber();
    ValidationController validationController = new ValidationController();
    @Test
    void 사용자_입력_숫자_유효성_검사_정상_입력() {
        String playerInput = "123";
        List<Integer> playerList = Arrays.asList(1, 2, 3);
        assertThat(validationController.validate(playerInput)).isEqualTo(playerList);
    }

    @Test
    void 사용자_입력_숫자_유효성_검사_띄어쓰기를_사용한_경우() {
        String playerInput = "1 2 3";
        gameNumber.setPlayerInput(playerInput);
        List<Integer> playerList = Arrays.asList(1, 2, 3);
        assertThat(validationController.validate(gameNumber.getPlayerInput())).isEqualTo(playerList);
    }

    @Test
    void 사용자_입력_숫자_유효성_검사_비정상_입력_세자리의_숫자가_아님(){
        String playerInput = "21";
        String exceptionMessage = "숫자 세 자리를 입력해주세요.";
        Throwable throwable = catchThrowable(() -> {
            validationController.validate(playerInput);
        });

        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable).hasMessage(exceptionMessage);
    }

    @Test
    void 사용자_입력_숫자_유효성_검사_비정상_입력_범위를_벗어남(){
        String playerInput = "12345";
        String exceptionMessage = "숫자 세 자리를 입력해주세요.";
        Throwable throwable = catchThrowable(() -> {
            validationController.validate(playerInput);
        });

        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable).hasMessage(exceptionMessage);
    }

    @Test
    void 사용자_입력_숫자_유효성_검사_비정상_입력_1에서_9사이의_숫자를_입력하지_않음(){
        String playerInput = "103";
        String exceptionMessage = "1 ~ 9 사이의 숫자를 입력해주세요.";
        Throwable throwable = catchThrowable(() -> {
            validationController.validate(playerInput);
        });

        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable).hasMessage(exceptionMessage);
    }

    @Test
    void 사용자_입력_숫자_유효성_검사_비정상_입력_중복_입력(){
        String playerInput = "113";
        String exceptionMessage = "서로 다른 세자리의 숫자를 입력해주세요.";
        Throwable throwable = catchThrowable(() -> {
            validationController.validate(playerInput);
        });

        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable).hasMessage(exceptionMessage);
    }
}
