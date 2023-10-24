package baseball.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;

public class InputHandler {
    // 숫자 입력
    public String getNumber() {
        String param = Console.readLine().trim();

        if (param.length() != 3 || !isInteger(param) || !isUnique(param)) {
            throw new IllegalArgumentException();
        }

        return param;
    }

    // 명령어 숫자 입력
    public String getCommand() {
        String param = Console.readLine().trim();

        if (param.length() != 1 || !isInteger(param) || !isCommand(param)) {
            throw new IllegalArgumentException();
        }

        return param;
    }

    // 숫자인지 확인
    private boolean isInteger(String param) {
        try {
            Integer.parseInt(param);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 모두 다른 숫자인지 확인
    private boolean isUnique(String param) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < param.length(); i++) {
            set.add(param.charAt(i));
        }

        if (set.size() == 3) {
            return true;
        }
        return false;
    }

    // 명령어인지 확인
    private boolean isCommand(String param) {
        int n = Integer.parseInt(param);
        if (n == 1 || n == 2) {
            return true;
        }
        return false;
    }

}
