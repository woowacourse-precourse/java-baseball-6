package baseball.player;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;

public class UserPlayer {

    static final String USER_INVALID_INPUT_ERROR = "입력 값이 유효하지 않습니다.";
    private static final int digits = 3;
    static HashSet<Integer> user = new HashSet<>();

    public void input() {
        String number = Console.readLine();
        for(int i = 0; i < number.length(); i++) {
            user.add(number.charAt(i) - '0');
        }

        validate();
    }

    private void validate() {
        if(user.size() != digits) {
            clear();
            throw new IllegalArgumentException(USER_INVALID_INPUT_ERROR);
        }
    }

    private void clear() {
        this.user.clear();
    }
}
