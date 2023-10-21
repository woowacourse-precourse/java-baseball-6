package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class PlayGame {
    String userInputNumber;

    public String inputRandomBall() throws IOException {
        System.out.print("숫자를 입력해주세요 : ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        userInputNumber = br.readLine();

        return userInputNumber;
    }
}
