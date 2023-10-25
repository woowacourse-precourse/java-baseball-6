package baseball.view;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class ConsoleOutput implements OutPut {
    private final BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    @Override
    public void gameStart() throws IOException {
        output.write(ConsoleMessage.GAME_START.getMessage());
        output.flush();
    }

    @Override
    public void print(String msg) throws IOException {
        output.write(msg);
        output.flush();
    }

    @Override
    public void printResult(int strikeCount, int ballCount) throws IOException {
        if(ballCount == 0 && strikeCount == 0) {
            output.write(ConsoleMessage.NOTHING.getMessage());
        }
        else {
            if(ballCount > 0) {
                output.write(String.valueOf(ballCount) + ConsoleMessage.BALL.getMessage());
            }
            if(strikeCount > 0) {
                output.write(String.valueOf(strikeCount) + ConsoleMessage.STRIKE.getMessage());
            }
        }
        output.newLine();
        output.flush();
    }

    @Override
    public void collect(int strikeCount) throws IOException {
        output.write(String.valueOf(strikeCount));
        output.write(ConsoleMessage.CORRECT_ANSWER.getMessage());
        output.flush();
    }

    @Override
    public void close() throws IOException {
        if(output != null) {
            output.close();
        }
    }
}
