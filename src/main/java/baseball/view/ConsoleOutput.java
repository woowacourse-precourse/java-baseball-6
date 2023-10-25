package baseball.view;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class ConsoleOutput {
    private static final BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void gameStart() {
//        output.write(ConsoleMessage.GAME_START.getMessage());
//        output.flush();
        try {
            output.write(ConsoleMessage.GAME_START.getMessage());
            output.flush();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static void print(String msg) {
        try {
            output.write(msg);
            output.flush();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static void collect(){
        try {
            output.write(ConsoleMessage.CORRECT_ANSWER.getMessage());
            output.flush();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static void close() {
        try {
            if(output != null) {
                output.close();
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
