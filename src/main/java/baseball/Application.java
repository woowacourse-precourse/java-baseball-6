package baseball;

import camp.nextstep.edu.missionutils.Console;

import static baseball.GameManager.getInstance;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            getInstance().startGame();

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String answer = Console.readLine();
            if (answer.equals("1"))
                continue;
            if (answer.equals("2"))
                break;
            else
                throw new IllegalArgumentException();
        }
    }
}
