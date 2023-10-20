package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean restart;
        do {

            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
            restart = Console.readLine().equals("1");
        } while (restart);
    }
}
