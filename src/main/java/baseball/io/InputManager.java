package baseball.io;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {

    public String readGameInput() throws IOException {
        String input = Console.readLine();


        validateGameInput(input);
        validateDuplicate(input);

        return input;
    }

    public void validateGameInput(String userInput) {
        String regex = "^[1-9]{3}$";
        Pattern pattern = Pattern.compile(regex);

        boolean result = pattern.matcher(userInput).matches();

        if(result == false) {
            throw new IllegalArgumentException();
        }
    }

    public void validateDuplicate(String userInput) {
        Set<Character> set = new HashSet<>();
        for(Character input : userInput.toCharArray()) {
            set.add(input);
        }

        if(set.size() != userInput.length()) {
            throw new IllegalArgumentException();
        }
    }

    public String readRestartInput() throws IOException {
        String input = Console.readLine();

        validateRestartInput(input);

        return input;
    }

    public void validateRestartInput(String userInput) {
        String regex = "^[1-2]$";
        Pattern pattern = Pattern.compile(regex);

        boolean result = pattern.matcher(userInput).matches();

        if(result == false) {
            throw new IllegalArgumentException();
        }
    }
}
