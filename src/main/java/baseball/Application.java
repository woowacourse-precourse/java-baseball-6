package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        if (input.length() != 3) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c < '0' || c > '9') {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }
    }
}
