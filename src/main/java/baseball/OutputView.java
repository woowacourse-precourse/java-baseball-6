package baseball;


import static baseball.ViewMessages.OUTPUT_DONE;
import static baseball.ViewMessages.OUTPUT_START;

import java.text.MessageFormat;

public class OutputView {
    private OutputView() {
    }

    public static void printStart() {
        System.out.println(OUTPUT_START);
    }

    public static void printBaseballResult(BaseballResultDto dto) {
        String message = MessageFormat.format(dto.messageFormat(), dto.ballCnt(), dto.strikeCnt());
        System.out.println(message);
    }

    public static void printDone() {
        System.out.println(OUTPUT_DONE);
    }
}
