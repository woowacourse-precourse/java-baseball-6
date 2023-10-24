package baseball.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public String inputNumber(){
        try {
            return br.readLine();
        } catch (IOException e) {
            return "-1"; //?
        }
    }
    public String restartInputNumber(){
        try {
            String restartNumber = br.readLine();
            if (!restartNumber.equals("1") && !restartNumber.equals("2")) {
                throw new IllegalArgumentException("올바른 입력이 아닙니다.");
            }
            return restartNumber;
        } catch (IOException e) {
            return "-1";
        }
    }
}
