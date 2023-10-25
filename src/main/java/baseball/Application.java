package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            new BaseballGame().play();
            if (!askRestart()) {
                break;
            }
        }
    }

    private static boolean askRestart() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
        String choice = Console.readLine();
        return "1".equals(choice);
    }
}
