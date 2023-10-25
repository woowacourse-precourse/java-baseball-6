package baseball;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    /**
     * 사용자의 입력을 검증 후 적절하다면 입력받은 숫자를 리스트 형태로 반환하는 함수 만약 적절하지 않은 입력이라면 IllegalArgumentException을 발생시킨 후 애플리케이션을 종료
     */
    public static List<Integer> inputToList(String input) {
        List<Integer> user = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            int x = input.charAt(i) - '0';
            if (Number.MIN_INPUT <= x && x <= Number.MAX_INPUT) {
                //중복된 수를 입력
                if (user.contains(x)) {
                    throw new IllegalArgumentException("중복된 수를 입력하셨습니다. 1에서 9까지 서로 다른 수를 입력해 주세요.");
                }
                user.add(x);
            }
            //1부터 9까지의 수가 아닌 다른 문자를 입력
            else {
                throw new IllegalArgumentException("1부터 9까지 서로 다른 수만 공백 없이 입력해 주세요.");
            }
        }

        //숫자를 3개 입력하지 않은 경우
        if (user.size() != Number.NUMBER_LEN) {
            throw new IllegalArgumentException("숫자를 3개 입력해 주세요.");
        }
        return user;
    }

    /**
     * 게임이 끝난 경우 재시작/종료 구 입력은 1과 2 중 하나의 수
     */
    public static boolean checkRestartInput(String input) {
        //문자를 두 개 이상 입력
        if (input.length() != Number.EXIT_LEN) {
            throw new IllegalArgumentException("1이나 2 하나만 공백없이 입력해야 합니다.");
        }

        if (input.charAt(0) - '0' == Number.RESTART_INPUT) { //재시작
            return true;
        } else if (input.charAt(0) - '0' == Number.END_INPUT) { //종료
            return false;
        } else { //입력이 1이나 2가 아닌 경우
            throw new IllegalArgumentException("1이나 2를 입력해야 합니다.");
        }
    }
}
