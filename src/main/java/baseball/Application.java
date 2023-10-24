package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        Computer computer = new Computer();

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            Player player = new Player(Console.readLine());
            System.out.println(computer.compare(player));

            if ("3스트라이크".equals(computer.compare(player))) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }
}
