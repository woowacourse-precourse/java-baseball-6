package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class StartNumberFromUserTest {

    StartNumberFromUser startNumberFromUser = new StartNumberFromUser();

    @AfterEach
    void closeScanner() {
        Console.close();
    }

    @Test
    void 인풋으로_1을_받을_시_해당_값을_반환한다() {
        // given
        String input = "1";
        settingForInputStream(input);

        // when
        int startNumber = startNumberFromUser.getValue();

        // then
        assertThat(startNumber).isEqualTo(1);
    }

    @Test
    void 인풋으로_2을_받을_시_해당_값을_반환한다() {
        // given
        String input = "2";
        settingForInputStream(input);

        // when
        int startNumber = startNumberFromUser.getValue();

        // then
        assertThat(startNumber).isEqualTo(2);
    }

    @Test
    void 인풋으로_1과_2_이외의_수를_받을시_에러를_던진다() {
        // given
        String input = "5";
        settingForInputStream(input);

        // when & then
        assertThatThrownBy(() -> startNumberFromUser.getValue()).isInstanceOf(
            IllegalArgumentException.class);
    }

    @Test
    void 인풋으로_숫자가_아닌_값을_받을시_어레를_던진다() {
        // given
        String input = "5ab";
        settingForInputStream(input);

        // when & then
        assertThatThrownBy(() -> startNumberFromUser.getValue()).isInstanceOf(
            IllegalArgumentException.class);
    }

    private void settingForInputStream(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

}