package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Controller {
    private CheckException checkException = new CheckException();
    private Computer computer = new Computer();
    private User user = new User();
    private Print print = new Print();
    private Compare compare = new Compare();

    public void start() {
        print.print_start();
        // 프로그램 종료 후, 재시작 혹은 종료 값을 저장하기 위함 (재시작 = 1, 종료 = 2, 그 외 = 예외)

        computer.computerSetting();

        // 메인 로직 실행
        while (true) {
            print.print_input();
            user.input();
            int[] score = compare.compare(computer.getComputer(), user.getUser_input());
            print.print_output(score);
            if (score[0] == 3) {
                print.print_end();
                break;
            }
        }

        if (key() == 1) {
            start();
        } else {
            return;
        }
    }

    private int key() {
        int key = 0;
        key = Integer.parseInt(Console.readLine());
        checkException.checkException_Exit(key);

        return key;
    }
}
