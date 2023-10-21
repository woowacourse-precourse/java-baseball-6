package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class User {
    List<Integer> number = new ArrayList<>();
    public String readLine() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String result;
        try {
            result = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(result.length() != 3){
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }
        number = convertStringToIntegerArray(result);
        return result;
    }

    private ArrayList<Integer> convertStringToIntegerArray(String result) {
        ArrayList<Integer> userNumber = new ArrayList<>();
        String[] splitResult = result.split("");
        Stream<String> stream = Arrays.stream(splitResult);
        stream.forEach(s -> userNumber.add(Integer.parseInt(s)));
        return userNumber;
    }
}
