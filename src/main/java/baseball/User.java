package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    List<Integer> number = new ArrayList<>();

    public String consoleReadLine() {
        String result;
        result = readLine();
        if (result == null || result.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }
        number = convertStringToIntegerArray(result);
        return result;
    }

    public Integer readLineForRestartGame() {
        String result;
        result = readLine();
        return Integer.parseInt(result);
    }

    private ArrayList<Integer> convertStringToIntegerArray(String result) {
        ArrayList<Integer> userNumber = new ArrayList<>();
        String[] splitResult = result.split("");
        Stream<String> stream = Arrays.stream(splitResult);
        stream.forEach(s -> userNumber.add(Integer.parseInt(s)));
        return userNumber;
    }
}
