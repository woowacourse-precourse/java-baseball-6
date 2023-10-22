package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

import static baseball.Application.userNumbers;

public class PlayGame {
    String userInputNumber;

    public String inputRandomBall() throws IOException {
        if(userNumbers.isEmpty()) initUserNumbers();
        System.out.print("숫자를 입력해주세요 : ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        userInputNumber = br.readLine();

        return userInputNumber;
    }

    private void initUserNumbers() {
        for(int i=0; i<3; i++){
            userNumbers.add(i);
        }
    }
}
