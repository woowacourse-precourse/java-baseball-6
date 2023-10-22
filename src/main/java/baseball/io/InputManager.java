package baseball.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class InputManager {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public String readGameInput() throws IOException {
        String input = br.readLine();

        validateGameInput(input);

        return input;
    }

    public void validateGameInput(String gameInput) {
        String regex = "^[1-9]{3}$";
        Pattern pattern = Pattern.compile(regex);

        boolean result = pattern.matcher(gameInput).matches();

        if(result == false) {
            throw new IllegalArgumentException();
        }
    }

    public String readRestartInput() throws IOException {
        String input = br.readLine();

        validateRestartInput(input);

        return input;
    }

    public void validateRestartInput(String restartInput) {
        String regex = "^[1-2]$";
        Pattern pattern = Pattern.compile(regex);

        boolean result = pattern.matcher(restartInput).matches();

        if(result == false) {
            throw new IllegalArgumentException();
        }
    }
}
