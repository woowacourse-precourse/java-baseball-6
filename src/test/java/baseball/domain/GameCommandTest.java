package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameCommandTest {

    @ParameterizedTest
    @ValueSource(strings = {"1","2"})
    void 정상_입력이면_예외가_발생하지_않는다(String input){
        assertThatCode(() -> GameCommand.from(input))
                .doesNotThrowAnyException();
    }

    @Test
    void 입력값이_1이면_재시작이다(){
        GameCommand gameCommand = GameCommand.from("1");
        assertThat(gameCommand).isEqualTo(GameCommand.RESTART);
        assertThat(gameCommand.isRestart()).isEqualTo(true);
    }
    @Test
    void 입력값이_2이면_종료이다(){
        GameCommand gameCommand = GameCommand.from("2");
        assertThat(gameCommand).isEqualTo(GameCommand.EXIT);
        assertThat(gameCommand.isRestart()).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(strings = {"13","26","3","0","4","6"})
    void 값이_1또는_2가_아니면_예외가_발생한다(String input){
        assertThatThrownBy(() -> GameCommand.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
