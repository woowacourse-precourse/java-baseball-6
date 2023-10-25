package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerTest {

    Player player = new Player();

    @Test
    public void inputContains3Number() throws Exception {
        //given

        //when
        Assertions.assertThatThrownBy(
                        () ->
                                player.getInput("12"),
                        Player.INPUT_MUST_3_NUMBER_EXCEPTION)
                .isInstanceOf(IllegalArgumentException.class);
        //then
    }

    @Test
    public void input_must_not_duplicated() throws Exception {
        //given
        //when
        Assertions.assertThatThrownBy(
                        () ->
                                player.getInput("111"),
                        Player.INPUT_MUST_NOT_DUPLICATED_EXCEPTION)
                .isInstanceOf(IllegalArgumentException.class);
        //then
    }

    @Test
    public void numeric_exception_in_getInput() throws Exception {
        //given

        //when
        Assertions.assertThatThrownBy(
                        () ->
                                player.getInput("a"),
                        Player.NUMBER_FORMAT_EXCEPTION)
                .isInstanceOf(IllegalArgumentException.class);

        //then
    }

    @Test
    public void success_getInput() throws Exception {
        //given

        //when
        Assertions.assertThatNoException()
                .isThrownBy(() -> player.getInput("123"));

        //then
    }

    @Test
    public void numericException_in_restart() throws Exception {
        //given
        //when
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> player.restart("a"))
                .withMessage(Player.NUMBER_FORMAT_EXCEPTION);

        //then
    }

    @Test
    public void wrongInput_in_restart0() throws Exception {
        //given

        //when
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> player.restart("0"))
                .withMessage(Player.WRONG_INPUT_IN_RESTART_EXCEPTION);

        //then
    }

    @Test
    public void wrongInput_in_restart_3() throws Exception {
        //given

        //when
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> player.restart("3"))
                .withMessage(Player.WRONG_INPUT_IN_RESTART_EXCEPTION);

        //then
    }

    @Test
    public void restart_returns_true_when_1_input() throws Exception {
        //given
        //when
        boolean restart = player.restart("1");

        //then
        Assertions.assertThat(restart)
                .isTrue();
    }

    @Test
    public void restart_returns_false_when_2_input() throws Exception {
        //given
        //when
        boolean restart = player.restart("2");

        //then
        Assertions.assertThat(restart)
                .isFalse();
    }
}