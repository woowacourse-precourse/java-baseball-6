package baseball.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class NumberBaseballGameOutputViewTest {

    @Test
    void 시작_메시지가_올바르게_출력되는지_테스트() {
        try (OutputStreamProvider provider = new OutputStreamProvider()) {
            NumberBaseballGameOutputView outputView = new NumberBaseballGameOutputView();
            outputView.printStartGameMessage();
            assertEquals("숫자 야구 게임을 시작합니다." + "\r\n", provider.getOutput());
        }
    }

    @Test
    void 숫자_입력을_요청하는_메시지가_올바르게_출력되는지_테스트() {
        try (OutputStreamProvider provider = new OutputStreamProvider()) {
            NumberBaseballGameOutputView outputView = new NumberBaseballGameOutputView();
            outputView.printNumberInputRequest();
            assertEquals("숫자를 입력해주세요." + "\r\n", provider.getOutput());
        }
    }
}