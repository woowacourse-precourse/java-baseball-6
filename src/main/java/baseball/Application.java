package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        User user = new User();
        Computer computer = new Computer();

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            user.writeNumber();
            String hint = user.getHint(computer);
            if (hint.equals("3스트라이크")) {
                System.out.println(hint);
                System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String command = Console.readLine();
                if (command.equals("1")) {
                    computer = new Computer();
                } else if (command.equals("2")) {
                    break;
                }
            } else {
                System.out.println(hint);
            }
        }
    }
}
