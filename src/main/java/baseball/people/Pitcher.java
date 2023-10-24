package baseball.people;

import camp.nextstep.edu.missionutils.Console;

public class Pitcher {

    Pitcher() {
    }

    /**
     * Pitcher 객체를 생성하는 정적 팩토리 메서드
     * @return Pitcher 객체
     */
    public static Pitcher enter() {
        return new Pitcher();
    }

    /**
     * 사용자의 입력을 받아서 정수 배열로 변환하는 메서드
     * @return 길이 3인 정수(int 타입) 배열
     */
    public int[] pitch() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        if (!isValidInput(input)) {
            throw new IllegalArgumentException();
        }

        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = (input.charAt(i) - '0');
        }
        return numbers;
    }

    /**
     * 게임 재시작 여부를 판단하는 메서드
     * @return boolean 값
     */
    public boolean restart() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
        String input = Console.readLine();
        if (input.equals("1")) {
            return true;
        }
        if (input.equals("2")) {
            Console.close();
            return false;
        }

        throw new IllegalArgumentException();
    }

    private boolean isValidInput(String input) {
        if (input.length() != 3) {
            return false;
        }

        boolean[] duplicationCheck = new boolean[10];
        for (int i = 0; i < 3; i++) {
            char c = input.charAt(i);
            if (c < '1' || c > '9' || duplicationCheck[(c - '0')]) {
                return false;
            }
            duplicationCheck[(c - '0')] = true;
        }

        return true;
    }
}
