package baseball.controller;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputTest extends NsTest {

    @Test
    @DisplayName("힌트 메시지 1볼 확인")
    public void simpleOutputTest(){
        String message ="1볼";
        OutputView.showHint(message);
        run();
        assertThat(output()).contains(message);
    }

    @Override
    protected void runMain() {

    }
}
