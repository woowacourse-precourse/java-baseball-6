package baseball.view;

import baseball.constants.Message;
import baseball.dto.input.BaseballDto;
import baseball.dto.input.ReplayDto;
import baseball.io.InputReader;
import baseball.io.OutputWriter;

public class InputView {

    private final InputReader reader;
    private final OutputWriter writer;

    public InputView(InputReader reader, OutputWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public BaseballDto inputNumber() {
        writer.write(Message.INPUT_NUMBER);

        String input = reader.readLine();
        return new BaseballDto(input);
    }

    public ReplayDto replayGame() {
        writer.write(Message.INPUT_REPLAY);

        String input = reader.readLine();
        return new ReplayDto(input);
    }
}
