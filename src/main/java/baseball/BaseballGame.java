package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {

    // 게임 시작
    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        run();
    }

    // 게임 실행
    public void run() {
        Computer computer = new Computer();
        System.out.println(computer.getNumbers());

        System.out.print("숫자를 입력해주세요 : ");
        String inputNumber = Console.readLine();
        User user = new User(inputNumber);
        System.out.println(user.getNumbers());

        exist();
    }

    // 게임 종료
    public void exist() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int inputMode = Integer.parseInt(Console.readLine());
        if (inputMode == 1) {
            run();  // 재시작
        } else if (inputMode == 2) {
            // 완전히 종료
        }
    }
}
