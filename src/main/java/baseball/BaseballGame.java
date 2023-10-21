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

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String inputNumber = Console.readLine();
            // TODO: inputNumber 예외 처리

            User user = new User(inputNumber);
            System.out.println(user.getNumbers());

            Umpire umpire = new Umpire();
            umpire.compareUserWithComputer(user.getNumbers(), computer.getNumbers());
            if (umpire.isThreeStrike()) {
                break;
            }
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        exist();
    }

    public void exist() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int inputMode = Integer.parseInt(Console.readLine());
        // TODO: inputMode 예외 처리

        if (inputMode == 1) {
            run();  // 재시작
        }  // 완전히 종료
    }
}
