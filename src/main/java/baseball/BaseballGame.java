package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {

    public void start() {
        System.out.println(Constants.OUTPUT_GAME_START);
        run();
    }

    public void run() {
        Computer computer = new Computer();
        System.out.println(computer.getNumbers());

        while (true) {
            System.out.print(Constants.INPUT_USER_NUMBER);
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

        System.out.println(Constants.OUTPUT_GAME_END);
        exist();
    }

    public void exist() {
        System.out.println(Constants.INPUT_MODE_RESTART_OR_END);
        int inputMode = Integer.parseInt(Console.readLine());
        // TODO: inputMode 예외 처리

        if (inputMode == Constants.MODE_RESTART) {
            run();  // 재시작
        }  // 완전히 종료
    }
}
