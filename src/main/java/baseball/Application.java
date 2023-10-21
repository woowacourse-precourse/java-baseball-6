package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다");

        final BaseBall baseBall = new BaseBall(3);
        while (true) {
            System.out.println("숫자를 입력해주세요 : ");
            List<Integer> player = NumberParser.parseIntegerList(Console.readLine());
            baseBall.doGame(player);

            if (baseBall.isOver()) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int operation = NumberParser.parseSingleDigitNumber(Console.readLine());
                if (operation == 1) {
                    baseBall.newGame();
                } else {
                    break;
                }
            }
        }
    }
}
