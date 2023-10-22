package baseball;

import baseball.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewViewTest {
    OutputView script = new OutputView();
    @Test
    @DisplayName("안내 문구 테스트")
    public void basicScriptTest(){
        script.printStartMessage();
        script.printInputMessage();
        script.printResultMessage(1,1);
        script.printResultMessage(0,1);
        script.printResultMessage(0,2);
        script.printResultMessage(1,0);
        script.printResultMessage(3,0);
        script.printEndMessage();
    }

}