package baseball;

import java.util.HashSet;
import java.util.Set;

public class CheckForm { // 입력 관리
    private static String GAME_RESTART;
    private static String GAME_END;

    public CheckForm(String GAME_RESTART, String GAME_END) {
        this.GAME_RESTART = GAME_RESTART;
        this.GAME_END = GAME_END;
    }

    public static void Input(String number){
        Set<Integer> set;

        try {
            Integer.parseInt(number); // 숫자로 변환을 시도
        } catch (NumberFormatException e) { //만약 숫자가 아닌 값이 있다면 해당 예외 발생
            throw new IllegalArgumentException("ERROR: 숫자만을 입력해주세요");
        }

        set = checkDuplicate(number);
        if (number.length() != 3 || number.contains("0") || set.size()!=3) {
            throw new IllegalArgumentException("ERROR : 1~9의 서로다른 3자리 숫자를 입력해주세요");
        }

    }

    static void Restart_Input(String judge) {
        if (!judge.equals(GAME_RESTART) && !judge.equals(GAME_END)) {
            throw new IllegalArgumentException("ERROR: 정답을 맞추신 후, 1 또는 2의 숫자를 입력해주세요.");
        }
    }

    private static Set<Integer> checkDuplicate(String number){
        Set<Integer> set = new HashSet<>();

        int numberInt = Integer.parseInt(number);
        set.add(numberInt/100);
        set.add((numberInt/10)%10);
        set.add(numberInt%10);

        return set;
    }
}
