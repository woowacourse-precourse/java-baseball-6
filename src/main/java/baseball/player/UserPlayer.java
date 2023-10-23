package baseball.player;

import static baseball.common.Constants.numDigit;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class UserPlayer {

    static final String USER_INVALID_INPUT_ERROR = "입력 값이 유효하지 않습니다.";
    static final String USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    static HashSet<Integer> user;

    public void input() {
        System.out.printf(USER_INPUT_MESSAGE);
        String number = Console.readLine();
        user = new LinkedHashSet<>();
        for(int i = 0; i < number.length(); i++) {
            user.add(number.charAt(i) - '0');
        }

        validate();
    }

    private void validate() {
        if(user.size() > numDigit) {
            throw new IllegalArgumentException(USER_INVALID_INPUT_ERROR);
        }

        if(user.contains(0)) {
            throw new IllegalArgumentException(USER_INVALID_INPUT_ERROR);
        }
    }

    private void clear() {
        this.user.clear();
    }

    public List<Integer> getUserNumber() {
        return user.stream().collect(Collectors.toList());
    }
}
