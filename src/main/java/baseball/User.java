package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class User {
    static String readLine() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String result = in.readLine();
        if(result.length() != 3){
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }
        return result;
    }
}
