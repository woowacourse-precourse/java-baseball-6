package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        run();
    }

    public void run() {
        Computer computer = new Computer();
        System.out.println(computer.getNumbers());

        exist();
    }

    public void exist() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int inputMode = Integer.parseInt(Console.readLine());
        if (inputMode == 1) {
            run();
        } else if (inputMode == 2) {
        }
    }
}
