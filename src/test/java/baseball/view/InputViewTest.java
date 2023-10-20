package baseball.view;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputViewTest {
    private static InputView view;

    @BeforeAll
    static void 뷰_초기화(){
        view=new InputView();
    }

    @DisplayName("사용자 Numbers 입력 기능")
    @Test
    void 사용자_Numbers_입력_테스트(){
        String input="123";
        InputStream in=new ByteArrayInputStream((input).getBytes());
        System.setIn(in);

        assertThat(view.inputNumbers()).isEqualTo(input);
    }

    @DisplayName("사용자 게임 재시작 여부 입력 기능")
    @Test
    void 사용자_재시작_입력_테스트(){
        String input="1";
        InputStream in=new ByteArrayInputStream((input).getBytes());
        System.setIn(in);

        assertThat(view.inputContinue()).isEqualTo(input);
    }

}
