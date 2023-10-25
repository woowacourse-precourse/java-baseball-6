package baseball.people;

import static baseball.people.Message.ASK_TO_RESTART;
import static baseball.people.Message.DEMAND_INPUT;
import static baseball.people.Message.QUIT;
import static baseball.people.Message.RESTART;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Pitcher {
    private static final int PROPER_LENGTH = 3;

    private Pitcher() {
    }

    /**
     * Pitcher 객체를 생성하는 정적 팩토리 메서드
     *
     * @return Pitcher 객체
     */
    public static Pitcher enter() {
        return new Pitcher();
    }

    /**
     * 사용자의 입력을 받아서 정수 리스트로 변환하는 메서드
     *
     * @return 크기가 3인 정수 리스트
     */
    public List<Integer> pitch() {
        System.out.print(DEMAND_INPUT.getMessage());
        String input = Console.readLine();

        if (!isValidInput(input)) {
            throw new IllegalArgumentException();
        }

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            numbers.add(input.charAt(i) - '0');
        }

        return numbers;
    }

    /**
     * 게임 재시작 여부를 판단하는 메서드
     *
     * @return boolean 값
     */
    public boolean restart() {
        System.out.print(ASK_TO_RESTART.getMessage());
        String input = Console.readLine();

        if (input.equals(RESTART.getMessage())) {
            return true;
        }

        if (input.equals(QUIT.getMessage())) {
            Console.close();
            return false;
        }

        throw new IllegalArgumentException();
    }

    private boolean isValidInput(String input) {
        if (input.length() != PROPER_LENGTH) {
            return false;
        }

        boolean[] duplicationCheck = new boolean[10];
        for (char c : input.toCharArray()) {
            if (c < '1' || c > '9' || duplicationCheck[(c - '0')]) {
                return false;
            }
            duplicationCheck[(c - '0')] = true;
        }

        return true;
    }
}
