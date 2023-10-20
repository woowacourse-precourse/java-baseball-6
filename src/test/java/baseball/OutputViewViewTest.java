package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewViewTest {
    OutputView script = new OutputView();
    @Test
    @DisplayName("안내 문구 테스트")
    public void basicScriptTest(){
        script.printStart();
        script.printInputMessage();
        script.printResult(1,1);
        script.printResult(0,1);
        script.printResult(0,2);
        script.printResult(1,0);
        script.printResult(3,0);
        script.printEnd();
    }

}