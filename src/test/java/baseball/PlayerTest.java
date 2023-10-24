package baseball;

import baseball.controller.GameController;
import baseball.controller.NumberValidator;
import baseball.model.BaseBall;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class PlayerTest {
    GameController gameController = new GameController();
    NumberValidator numberValidator = new NumberValidator();

    @Test
    void 사용자_입력_숫자_validate_같은_값_입력_테스트(){
        String playerNumber = "345";
        List<Integer> playerList = Arrays.asList(3,4,5);
        assertThat(numberValidator.validateData(playerNumber)).isEqualTo(playerList);
    }

    @Test
    void 사용자_입력_숫자_validate_틀린_자릿수_값_입력_테스트(){
        String playerNumber = "34";
        String errorMessage = "숫자 세 자리를 입력해주세요.";

        Throwable throwable = catchThrowable(()->{
            numberValidator.validateData(playerNumber);
        });
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable).hasMessage(errorMessage);
    }

    @Test
    void 사용자_입력_숫자_validate_같은_자릿수_입력_테스트(){
        String playerNumber = "333";
        String errorMessage = "서로 다른 세자리의 숫자만 입력 가능합니다.";

        Throwable throwable = catchThrowable(()->{
            numberValidator.validateData(playerNumber);
        });
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable).hasMessage(errorMessage);
    }

    @Test
    void 사용자_입력_숫자_validate_2개_같은_자릿수_입력_테스트(){
        String playerNumber = "334";
        String errorMessage = "서로 다른 세자리의 숫자만 입력 가능합니다.";

        Throwable throwable = catchThrowable(()->{
            numberValidator.validateData(playerNumber);
        });
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable).hasMessage(errorMessage);
    }

    @Test
    void 사용자_입력_숫자_validate_다른_범위_자릿수_입력_테스트(){
        String playerNumber = "039";
        String errorMessage = "1~9 사이의 숫자만 입력 가능합니다.";

        Throwable throwable = catchThrowable(()->{
            numberValidator.validateData(playerNumber);
        });
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable).hasMessage(errorMessage);
    }

    @Test
    void 사용자_입력_숫자_validate_다른_범위_알파벳_자릿수_입력_테스트(){
        String playerNumber = "a39";
        String errorMessage = "1~9 사이의 숫자만 입력 가능합니다.";

        Throwable throwable = catchThrowable(()->{
            numberValidator.validateData(playerNumber);
        });
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable).hasMessage(errorMessage);
    }

    @Test
    void 사용자_입력_숫자_validate_다른_범위_숫자_알파벳_자릿수_입력_테스트(){
        String playerNumber = "a30";
        String errorMessage = "1~9 사이의 숫자만 입력 가능합니다.";

        Throwable throwable = catchThrowable(()->{
            numberValidator.validateData(playerNumber);
        });
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable).hasMessage(errorMessage);
    }

    @Test
    void 게임_재시작_입력_숫자_유효성_검사_정상(){
        String inputNumber = "1";
        assertThat(gameController.wantRestart(inputNumber)).isTrue();
    }

    @Test
    void 게임_종료_입력_숫자_유효성_검사_정상(){
        String inputNumber = "2";
        assertThat(gameController.wantRestart(inputNumber)).isFalse();
    }

    @Test
    void 재시작_종료_입력_숫자_유효성_검사_오류(){
        String playerInput = "9";
        String errorMessage = "1 혹은 2만 입력 가능합니다.";

        Throwable throwable = catchThrowable(()->{
            gameController.wantRestart(playerInput);
        });
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable).hasMessage(errorMessage);

    }
}
