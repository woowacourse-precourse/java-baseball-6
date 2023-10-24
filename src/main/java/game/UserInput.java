package game;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {

    private static Validation validation = new Validation();

    // 입력, 입력 검사
    public String Input() {
        String input = Console.readLine();
        validation.validation_check(input);
        return input;
    }

    // 게임 재시작/종료 입력
    public static boolean restart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return validation.change(Console.readLine());
    }
}
