package baseball.module;

import baseball.dto.GameResult;
import baseball.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    OutputView script = new OutputView();
    @Test
    @DisplayName("안내 문구 테스트")
    public void basicScriptTest(){
        script.printStartMessage();
        script.printInputMessage();
        script.printResultMessage(new GameResult(1,1));
        script.printResultMessage(new GameResult(0,1));
        script.printResultMessage(new GameResult(0,2));
        script.printResultMessage(new GameResult(1,0));
        script.printResultMessage(new GameResult(3,0));
        script.printEndMessage();
        script.printRestartMessage();
    }

}