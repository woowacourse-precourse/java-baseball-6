package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) throws IllegalArgumentException {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.println("000을 입력하면 게임을 새로 시작하거나 종료할 수 있습니다.");
        while(true) {
            Input computer = new Input();
            computer.setRandomNumber();
            do {
                Input player = new Input();
                System.out.print("숫자를 입력해주세요 : ");
                String input = Console.readLine();
                if (input.equals("000")) {
                    break;
                }
                player.setPlayerNumber(input);
                Comparison.compare(computer, player);
            } while (!Comparison.isOver());

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String endInput = Console.readLine();
            if (Input.isEnd(endInput)) {
                break;
            }
        }
    }
}