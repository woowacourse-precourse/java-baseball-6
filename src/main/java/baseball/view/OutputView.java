package baseball.view;

import static baseball.utils.ViewMessages.OUTPUT_DONE;
import static baseball.utils.ViewMessages.OUTPUT_START;

import baseball.dto.ResultDto;
import java.text.MessageFormat;

public class OutputView {
    public static void printStart() {
        System.out.println(OUTPUT_START);
    }

    public static void printBaseballResult(ResultDto dto) {
        String message = MessageFormat.format(dto.messageFormat(), dto.ball(), dto.strike());
        System.out.println(message);
    }

    public static void printGameOver() {
        System.out.println(OUTPUT_DONE);
    }
}
