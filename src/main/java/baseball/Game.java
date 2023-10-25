package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private Computer computer;
    private String input;

    public Game() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer = new Computer();
    }

    public boolean start() {
        boolean flag = true;
        computer.init();

        while (flag) {
            print(1);

            if (computer.check(input)) {
                flag = false;
                print(2);

                if (input.equals("1"))
                    return true;
            }
        }

        return false;
    }

    private void print(int type) {
        if (type == 1) {
            System.out.print("숫자를 입력해주세요 : ");
        } else {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }

        input = Console.readLine();
        checkInput(type);
    }

    private void checkInput(int type) {
        if (type == 1) {
            if (input.length() != 3)
                throw new IllegalArgumentException();

            // input 3글자에 같은 숫자가 있는지 확인 (ex. 111, 112, ...)
            for (int i = 0; i < 3; i++) {
                // 입력값이 숫자인지 확인
                if(input.charAt(i) < '1' || input.charAt(i) > '9')
                    throw new IllegalArgumentException();

                for (int j = 0; j < 3; j++) {
                    if (i == j)
                        continue;

                    if (input.charAt(i) == input.charAt(j))
                        throw new IllegalArgumentException();
                }
            }

        } else {
            if (!(input.equals("1") || input.equals("2")))
                throw new IllegalArgumentException();
        }
    }
}
