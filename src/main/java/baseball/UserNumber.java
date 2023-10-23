package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserNumber {

    public List<Integer> getUserNumber() {
        List<Integer> userNumber = new ArrayList<>();
        String readLine = getReadLine();
        return userNumber;
    }

    private String getReadLine() {
        return Console.readLine();
    }

    private void checkLength(String word) {
        if (word.length() != 3) {
            throw new IllegalArgumentException("입력한 수가 3자리가 아닙니다.");
        }
    }

    public void TestFunction(String word) {
        checkLength(word);
    }
}
