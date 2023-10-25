package view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest{

    @Test
    @DisplayName("게임을 재시작하고 싶을 때, 1을 입력해야 한다.")
    void 재시작_입력(){
        String input="1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        InputView inputView=new InputView();

        boolean restart=inputView.restart();
        Assertions.assertThat(restart).isEqualTo(true);
    }

}