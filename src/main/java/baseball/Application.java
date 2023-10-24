package baseball;

import baseball.service.GameService;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        do {
            GameService.run();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        } while (!Console.readLine().equals("2"));
    }
}
