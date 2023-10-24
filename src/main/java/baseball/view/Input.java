package baseball.view;

import baseball.utility.Constant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    private static Input input = new Input();

    private Input() {
    }

    public static Input getInput() {
        return input;
    }

    public int inputFromUser() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputValue;

        try {
            inputValue = Integer.parseInt(br.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException(Constant.WRONG_INPUT + Constant.PROGRAM_END);
        }

        br.close();

        return inputValue;
    }

}
