package baseball;

import baseball.utils.GameState;
import baseball.utils.Utils;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {

    private final static int NUMBER_COUNT = 3;

    public static void main(String[] args) {
    }

    public static GameState startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        return GameState.EXIT;
    }


    private static int getUserInput() {
        int result = 0;

        System.out.println("숫자를 입력해 주세요");
        String strInput = Console.readLine();

        // 사용자 입력이 3자리 이상의 입력인 경우 예외 던지기
        if (strInput.length() != NUMBER_COUNT) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }

        // 사용자 입력이 정수가 아닌 경우 예외 던지기
        try {
            result = Integer.parseInt(strInput);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("정수를 입력해주세요.");
        }

        // 중복 되지 않는 3개의 숫자를 입력 받고 그 이외는 예외 던지기
        List<Integer> integers = Utils.parseDigits(result);
        boolean[] isUsed = new boolean[10];

        for (Integer integer : integers) {
            if (isUsed[integer]) {
                throw new IllegalArgumentException("중복 되지 않은 3개의 숫자를 입력해주세요.");
            }
            isUsed[integer] = true;
        }

        // 1 ~ 9까지의 숫자를 입력 받도록 하고 그 이외는 예외 던지기
        for (Integer integer : integers) {
            if (integer == 0) {
                throw new IllegalArgumentException("1부터 9까지의 숫자를 입력해주세요.");
            }
        }

        return result;
    }


}
