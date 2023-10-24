package baseball.moduleTest;

import baseball.view.Output;
import org.junit.jupiter.api.Test;

public class PrintTest {

    @Test
    void 출력_테스트() {
        Output output = new Output();
        output.printHint(1, 1);
        output.printHint(0, 1);
        output.printHint(0, 0);
        output.printHint(1, 0);
        output.printHint(3, 0);
    }
}
